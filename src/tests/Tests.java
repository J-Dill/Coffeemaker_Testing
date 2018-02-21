package tests;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import data.Output;
import data.TestBase;

public class Tests extends TestBase {

	@Test
	public void test1() {
		scenario("The system should recognize every known command, like 'L'.");
		given("The user has just started the game.");
		then("The user enters 'N'.");
		andThen("The user should be taken to the North room.");
		
        try {
        	enter("N", true);
            Output output = enter("L", true);
            String message = output.getMessage();
            
            if (!StringUtils.contains(message, "There might be something here..."))
            	assertTrue(StringUtils.equals(message, "You don't see anything out of the ordinary.")); 	
        
        } catch (IOException e) {
            e.printStackTrace();
            fail("An error occured while trying to read the coffeemaker.jar file.");
        } catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test2() {
		scenario("The system should recognize every known command, like 'L'.");
		given("The user has just started the game.");
		then("The user enters 'N'.");
		andThen("The user should be taken to the North room.");
		
        try {
        	enter("N", true);
            Output output = enter("L", true);
            String message = output.getMessage();
            
            if (!StringUtils.contains(message, "There might be something here..."))
            	assertTrue(StringUtils.equals(message, "You don't see anything out of the ordinary.")); 	
        
        } catch (IOException e) {
            e.printStackTrace();
            fail("An error occured while trying to read the coffeemaker.jar file.");
        } catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
