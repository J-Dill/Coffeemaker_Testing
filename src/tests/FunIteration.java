package tests;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import data.Output;
import data.Room;

public class FunIteration extends TestBase {

	@Test
	public void checkCommandL() {
		scenario("The system should recognize every known command, like 'L'.");
		given("The user has just started the game.");
		then("The user enters 'N'.");
		andThen("The system should recognize the command.");
		
        try {
            Output output = enter("L", true);
            String message = output.getMessage();
            
            boolean passed = false;
            /*
             * TODO So for here, is it best to assume that the game will stay the same,
             * that the first room will always have something in it? Or would it better
             * practice to check if the message contains something that says the room
             * either had something or didn't have something in it?
             */
            if (StringUtils.contains(message, "There might be something here...")) 
            		passed = true;
            
            assertTrue("The system did not recognize the 'L' command.", passed);
        
        } catch (IOException e) {
            e.printStackTrace();
            fail("An error occured while trying to read the coffeemaker.jar file.");
        } catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void checkCommandN() {
		scenario("The system should recognize every known command, like 'N'.");
		given("The user has just started the game.");
		then("The user enters 'N'.");
		andThen("The user should be taken to the North room.");
		
        try {
            Output output = enter("N", true);
            Room oldRoom = getInitialOutput().getRoom();
            Room newRoom = output.getRoom();
            
            
        } catch (IOException e) {
            e.printStackTrace();
            fail("An error occured while trying to read the coffeemaker.jar file.");
        } catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
