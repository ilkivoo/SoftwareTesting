package ru.hse.alyokhina.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class IssueElement extends AbstractElement {
    private final TextElement summaryElement;
    private final TextElement descriptionElement;
    private final ButtonElement issueIdElement;

    protected IssueElement(WebElement element) {
        super(element);
        summaryElement = new TextElement(element.findElement(By.className("issue-summary")));
        final List<WebElement> descriptionOrEmpty = element.findElements(By.className("description"));
        if (descriptionOrEmpty.isEmpty()) {
            descriptionElement = null;
        } else {
            descriptionElement = new TextElement(descriptionOrEmpty.get(0));
        }
        issueIdElement = new ButtonElement(element.findElement(By.className("issueId")));
    }

    public String getSummary() {
        return summaryElement.get();
    }

    public String getDescription() {
        if (descriptionElement == null) {
            return "";
        }
        return descriptionElement.get();
    }

    public void showInfo() {
        issueIdElement.click();
    }
}
