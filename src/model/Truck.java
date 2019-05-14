package model;

public class Truck extends Mean{
	
	
	public Truck(int meters, int speed, boolean isStarted, boolean isPrintable) {
		super(meters, speed, isStarted, "Truck", isPrintable);
		// TODO Auto-generated constructor stub
	}

	public void load() {
		System.out.println(" Loading ");
	}
	
	public void unLoad() {
		
	}
}
