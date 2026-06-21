package hooks;

import io.cucumber.java.Before;
import utils.BaseAPI;

public class Hooks {

    @Before
    public void setup() {
        BaseAPI.setup();

        System.out.println("BASE URI = SET");
    }
}