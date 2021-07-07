package com.designpattern.structural;

interface WebDriver{
    void getElement();
    void selectElement();
}

class ChromeDriver implements WebDriver{

    @Override
    public void getElement() {
        System.out.println("ChromeDriver:getElement");
    }

    @Override
    public void selectElement() {
        System.out.println("ChromeDriver:selectElement");
    }
}

class IEDriver{
    public void findElement(){
        System.out.println("IEDriver:findElement");
    }

    public void clickElement(){
        System.out.println("IEDriver:clickElement");
    }
}

class WebDriverAdapter implements WebDriver{
    IEDriver ieDriver = null;

    public WebDriverAdapter(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        ieDriver.findElement();
    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }
}
public class AdapterClient {
    public static void main(String[] args) {
        WebDriver chrome = new ChromeDriver();
        chrome.getElement();
        chrome.selectElement();

        IEDriver ieDriver = new IEDriver();
        ieDriver.findElement();
        ieDriver.clickElement();

        WebDriverAdapter webDriverAdapter = new WebDriverAdapter(ieDriver);
        webDriverAdapter.getElement();
        webDriverAdapter.selectElement();
    }
}