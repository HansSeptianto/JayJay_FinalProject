package hans.stepdef;

import static hans.helper.Utility.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void beforeTest() {
        startDriver();
    }

    @After
    public void afterTest() {
        closeDriver();
    }
}
