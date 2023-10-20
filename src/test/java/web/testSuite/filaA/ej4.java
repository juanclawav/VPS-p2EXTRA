package web.testSuite.filaA;

import web.testSuite.testBaseTodoist;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ej4 extends testBaseTodoist {
    // 4) 15% Web UI> Create 1 Task (todoist)
    @Test
    public void testing() throws InterruptedException {
        login();
        Thread.sleep(5000);
        createTask();
    }

    private void createTask() throws InterruptedException {
        Random rnd = new Random();
        String randomContent = "Task"+rnd.nextInt();
        Thread.sleep(6000);
        workspace.addTaskButton.click();
        Thread.sleep(5000);
        workspace.taskNameInput.setText(randomContent);
        workspace.addTaskConfirmButton.click();
        Thread.sleep(5000);
        Assertions.assertTrue(workspace.getTask(randomContent).isControlDisplayed(),
                "Error: No se creo la tarea");
    }
}