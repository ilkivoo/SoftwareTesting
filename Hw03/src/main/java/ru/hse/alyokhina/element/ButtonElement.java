package ru.hse.alyokhina.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonElement extends AbstractElement {

    public ButtonElement(WebElement element) {
        super(element);
    }

    public ButtonElement(WebDriver webDriver, By by) {
        super(webDriver, by);
    }

    public void click() {
        element.click();
    }
}
