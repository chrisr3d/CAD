package Modele;

public class Case {

	private int x;
	private int y;
	private boolean cibler = false;
	
	public Case (int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isCibler() {
		return cibler;
	}

	public void setCibler(boolean cibler) {
		this.cibler = cibler;
	}
	
	
	
}
