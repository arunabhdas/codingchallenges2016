public class Star {


	private int xPos;
	private int yPos;

	public Star (int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public int getX() {
		return this.xPos;
	}

	public int getY() {
		return this.yPos;
	}

	public void toS() {
		System.out.println("x " + xPos + " " + "y " + yPos); 
	}
}