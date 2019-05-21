package ru.hse.alyokhina.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.hse.alyokhina.element.TextElement;

public class IssueInfoPage extends AbstractPage {
    private final TextElement summaryElement;
    private final TextElement descriptionElement;
    private final TextElement issueIdElement;

    public IssueInfoPage(WebDriver webDriver) {
        super(webDriver);
        summaryElement = new TextElement(webDriver, By.id("id_l.I.ic.icr.it.issSum"));
        descriptionElement = new TextElement(webDriver, By.id("id_l.I.ic.icr.d.description"));
        issueIdElement = new TextElement(webDriver, By.id("id_l.I.ic.icr.ii.iica"));
    }

    public String getSummary() {
        return summaryElement.get();
    }

    public String getDescription() {
        return descriptionElement.get();
    }

    public String getIssueId() {
        return issueIdElement.get();
    }
}
