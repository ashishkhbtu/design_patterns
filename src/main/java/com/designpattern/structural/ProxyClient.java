package com.designpattern.structural;

interface DatabaseService{
    void execute(String query) throws Exception;
}

class DatabaseExecutor implements DatabaseService{

    @Override
    public void execute(String query) {
        System.out.println("Execute Database Service");
    }
}

class DatabaseExecutorProxy implements DatabaseService{
    boolean isAdmin;
    DatabaseExecutor databaseExecutor;

    public DatabaseExecutorProxy(String name, String password) {
        if(name.equalsIgnoreCase("admin") &&
            password.equalsIgnoreCase("1234")){
            isAdmin = true;
        }
        databaseExecutor = new DatabaseExecutor();
    }

    @Override
    public void execute(String query) throws Exception {
        if(isAdmin){
            databaseExecutor.execute(query);
        }else{
            if(query.equalsIgnoreCase("delete")){
                throw new Exception("Delete operation not allowed");
            }else{
                databaseExecutor.execute(query);
            }
        }
    }
}

public class ProxyClient {

    public static void main(String[] args) throws Exception {
        DatabaseService databaseService = new DatabaseExecutorProxy("Nonadmin", "1234");
//        databaseService.execute("delete");

        DatabaseService databaseService1 = new DatabaseExecutorProxy("admin", "1234");
        databaseService1.execute("delete");
    }
}
