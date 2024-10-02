package Hooks;

import Base.base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {

    @Before
    public void setup(){
        System.out.println("Hooks:Browser setup can be implemented in base");

    }
    @After
    public void tearDown() {
        base.quitBrowser();
    }

}
