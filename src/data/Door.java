package data;
import org.apache.commons.lang3.StringUtils;

public class Door {
	private String direction = "";
	private String adjective = "";
	
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getAdjective() {
		return adjective;
	}
	public void setAdjective(String adjective) {
		this.adjective = adjective;
	}
	public String toString() {
		String outputString = "";
		if (!adjective.isEmpty())
			outputString += adjective + " door";
		if (!direction.isEmpty())
			outputString += " that leads " + direction;

		return outputString;
	}
	public boolean isEmpty() {
		if (direction.isEmpty() && adjective.isEmpty())
			return true;
		return false;
	}
	
	public boolean isEqual(Door door) {
		if (!StringUtils.equals(direction, door.getDirection()))
			return false;
		else if (StringUtils.equals(adjective, door.getAdjective()))
			return false;
		return true;
	}
}
