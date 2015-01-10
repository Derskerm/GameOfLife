import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*

	Represents a Game Of Life grid.

	Coded by: desmond Kamas
	Modified on:

*/

public class Life {

	private static final int rows = 20;
	private static final int cols = 20;
	private boolean[][] grid;

	// Constructs an empty grid
	public Life() {
		grid = new boolean[cols][rows];
	}

	// Constructs the grid defined in the file specified
	public Life(String filename) {
	}

	// Runs a single turn of the Game Of Life
	public void step() {
		for (int y = 0; y < grid[0].length; y++) {
			for (int x = 0; x < grid.length; x++) {
				int[][] neighbors = getNeighbors(x, y, cols, rows);
				for (int i = 0; i < neighbors.length; i++) {
					if (neighbors[i][0] != -1) {
						if (grid[neighbors[i][0]][neighbors[i][1]]) {
							
						}
					}
				}
			}
		}
	}
	
	//returns -1 if no neighbor
	private int[][] getNeighbors(int x, int y, int c, int r) {
		int[][] coords = new int[8][2];
		boolean north = y - 1 >= 0;
		boolean east = x + 1 < c;
		boolean south = y + 1 < r;
		boolean west = x - 1 >= 0;
		if (north) {
			coords[0][0] = x;
			coords[0][1] = y - 1;
		} else {
			coords[0][0] = -1;
			coords[0][1] = -1;
		}
		if (north && east) {
			coords[1][0] = x + 1;
			coords[1][1] = y - 1;
		} else {
			coords[1][0] = -1;
			coords[1][1] = -1;
		}
		if (east) {
			coords[2][0] = x + 1;
			coords[2][1] = y;
		} else {
			coords[2][0] = -1;
			coords[2][1] = -1;
		}
		if (east && south) {
			coords[3][0] = x + 1;
			coords[3][1] = y + 1;
		} else {
			coords[3][0] = -1;
			coords[3][1] = -1;
		}
		if (south) {
			coords[4][0] = x;
			coords[4][1] = y + 1;
		} else {
			coords[4][0] = -1;
			coords[4][1] = -1;
		}
		if (south && west) {
			coords[5][0] = x - 1;
			coords[5][1] = y + 1;
		} else {
			coords[5][0] = -1;
			coords[5][1] = -1;
		}
		if (west) {
			coords[6][0] = x - 1;
			coords[6][1] = y;
		} else {
			coords[6][0] = -1;
			coords[6][1] = -1;
		}
		if (west && north) {
			coords[7][0] = x - 1;
			coords[7][1] = y - 1;
		} else {
			coords[7][0] = -1;
			coords[7][1] = -1;
		}
		return coords;
	}

	// Runs n turns of the Game Of Life
	public void step(int n) {
		
	}

	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		return "";
	}

	public boolean[][] readData (String filename) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			boolean[][] gameData = new boolean[cols][rows];

			int count = 0;

			FileReader reader = null;
			try {
					reader = new FileReader(dataFile);
					Scanner in = new Scanner(reader);

					
					while (in.hasNext() && count < rows) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							if (line.charAt(i)=='*')
								gameData[i][count] = true;

						count++;
					}

			} catch (IOException ex) {
				System.out.println("File cannot be read.");
				return null;
			} catch (NumberFormatException ex) {
				System.out.println("File is in the wrong format.");
				return null;
			} finally {
				try {
					reader.close();
				} catch (IOException ex) {
					System.out.println("File cannot be closed.");
					return null;
				}
			}
			return gameData;
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
    }

}