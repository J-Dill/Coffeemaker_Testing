import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
	
    protected static Process io;
    private static BufferedReader consoleOut;
    private static BufferedWriter consoleIn;
    
    @SuppressWarnings("unused")
	private String description;
    @SuppressWarnings("unused")
	private String preConditions;
    @SuppressWarnings("unused")
	private String executionSteps;
    @SuppressWarnings("unused")
	private String postConditions;
    @SuppressWarnings("unused")
	private static Output initialOutput;
    
    protected void scenario(String desc) {
    	description = desc;
    }
    
    protected void given(String preCon) {
    	preConditions = preCon;
    }
    
    protected void then(String steps) {
    	executionSteps = steps;
    }
    
    protected void andThen(String postCon) {
    	postConditions = postCon;
    }
    
    @BeforeEach
    public void setUp() {
    	try {
    		String dir = System.getProperty("user.dir") + "\\src\\coffeemaker.jar";
			io = Runtime.getRuntime().exec("cmd /c java -jar " + dir);
	    	consoleOut = new BufferedReader(new InputStreamReader(io.getInputStream()));
	    	consoleIn = new BufferedWriter(new OutputStreamWriter(io.getOutputStream()));
	    	initialOutput = enter(null); //This starts up the game and sends its initial output into the variable
		} catch(IOException | InterruptedException e) {
			e.printStackTrace();
		}
    }
	
	protected static Output enter(String words, boolean print) throws IOException, InterruptedException {
		if(words != null) {
			consoleIn.write(words);
	        consoleIn.newLine();
		}
        consoleIn.flush();
        Thread.sleep(1000); // Allow the game to respond
        List<String> allOutput = new ArrayList<String>();
        while (consoleOut.ready()) {
        	String line = consoleOut.readLine();
        	allOutput.add(line);
        	if (print)
        		System.out.println(line);
        }
        	
		return parseOutput(allOutput);
	}
	
	protected static Output enter(String input) throws IOException, InterruptedException {
		return enter(input, false);
	}

	private static Output parseOutput(List<String> allOutput) {
		Output output = new Output();
		boolean isMessage = false;
		String message = "";
		for (int i = 0; i < allOutput.size(); i++) {
			String line = allOutput.get(i);
			if (i == 0 && StringUtils.isNotBlank(line)) {
				isMessage = true;
				message += line;
				continue;
			}
			if (isMessage && StringUtils.isNotBlank(line) && !line.contains("room"))
				message += " " + line.trim();
			if (line.contains("room")) {
				isMessage = false;
				Room room = parseRoom(allOutput.subList(i, allOutput.size() - 1));
				output.setRoom(room);
			}
			if (line.contains("INSTRUCTIONS")) {
				output.setInstructions(line.trim());
			}
		}
		output.setMessage(message);
		return output;
	}

	private static Room parseRoom(List<String> subList) {
		Room room = new Room();
		List<Door> doors = new ArrayList<Door>();
		for (String line : subList) {
			if (line.contains("room")) {
				Matcher m = Pattern.compile(" (\\w+) room").matcher(line);
				if (m.find()) {
					String roomAdjective = m.group(1);
					room.setAdjective(roomAdjective);
				}
					
			}
			if (line.contains("It has")) {
				Furnishing furn = parseFurnishing(line);
				room.setFurnishing(furn);
			}
			if (line.contains("door")) {
				Door door = parseDoor(line);
				doors.add(door);
			}
			
		}
		if (!doors.isEmpty())
			room.setDoors(doors);
		return room;
	}

	private static Door parseDoor(String line) {
		Door door = new Door();
		Matcher m = Pattern.compile("(\\w+) door.*(North|South)").matcher(line);
		if (m.find()) {
			String adjective = m.group(1);
			String direction = m.group(2);
			door.setAdjective(adjective);
			door.setDirection(direction);
		}

		return door;
	}

	private static Furnishing parseFurnishing(String line) {
		Furnishing furn = new Furnishing();
		Matcher m = Pattern.compile("It has a(n?) (\\w+) (.+)\\.").matcher(line);
		if (m.find()) {
			String adjective = m.group(2);
			String furnishing = m.group(3);
			furn.setAdjective(adjective);
			furn.setFurniture(furnishing);
		}
		return furn;
	}

}


















