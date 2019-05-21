package ru.hse.alyokhina;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.hse.alyokhina.object.DashboardPage;
import ru.hse.alyokhina.object.IssueInfoPage;
import ru.hse.alyokhina.object.IssuesPage;
import ru.hse.alyokhina.object.LoginPage;
import ru.hse.alyokhina.object.NewIssuePage;

import java.util.Map;

import static org.junit.Assert.assertEquals;


public class Tests {
    private WebDriver webDriver;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.firefox.driver", "geckodriver");
    }

    @Before
    public void loginAsRoot() {
        webDriver = new FirefoxDriver();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login();
    }

    @After
    public void quit() {
        webDriver.quit();
    }

    @Test
    public void basicTest() {
        run("summary", "description");
    }

    @Test(expected = org.openqa.selenium.TimeoutException.class)
    public void emptySummary() {
        run("", "description");
    }

    @Test
    public void emptyDescription() {
        run("summary", "");
    }

    private void run(final String summary, final String description) {
        DashboardPage dashboardPage = new DashboardPage(webDriver);
        dashboardPage.createNewIssue();

        NewIssuePage newIssuePage = new NewIssuePage(webDriver);
        newIssuePage.createNewIssue(summary, description);

        IssueInfoPage issueInfoPage = new IssueInfoPage(webDriver);
        final String newIssueId = issueInfoPage.getIssueId();

        assertEquals(summary, issueInfoPage.getSummary());
        assertEquals(description.isEmpty() ? "No description" : description, issueInfoPage.getDescription());
        findIssueAndCmp(summary, description, newIssueId);
    }

    private void findIssueAndCmp(final String summary,
                                 final String description,
                                 final String issueId) {
        IssuesPage issuesPage = new IssuesPage(webDriver);
        Map.Entry<String, String> summaryAndDescription = issuesPage.getSummaryAndDescription(issueId);
        assertEquals(summary, summaryAndDescription.getKey());
        assertEquals(description, summaryAndDescription.getValue());
    }
}
