package ru.hse.alyokhina.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractElement {
    protected final WebElement element;

    protected AbstractElement(WebElement element) {
        this.element = element;
    }

    protected AbstractElement(WebDriver webDriver, By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element = webDriver.findElement(by);
    }
}
