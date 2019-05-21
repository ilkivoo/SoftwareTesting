package ru.hse.alyokhina.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.hse.alyokhina.element.ButtonElement;


public class DashboardPage extends AbstractPage {

    final ButtonElement createNewIssue;

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
        createNewIssue = new ButtonElement(webDriver, By.className("yt-header__create-btn"));
    }

    public void createNewIssue() {
        createNewIssue.click();
    }

    @Override
    protected String getUrl() {
        return "http://localhost:8080/dashboard";
    }
}
