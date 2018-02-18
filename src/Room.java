import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Room {
	private String adjective = "";
	private Furnishing furnishing = new Furnishing();
	private List<Door> doors = new ArrayList<Door>();
	
	public String getAdjective() {
		return adjective;
	}
	public void setAdjective(String adjective) {
		this.adjective = adjective;
	}
	public Furnishing getFurnishing() {
		return furnishing;
	}
	public void setFurnishing(Furnishing furnishing) {
		this.furnishing = furnishing;
	}
	public List<Door> getDoors() {
		return doors;
	}
	public void setDoors(List<Door> doors) {
		this.doors = doors;
	}
	public String toString() {
		String outputString = "";
		if (StringUtils.isNotBlank(adjective))
			outputString += adjective + " room\n";
		if (!furnishing.isEmpty())
			outputString += furnishing + "\n";
		for (Door door : doors) {
			if (!door.isEmpty())
				outputString += door + "\n";
		}

		return outputString;
	}
	
	public boolean isEmpty() {
		if (adjective.isEmpty() && furnishing.isEmpty() && doors.isEmpty())
			return true;
		return false;
	}
	
	public boolean isEqual(Room room) {
		if(!StringUtils.equals(adjective, room.getAdjective()))
			return false;
		else if (!furnishing.isEqual(room.getFurnishing()))
			return false;
		else if (!doors.equals(room.getDoors()))
			return false;
		return true;
	}
}
