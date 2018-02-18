
public class Furnishing {
	private String adjective;
	private String furnishing;

	public String getAdjective() {
		return adjective;
	}

	public void setAdjective(String adjective) {
		this.adjective = adjective;
	}

	public void setFurnishing(String furnishing) {
		this.furnishing = furnishing;
	}
	
	public String getFurnishing() {
		return furnishing;
	}
	
	public String toString() {
		String outputString = "";
		if (!adjective.isEmpty())
			outputString += adjective + " ";
		if (!furnishing.isEmpty())
			outputString += furnishing;
		return outputString;
	}

	public boolean isEmpty() {
		if (adjective.isEmpty() && furnishing.isEmpty())
			return true;
		return false;
	}
}
