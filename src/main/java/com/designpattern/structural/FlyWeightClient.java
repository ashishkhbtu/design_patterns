package com.designpattern.structural;

import java.util.HashMap;
import java.util.Random;

interface Employee{
    void setSkill(String skill);
    void task();
}

class Developer implements Employee{
    String job;
    String skill;

    public Developer() {
        job = "FIX_THE_ISSUE";
    }

    @Override
    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "JOB='" + job + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}

class Tester implements Employee{
    String job;
    String skill;

    public Tester() {
        job = "RAISE_THE_ISSUE";
    }

    @Override
    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Tester{" +
                "JOB='" + job + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}

class EmployeeFactory{
    static HashMap<String, Employee> m = new HashMap<>();

    public static Employee getEmployee(String type){
        Employee e;
        e = m.get(type);
        if(e == null) {
            switch (type){
                case "DEVELOPER":
                    System.out.println("Developer Created.");
                    e = new Developer();
                    break;
                case "TESTER":
                    System.out.println("Tester Created.");
                    e = new Tester();
                    break;
            }
            m.put(type, e);
        }
        return e;
    }
}
public class FlyWeightClient {
    static String[] empTypes = {"DEVELOPER", "TESTER"};
    static String[] skills = {"JAVA", "C", "C++", "PYTHON", "JS"};
    public static void main(String[] args) {
        Employee e = null;
        for(int i = 1; i<=10; i++){
            e = EmployeeFactory.getEmployee(getRandomEmployee());
            e.setSkill(getRandomSkill());
            e.task();
        }
    }

    static String getRandomEmployee(){
        Random r = new Random();
        int index = r.nextInt(empTypes.length);
        return empTypes[index];
    }

    static String getRandomSkill(){
        Random r = new Random();
        int index = r.nextInt(skills.length);
        return skills[index];
    }
}
