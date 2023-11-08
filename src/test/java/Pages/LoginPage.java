package Pages;

import Utility.WebActions;
import org.openqa.selenium.By;

public class LoginPage {

    WebActions webActions = new WebActions();

    //By usernameField= By.id(loc.getProperty("email_field"))));

    public void enterUsername(By usernameField, String username){
        webActions.type(usernameField, username);
    }

    public void enterPassword(){

    }

    public void clickNextButton(){

    }


}
