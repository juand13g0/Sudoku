package generadortablero;

import java.util.Random;

public class SudokuGenerator {

	public static void main(String[] args) {
		
		int rowdim = 9;			//variable with dimension of row
		int columndim = 9;	//variable with dimension of column
		int[][] sudoku = new int[columndim][rowdim];
		
		sudoku = sudokuTable(rowdim, columndim);
		printTable(sudoku);

	}

	//THIS METHOD CREATES THE DUDOKUS TABLE FROM THE OTHER METHODS
	public static int[][] sudokuTable(int rowdim, int columndim){

		int[][] table = new int[columndim][rowdim];	//inicializate the table
		Random random = new Random();	//Random object to obtain numbers
		int[] row = new int[rowdim];		//create vectors for comparision in rows
		int[] column = new int[columndim];	//create vectors for comparision in column
		int number;	//number generated


		for (int i = 0; i<rowdim; i++){

			int j = 0;	//index for the second nested loop

			while(j<columndim){

				number = random.nextInt(table.length)+1;
				table[i][j] = number;
				row[j] = number;	 //array with every row in every iteration
				int[][] submatrix = new int[3][3];

				//create a column to verify no repetition
				for(int k = 0; k <=i; k++){
					column[k] = table[k][j];
				}

				//create the submatrix to verify the new number
				submatrix = subMatrix(absolutePosition(rowdim, i, j), table);
				//relativePosition of the element in the submatrix
				int relativeposition = relativePosition(i,j);

				if(validValue(row, j)||validValue(column, i)){	//if the number is used in row or column
					j=0;	//restart the loop
				}else if(validValue(matrixToArray(submatrix),relativeposition)){	//if there is a number repeated in the submatrix
					if(j>=0 && j<3){ j = 0; }
					if(j>=3 && j<6){ j = 3; }
					if(j>=6 && j<9){ j = 6; }
				}				
				else{	//it there is no number repetaed
					j++;	//increase index for next iteration
				}

			}

			//System.out.println("fila " + i);
			for(int elem : table[i]){
				System.out.print(elem);
			}
			System.out.println();
			

		}

		return table;

	}

	//THIS METHOD PRINTS THE SUDOKU TABLE
		public static void printTable(int[][] matrix){

			for(int i = 0; i<matrix.length; i++){	

				if(i==0 || i==3 || i==6){
					System.out.println("+-------+-------+-------+");	//table print format
				}

				for(int j = 0; j<matrix[i].length; j++){

					if(j==0){
						System.out.print("| ");
					}

					System.out.print(matrix[i][j] + " ");	//print the values and an space after

					if(j==2 || j ==5){	//vertical separation subtables
						System.out.print("| ");
					}	

				}
				System.out.print("|\n");	//next line

			}

			System.out.println("+-------+-------+-------+");	//table print format

		}

	//THIS METHOD COMPARES AND RETURN IF THE NUMBER IS CHOOSEN IN ARRAY IN CONSTRUCTION
	public static boolean validValue(int[] array, int position){

		boolean repeat = false;	//create repaeat variable
		int i = 0;	//inicializate variable for run with the array

		while(i < position && repeat == false ){	//not yet in the acutal position and no repeated
			if (array[i] == array[position]){
				repeat = true;	//turn into true when the number is repeated
			}
			i++;	//increase value of i
		}

		return repeat;
	}

	//THIS RETURN THE POSITION OF THE NUMBER IN ORDER TO EXTRACT THE SUBMATRIX
	public static int absolutePosition(int rowdim, int row, int column){

		return row*rowdim+column;	//1,2,3...rowdim 1*rowdim+ 1,2,3...

	}

	//THIS RETURN THE POSITION IN THE SUBMATIX
	public static int relativePosition(int row, int column){
		//PARAMETRIZAR FUNCIÓN CASE -> F(ROWDIM, COLUMNDIM, ETC...)
		int relpos = 0;
/////////////////////////////////////////////////////////777
		switch (row){
		case 0: case 3: case 6:
			switch (column){
			case 0:
			case 3:
			case 6:
				relpos = 0;
				break;
			case 1:
			case 4:
			case 7:
				relpos = 1;
				break;
			case 2:
			case 5:
			case 8:
				relpos = 2;
				break;
			}
			break;
			
		case 1: case 4: case 7:
			switch (column){
			case 0:
			case 3:
			case 6:
				relpos = 3;
				break;
			case 1:
			case 4:
			case 7:
				relpos = 4;
				break;
			case 2:
			case 5:
			case 8:
				relpos = 5;
				break;
			}
			break;
			
		case 2: case 5: case 8:
			switch (column){
			case 0:
			case 3:
			case 6:
				relpos = 6;
				break;
			case 1:
			case 4:
			case 7:
				relpos = 7;
				break;
			case 2:
			case 5:
			case 8:
				relpos = 8;
				break;
			}
			break;

		}
		
		return relpos;

	}

	//THIS RETURN THE SUBMATRIX IN WHICH IS THE POSITION
	public static int[][] subMatrix(int absolutePosition, int[][] table){

		int[][] submatrix = new int[3][3];

		switch (absolutePosition){

		case 0: case 1: case 2: case 9: case 10: case 11: case 18: case 19: case 20:

			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					submatrix[i][j] = table[i][j];
				}
			}

			break;

		case 3: case 4: case 5: case 12: case 13: case 14: case 21: case 22: case 23:

			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					submatrix[i][j] = table[i][j+3];
				}
			}

			break;

		case 6: case 7: case 8: case 15: case 16: case 17: case 24: case 25: case 26:

			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					submatrix[i][j] = table[i][j+6];
				}
			}

			break;

		case 27: case 28: case 29: case 36: case 37: case 38: case 45: case 46: case 47:
			
			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					submatrix[i][j] = table[i+3][j];
				}
			}

			break;

		case 30: case 31: case 32: case 39: case 40: case 41: case 48: case 49: case 50:
			
			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					submatrix[i][j] = table[i+3][j+3];
				}
			}

			break;

		case 33: case 34: case 35: case 42: case 43: case 44: case 51: case 52: case 53:
			
			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					submatrix[i][j] = table[i+3][j+6];
				}
			}

			break; 

		case 54: case 55: case 56: case 63: case 64: case 65: case 72: case 73: case 74:
			
			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					submatrix[i][j] = table[i+6][j];
				}
			}

			break;

		case 57: case 58: case 59: case 66: case 67: case 68: case 75: case 76: case 77:
			
			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					submatrix[i][j] = table[i+6][j+3];
				}
			}

			break;

		case 60: case 61: case 62: case 69: case 70: case 71: case 78: case 79: case 80:
			
			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					submatrix[i][j] = table[i+6][j+6];
				}
			}

			break;

		}

		return submatrix;		

	}

	//THIS METHOD CONVERT A MATRIX INTO AN ARRAY FOR VALUES COMPARATION
	public static int[] matrixToArray(int[][] matrix){

		int rowlength = matrix.length*matrix[0].length;	//with two dimensions length gets the number of elements
		int[] myArray = new int[rowlength];	
		int position = 0;	//absolute way to obtain the position in the array

		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				//int position = i*matrix[0].length + j;	//parametric way to obtain the position
				myArray[position] = matrix [i][j];
				position ++;	//increase one position in the array
			}			
		}

		return myArray;

	}

}
