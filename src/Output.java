
public class Output {
	private String message = "";
	private Room room;
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
}
