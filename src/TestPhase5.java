import java.io.IOException;

public class TestPhase5 {
	
	public static void main(String [] args) {
		// Read in a good saved file
		Grid g = null;
		try {
			g = Grid.createGrid("phase5data1.txt");
			System.out.println(g);
		}
		catch(IOException ioe) {
			// shouldn't run!
			System.out.println(ioe);
		}
		
		System.out.println("Before:");
		System.out.println(g);
		System.out.println("After:");
		g.replaceAll();
		System.out.println(g);
		
		// second one
		g = null;
		try {
			g = Grid.createGrid("phase5data2.txt");
			System.out.println(g);
		}
		catch(IOException ioe) {
			// shouldn't run!
			System.out.println(ioe);
		}
		
		System.out.println("Before:");
		System.out.println(g);
		System.out.println("After:");
		g.replaceAll();
		System.out.println(g);
		
		// third one
		g = null;
		try {
			g = Grid.createGrid("phase5data3.txt");
			System.out.println(g);
		}
		catch(IOException ioe) {
			// shouldn't run!
			System.out.println(ioe);
		}
		
		System.out.println("Before:");
		System.out.println(g);
		System.out.println("After:");
		g.replaceAll();
		System.out.println(g);

	}

}
