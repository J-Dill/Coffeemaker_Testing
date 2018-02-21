package data;
import org.apache.commons.lang3.StringUtils;

public class Output {
	private String message = "";
	private Room room = new Room();
	private String instructions = "";
	
	public Output() {}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	public String toString() {
		String outputString = "";
		if (!message.isEmpty())
			outputString += message + "\n\n";
		if (!room.isEmpty())
			outputString += room + "\n";
		if (!instructions.isEmpty())
			outputString += instructions + "\n";
		return outputString;
	}

	public boolean isEqual(Output output) {
		if (!StringUtils.equals(message, output.getMessage()))
			return false;
		else if (!room.isEqual(output.getRoom()))
			return false;
		else if (!StringUtils.equals(instructions, output.getInstructions()))
			return false;
		return true;
	}
}
