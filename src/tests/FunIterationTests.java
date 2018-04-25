package tests;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import data.Output;
import data.Room;

public class FunIterationTests extends TestBase {

	@Test
	public void checkCommandLFirstRoom() {
		scenario("The system should recognize a command at every iteration, like the first room.");
		given("The user has just started the game.");
		then("The user enters 'N'.");
		andThen("The system should recognize the command.");
		
        try {
            Output output = enter("L");
            String message = output.getMessage();
            
            boolean passed = false;
            /*
             * TODO So for here, is it best to assume that the game will stay the same,
             * that the first room will always have something in it? Or would it better
             * practice to check if the message contains something that says the room
             * either had something or didn't have something in it?
             */
            if (StringUtils.contains(message, "There might be smething here...")) 
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
	public void checkCommandNSecondRoom() {
		scenario("The system should recognize a command at every iteration, like the second room.");
		given("The user has just started the game and entered the second room.");
		then("The user enters 'N'.");
		andThen("The user should be taken to the North room.");
		
        try {
        	enter("N");
            Room oldRoom = getInitialOutput().getRoom();
            Output output = enter("N");
            Room newRoom = output.getRoom();
            
            assertTrue("The system did not recognize the command.", !oldRoom.isEqual(newRoom));
            
        } catch (IOException e) {
            e.printStackTrace();
            fail("An error occured while trying to read the coffeemaker.jar file.");
        } catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void checkCommandLThirdRoom() {
		scenario("The system should recognize a command at every iteration, like the third room.");
		given("The user has just started the game and has moved to the third room.");
		then("The user enters 'L'");
		andThen("The user should be taken to the North room.");
		
        try {
        	enter("N");
        	enter("N");
            Output output = enter("L");
            String message = output.getMessage();
            boolean passed = message.contains("There might be something here...");
            
            assertTrue("System did not recognize 'L' command in the third room.", passed);
            
        } catch (IOException e) {
            e.printStackTrace();
            fail("An error occured while trying to read the coffeemaker.jar file.");
        } catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
