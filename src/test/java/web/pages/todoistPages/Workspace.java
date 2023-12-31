package web.pages.todoistPages;

import web.controls.Button;
import org.openqa.selenium.By;
import web.controls.Control;
import web.controls.TextBox;

public class Workspace {
    public Control todayTitle = new Control(By.xpath("//h1/span[text()='Today']"));
    public Button profileButton = new Button(By.xpath("//button[@aria-label='Settings']"));
    public Button settingsButton = new Button(By.id("user_menu_settings_menuitem"));
    public Button logoutButton = new Button(By.xpath("//button[span[text()='Log out']]"));
    public Control getProjectTitle(String name){
        return new Control(By.xpath("//h1/span[text()='"+name+"']"));
    }

    public Button dismissButton = new Button(By.xpath("//button[@aria-label='Dismiss']"));

    public Button addTaskButton = new Button(By.xpath("//button[text()='Add task']"));
    public TextBox taskNameInput = new TextBox(By.xpath("//p[@data-placeholder='Task name']"));
    public Button addTaskConfirmButton = new Button(By.xpath("//button[@aria-label='Add task']"));
    public Button getTask(String content){
        return new Button(By.xpath("//div[@class='task_content' and text()='"+content+"']"));
    }
    public Control getProfileName(String name){
        profileButton.click();
        return new Control(By.xpath("//div[@class='user_menu_details_text']/strong[text()='"+name+"']"));
    }
}