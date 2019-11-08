import java.io.IOException;

public class TestPhase2 {
	public static void main(String [] args) {
		// Read in a good saved file
		try {
			Grid g =  Grid.createGrid("phase2data.txt");
			System.out.println(g);
		}
		catch(IOException ioe) {
			// shouldn't run!
			System.out.println(ioe);
		}
		
		// Bad dimensions
		try {
			Grid g = Grid.createGrid("phase2data_badDimensions1.txt");
			// shouldn't run!
			System.out.println(g);
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
		try {
			Grid g = Grid.createGrid("phase2data_badDimensions2.txt");
			// shouldn't run!
			System.out.println(g);
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
		
		// bad Grid data
		try {
			Grid g = Grid.createGrid("phase2data_badRows.txt");
			// shouldn't run!
			System.out.println(g);
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
		try {
			Grid g = Grid.createGrid("phase2data_badColumns.txt");
			// shouldn't run!
			System.out.println(g);
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
		
		// now valid, but weird
		try {
			Grid g = Grid.createGrid("phase2data_fineIGuess.txt");
			// shouldn't run!
			System.out.println(g);
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
		
		// make a rando one, save
		Grid old = new Grid(5, 6);
		old.save("phase2SaveFile.txt");
		// load it up again
		Grid reload = null;
		try {
			reload = Grid.createGrid("phase2SaveFile.txt");
		} catch(IOException ioe) {
			System.out.println("This shouldn't be shown!");
			System.out.println(ioe);
		}
		System.out.println("These should be the same:");
		System.out.println(old);
		System.out.println();
		System.out.println(reload);
	}

}
