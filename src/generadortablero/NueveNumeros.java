package generadortablero;

import java.util.Random;

//HERE WE CREATE 9 RANDOM NUMBERS BETWEEN 1 AND 9 WITH NO REPETITION

public class NueveNumeros {

	public static void main(String[] args) {
		
		int[][] sudoku = new int[9][9];
		int rowdim = sudoku[0].length;			//variable with dimension of row
		int columndim = sudoku.length;	//variable with dimension of column

		sudoku = sudokuTable(rowdim, columndim);
		printTable(sudoku);
		//if you dont fill the matrix, default values remind, in int case 0 value;

	}

	//THIS METHOD CREATES THE DUDOKUS TABLE FROM THE OTHER METHODS
	public static int[][] sudokuTable(int rowdim, int columndim){

		int[][] table = new int[columndim][rowdim];	//inicializate the table
		Random random = new Random();	//Random object to obtain numbers
		int[] row = new int[rowdim];		//create vectors for comparision in rows
		int[] column = new int[columndim];	//create vectors for comparision in column
		int number;	//number generated

		for (int i = 0; i<9; i++){
			
			//System.out.println("fila "+ i);	//this is to know that the program is working
			
			int j = 0;	//index for the second nested loop

			while(j<columndim){

				number = random.nextInt(table.length)+1;
				table[i][j] = number;
				row[j] = table[i][j];	 //array with every row in every iteration

				//create a column to verify no repetition
				for(int k = 0; k <=i; k++){
					column[k] = table[k][j];
				}

				if(validValue(row, j)||validValue(column, i)){	//if the number is used in row or column
					j=0;	//restart the loop
				}else{
					j++;	//increase index for next iteration
				}

			}

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

	//THIS METHOD CREATES AN ARRAY WITH 1 TO 9 NUMBERS NAD NO REPETITION
	public static void arraygenerator(){

		Random random = new Random();
		int[] array = new int[9];
		int number;

		for(int i = 0; i<9; i++){

			boolean repeat;	//create repaeat variable
			do{

				repeat = false;	//put the variable in false state
				number = random.nextInt(9)+1; //generate random number, +1 is correction factor
				array[i] = number;

				repeat = validValue(array, i); //return if the valued is used before

			}while(repeat);	//Repeat if the number is repeated, no with the first iteration
			//in the first theres no numbers to compare

			System.out.print(array[i] + " ");
		}
		System.out.print("\n");

	}

	//THIS METHOD CREATES A 3X3 MATRIX WITH NUMBERS 1 TO 9 AND NO REPETITION
	public static int[][] matrixgenerator(){

		Random random = new Random();
		int[][] matrix = new int[3][3];
		int number;
		boolean repeat = false;
		int position;	//position of the number in the array for comparision

		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){

				position = 3*i + j;	//concatenates rows in an only array

				do{

					number = random.nextInt(9)+1;
					matrix[i][j] = number;
					repeat = validValue(matrixToArray(matrix), position);				

				}while(repeat);	//repeat the process if the number is used

				System.out.print(matrix[i][j] + " ");
			}

			System.out.print("\n");	//return carrer for the nest row
		}

		return matrix;

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

}
