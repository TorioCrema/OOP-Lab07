package it.unibo.oop.lab.enum2;

public enum Place {
	INDOOR("Indoor"),
	OUTDOOR("Outdoor");
	
	private final String name;
	
	private Place(final String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
}
