package com.designpattern.structural;

import java.sql.Driver;

class Chrome{
    public static Driver getDriver(){
        return null;
    }

    public static void generateHTMLReport(String data, Driver driver){
        System.out.println("Chrome::Generate Html Report.");
    }

    public static void generateXMLReport(String data, Driver driver){
        System.out.println("Chrome::Generate XML Report.");
    }
}

class Firefox{
    public static Driver getDriver(){
        return null;
    }

    public static void generateHTMLReport(String data, Driver driver){
        System.out.println("Firefox::Generate Html Report.");
    }

    public static void generateXMLReport(String data, Driver driver){
        System.out.println("Firefox::Generate XML Report.");
    }
}

class WebExplorerfacade{
    public static void generateReport(String explorer, String type, String test){
        Driver driver;
        switch (explorer){
            case "chrome":
                driver = Chrome.getDriver();
                switch (type){
                    case "html":
                        Chrome.generateHTMLReport(test, driver);
                        break;
                    case "xml":
                        Chrome.generateXMLReport(test, driver);
                        break;
                }
                break;
            case "firefox":
                driver = Firefox.getDriver();
                switch (type){
                    case "html":
                        Firefox.generateHTMLReport(test, driver);
                        break;
                    case "xml":
                        Firefox.generateXMLReport(test, driver);
                        break;
                }
                break;
        }
    }
}

public class FacadeClient {
    public static void main(String[] args) {
        WebExplorerfacade.generateReport("chrome", "html", "HTML Report");
        WebExplorerfacade.generateReport("firefox", "xml", "XML Report");
    }
}
