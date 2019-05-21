package ru.hse.alyokhina.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.hse.alyokhina.element.ButtonElement;
import ru.hse.alyokhina.element.IssueElement;
import ru.hse.alyokhina.element.IssueListElement;

import java.util.AbstractMap;
import java.util.Map;

public class IssuesPage extends AbstractPage {
    private final IssueListElement issueListElement;

    public IssuesPage(WebDriver webDriver) {
        super(webDriver);
        clickShowDescription(webDriver);
        issueListElement = new IssueListElement(webDriver, By.id("id_l.I.c.il.issueList"));
    }

    @Override
    protected String getUrl() {
        return "http://localhost:8080/issues";
    }

    public Map.Entry<String, String> getSummaryAndDescription(final String issueId) {
        final IssueElement issueElement = issueListElement.getIssue(issueId);
        final String description = issueElement.getDescription();
        final String summary = issueElement.getSummary();
        issueElement.showInfo();
        return new AbstractMap.SimpleEntry<>(summary, description);
    }

    private void clickShowDescription(WebDriver webDriver) {
        final ButtonElement showDescription = new ButtonElement(webDriver, By.id("id_l.I.c.tb.detailLevelLink_9_2"));
        showDescription.click();
    }


}
