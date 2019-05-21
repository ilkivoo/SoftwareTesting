package ru.hse.alyokhina.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.hse.alyokhina.element.ButtonElement;
import ru.hse.alyokhina.element.TextElement;

public class NewIssuePage extends AbstractPage {
    private final TextElement summaryElement;
    private final TextElement descriptionElement;
    private final ButtonElement createIssueButton;

    public NewIssuePage(final WebDriver webDriver) {
        super(webDriver);
        summaryElement = new TextElement(webDriver, By.id("id_l.D.ni.ei.eit.summary"));
        descriptionElement = new TextElement(webDriver, By.id("id_l.D.ni.ei.eit.description"));
        createIssueButton = new ButtonElement(webDriver, By.id("id_l.D.ni.ei.submitButton_74_0"));
    }

    public void createNewIssue(final String summary, final String description) {
        summaryElement.set(summary);
        descriptionElement.set(description);
        createIssueButton.click();
    }

}
