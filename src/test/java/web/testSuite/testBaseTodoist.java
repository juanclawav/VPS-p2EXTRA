package web.testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import web.pages.todoistPages.*;
import web.session.Session;

public class testBaseTodoist {

    public MainPage mainPage = new MainPage();
    public LoginPage loginPage = new LoginPage();
    public Workspace workspace = new Workspace();
    public SettingsOverlay settingsPage = new SettingsOverlay();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
            Session.getInstance().goTo("https://todoist.com/");
    }

    public void login() throws InterruptedException {
        mainPage.loginBtn.click();
        Thread.sleep(8000);

        loginPage.emailInput.setText("juanclaapi@test.com");
        loginPage.passwordInput.setText("qwerty12345");

        loginPage.logInButton.click();
        Thread.sleep(5000);

    }
}