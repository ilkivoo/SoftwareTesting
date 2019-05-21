package ru.hse.alyokhina.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextElement extends AbstractElement {

    public TextElement(WebElement webElement) {
        super(webElement);
    }

    public TextElement(WebDriver webDriver, By by) {
        super(webDriver, by);
    }

    public void set(String text) {
        element.sendKeys(text);
    }

    public String get() {
        return element.getText();
    }
}
