/* URL: https://www.geeksforgeeks.org/sudoku-backtracking-7/
 * Class Sudoku : Create a Sudoku Solver (9X9)
 * Input        : An unsolved incomplete sudoku matrix
 * Output       : A complete sudoku matrix
 */

package sudoku;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sudoku {
	public int[][] sudokuMatrix;
	public String fileName;

	public Sudoku(String filename) throws FileNotFoundException {
		fileName = filename;
		sudokuMatrix = fileToMatrix(filename);
	}

	public String getFileName() {
		return fileName;
	}
	
	/* Method to convert from file to a 2D matrix.
	 * filename - Name of the file which store the sudo matrix.
	 */
	public int[][] fileToMatrix(String filename) throws FileNotFoundException {
		int[][] sudokuMatrix = new int[9][9];
		File fileReader = new File(filename);
		Scanner sc = new Scanner(fileReader);
		int i = -1, j = -1;

		while (sc.hasNext()) {
			i++;
			String[] line = sc.nextLine().split(",");
			for (j = 0; j < line.length; j++) {
				sudokuMatrix[i][j] = Integer.parseInt(line[j]);
			}
		}
		return sudokuMatrix;
	}

	/* Method to check if the current value is suitable to 
	 * be put in the sudoku matrix. Need to check for the 
	 * specific row, column and that mini-matrix of 3X3.
	 */
	public boolean isSafe(int i, int j, int valueToPut) {
		// Check that specific row
		for (int k = 0; k < 9; k++) {
			if (sudokuMatrix[i][k] == valueToPut) {
				return false;
			}
		}
		// Check that specific column
		for (int k = 0; k < 9; k++) {
			if (sudokuMatrix[k][j] == valueToPut) {
				return false;
			}
		}
		// Check that specific mini 3X3 matrix
		for (int k = i; k < (i+3); k++) {
			for (int l = j; l < (j+3); l++) {
				if (sudokuMatrix[k][l] == valueToPut) {
					return false;
				}
			}
		}
		return true;
	}

	/* Method checks if the current place is empty or not.
	 */
	public boolean isEmpty(int i, int j) {
		return sudokuMatrix[i][j] == -1 ? true : false;
	}

	/* Method to solve the sudoku using backtracking.
	 */
	public boolean solveIt(int i, int j, int valueToPut) {

		return true;
	}
	// Print the sudo
	public static void print(int[][] matrix) {
		System.out.println("---------------------");
		System.out.println("---------------------");

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("---------------------");
		System.out.println("---------------------");
	}
}


