package ru.hse.alyokhina.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class IssueListElement extends AbstractElement {
    final List<WebElement> issues = new ArrayList<>();

    public IssueListElement(WebDriver webDriver, By by) {
        super(webDriver, by);
        List<WebElement> rows = element.findElements(By.className("issueContainer"));
        for (WebElement row : rows) {
            issues.add(row.findElement(By.className("issue-info")));
        }
    }

    public IssueElement getIssue(final String issueId) {
        for (WebElement issue : issues) {
            WebElement issueIdElement = issue.findElement(By.className("issueId"));
            if (issueId.equals(issueIdElement.getText())) {
                return new IssueElement(issue);
            }
        }
        return null;
    }
}
