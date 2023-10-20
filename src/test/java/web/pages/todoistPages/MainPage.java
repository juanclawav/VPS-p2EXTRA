package web.pages.todoistPages;

import web.controls.Button;
import org.openqa.selenium.By;

public class MainPage {
        public Button registerBtn = new Button(By.xpath("//a[@href='/auth/signup']"));
        public Button loginBtn = new Button(By.xpath("//a[@href='/auth/login']"));
}