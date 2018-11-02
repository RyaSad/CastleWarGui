
public class Player {
	public String pName;
	public int numP;
	public int Cast = 40;
	public int Fenc = 20;
	public int Builders = 3;
	public int Warriors = 3;
	public int Mages = 3;
	public int Bricks = 10;
	public int Weapons = 10;
	public int Crystals = 10;
	
	public Player(String pName, int numP) {
		this.pName = pName;
		this.numP = numP;
	}
	
	public String toString() {
		return pName+" is player "+numP;
	}
}
