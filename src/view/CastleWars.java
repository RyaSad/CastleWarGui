import java.util.ArrayList;
import java.util.Scanner;
public class CastleWars {
	public static void main (String [] args) {
		Scanner in = new Scanner(System.in);
		int numP=1;
		int deciding=1;
		ArrayList<Player> players = new ArrayList<Player>();
		System.out.println("Please type Done when you're ready.");
				
		while(deciding==1) {
		System.out.print("Player "+(numP)+": ");
		String pName = in.next();
		if(pName.equalsIgnoreCase("done")) {
			System.out.println("We're ready to start the game with "+(numP-1)+" players!");
			System.out.println(players);
			deciding = 0;
		}
		else {
			Player player = new Player(pName,numP);
			players.add(player);
			numP++;
		}
		}
	in.close();
}}