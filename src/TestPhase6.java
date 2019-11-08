import java.io.IOException;

public class TestPhase6 {
	
	public static void main(String [] args) {
		// Read in a good saved file
		Grid g = null;
		try {
			g = Grid.createGrid("phase6data1.txt");
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
		g.drop();
		System.out.println(g);
		
		// this should cause a chain reaction
		g = null;
		try {
			g = Grid.createGrid("phase6data2.txt");
			System.out.println(g);
		}
		catch(IOException ioe) {
			// shouldn't run!
			System.out.println(ioe);
		}
		int i = 0;
		boolean hadDrop;
		do {
			System.out.println( i + " drops");
			i++;
			System.out.println(g);
			g.replaceAll();
			hadDrop = g.drop();
		} while (hadDrop);		
	}

}
