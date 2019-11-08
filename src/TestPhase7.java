import java.io.IOException;

public class TestPhase7 {
	
	public static void main(String [] args) {
		// Read in a good saved file
		Grid g = null;
		try {
			g = Grid.createGrid("phase7data1.txt");
			System.out.println(g);
		}
		catch(IOException ioe) {
			// shouldn't run!
			System.out.println(ioe);
		}
				
		// swap down one of the g's
		g.swap(0, 2, Grid.DOWN);
		g.replaceAll();
		g.drop();
		System.out.println(g);
		
		// do some dirt
		try {
			g.swap(0, 2, Grid.UP);
		}
		catch (IndexOutOfBoundsException ioobe) {
			System.out.println(ioobe);
		}
		
		try {
			g.swap(-100, 2, Grid.UP);
		}
		catch (IndexOutOfBoundsException ioobe) {
			System.out.println(ioobe);
		}
		try {
			g.swap(0, 200, Grid.UP);
		}
		catch (IndexOutOfBoundsException ioobe) {
			System.out.println(ioobe);
		}
	}
	
	

}
