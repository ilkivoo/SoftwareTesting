package ru.hse.alyokhina.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.hse.alyokhina.element.ButtonElement;
import ru.hse.alyokhina.element.TextElement;

public class LoginPage extends AbstractPage {
    private final TextElement loginElement;
    private final TextElement passwordElement;
    private final ButtonElement loginButton;

    public LoginPage(final WebDriver webDriver) {
        super(webDriver);
        loginElement = new TextElement(webDriver, By.id("id_l.L.login"));
        passwordElement = new TextElement(webDriver, By.id("id_l.L.password"));
        loginButton = new ButtonElement(webDriver, By.id("id_l.L.loginButton"));
    }

    public void login() {
        login(rootLogin, rootPassword);
    }

    public void login(final String login, final String password) {
        loginElement.set(login);
        passwordElement.set(password);
        loginButton.click();
    }

    @Override
    protected String getUrl() {
        return "http://localhost:8080/login";
    }
}
