import java.io.IOException;
import java.util.Arrays;

public class TestPhase4 {
	
	public static void main(String [] args) {
		// try some arrays
		char[] b1 = {'b','b','b'};
		char[] a1 = Grid.replaceSets(b1);
		System.out.println("Before: " + Arrays.toString(b1));
		System.out.println("After: " + Arrays.toString(a1));
		
		// Read in a good saved file
		Grid g = null;
		try {
			g = Grid.createGrid("phase4data.txt");
			System.out.println(g);
		}
		catch(IOException ioe) {
			// shouldn't run!
			System.out.println(ioe);
		}
		
		for (int i = 0; i < 4; i++) {
			char[] prev = g.extractRow(i);
			char[] replaced = Grid.replaceSets(prev);
			System.out.println("Replacing on row " + i);
			System.out.println("old: " + Arrays.toString(prev));
			System.out.println("new: " + Arrays.toString(replaced));
		}
		
	}

}
