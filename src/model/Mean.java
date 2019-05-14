package model;

//ths class might be transformed to an interface (but the car class has to be made) - the result is the same
public class Mean {
	
	private int meters=0;
	private int speed;
	private boolean isStarted;
	private String name;
	private boolean isPrintable;


	public Mean(int meters, int speed, boolean isStarted, String name,boolean isPrintable) {
		super();
		this.meters = meters;
		this.speed = speed;
		this.isStarted = isStarted;
		this.name = name;
		this.isPrintable = isPrintable;
	}

	public int getMeters() {
		return meters;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public boolean isPrintable() {
		return isPrintable;
	}

	public void setPrintable(boolean isPrintable) {
		this.isPrintable = isPrintable;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setMeters(int meters) {
		this.meters = meters;
	}

	public int getSpeed() {
		return speed;
	}
}
