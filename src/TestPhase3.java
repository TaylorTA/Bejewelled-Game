import java.io.IOException;
import java.util.Arrays;

public class TestPhase3 {
	
	public static void main(String [] args) {
		// Read in a good saved file
		Grid g = null;
		try {
			g = Grid.createGrid("phase3data.txt");
			System.out.println(g);
		}
		catch(IOException ioe) {
			// shouldn't run!
			System.out.println(ioe);
		}
		
		System.out.println("Should match:");
		System.out.println(g);
		for (int i = 0; i < 4; i++)
			System.out.println(Arrays.toString(g.extractRow(i)));
		
		System.out.println("Should be the board reflected on the x=y axis");
		for (int i = 0; i < 10; i++)
			System.out.println(Arrays.toString(g.extractColumn(i)));
		
	}

}
