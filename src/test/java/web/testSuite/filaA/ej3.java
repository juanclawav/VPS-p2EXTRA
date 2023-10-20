package web.testSuite.filaA;


import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import web.testSuite.testBaseTodoly;

public class ej3 extends testBaseTodoly {
    private final Random rnd = new Random();

    @Test
    public void testing() throws InterruptedException {
        createUser();
        createProject();
    }

    private void createUser() {
        String randomEmail = "enrique" + rnd.nextInt() + "@gmail.com";
        String randomPassword = "pwd" + rnd.nextInt();

        mainPage.signupBtn.click();

        signupPopup.nameTb.setText("Juan Claudio");
        signupPopup.emailTb.setText(randomEmail);
        signupPopup.pwTb.setText(randomPassword);

        signupPopup.termCb.click();
        signupPopup.signupBtn.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "Error: No se pudo crear la cuenta");
    }

    private void createProject() throws InterruptedException {
        String randomProjectName = "Project " + rnd.nextInt();

        menuSection.addNewProjectBtn.click();
        menuSection.projectNameTb.setText(randomProjectName);
        menuSection.addProjectBtn.click();
        Thread.sleep(5000);

        Assertions.assertTrue(menuSection.selectProjectButton(randomProjectName).isControlDisplayed(),
                "Error: No se pudo crear el projecto");
    }
}
