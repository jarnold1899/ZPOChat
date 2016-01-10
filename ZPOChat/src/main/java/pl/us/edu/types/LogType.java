package pl.us.edu.types;

public enum LogType {

	IN("Wejœcie"), OUT("Wyjœcie");

	private String name;

	private LogType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
