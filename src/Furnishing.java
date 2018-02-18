import org.apache.commons.lang3.StringUtils;

public class Furnishing {
	private String adjective;
	private String furniture;

	public String getAdjective() {
		return adjective;
	}

	public void setAdjective(String adjective) {
		this.adjective = adjective;
	}

	public void setFurniture(String furnishing) {
		this.furniture = furnishing;
	}
	
	public String getFurniture() {
		return furniture;
	}
	
	public String toString() {
		String outputString = "";
		if (!adjective.isEmpty())
			outputString += adjective + " ";
		if (!furniture.isEmpty())
			outputString += furniture;
		return outputString;
	}

	public boolean isEmpty() {
		if (adjective.isEmpty() && furniture.isEmpty())
			return true;
		return false;
	}

	public boolean isEqual(Furnishing furnishing) {
		if (!StringUtils.equals(adjective, furnishing.getAdjective()))
			return false;
		else if (!StringUtils.equals(this.furniture, furnishing.getFurniture()))
			return false;
		return true;
	}
}
