package ru.hse.alyokhina.object;

import org.openqa.selenium.WebDriver;

abstract class AbstractPage {
    protected final String rootPassword = "123";
    protected final String rootLogin = "root";
    private final WebDriver webDriver;


    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        final String url = getUrl();
        if (url != null) {
            webDriver.get(url);
        }
    }

    protected String getUrl() {
        return null;
    }

}
