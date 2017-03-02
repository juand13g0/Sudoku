package generadortablero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//WE GO TO GENERATE ALL THE POSIBLES ROWS

public class Combinatoria {

	public static void main(String[] args) {

		//int[] row = {1,2,3,4,5,6,7,8,9};
		
		Scanner fileIn = null;
		
		try{
			fileIn = new Scanner(new FileInputStream("src/sudoku/sudokuRowCombinations.txt"));
		}catch(FileNotFoundException e){
			System.out.println("Archivo no encontrado");
		}
		
		System.out.println(fileIn.nextLine());

//		for(int a=1; a<=9; a++){
//			for(int b=1; b<=9; b++){
//				for(int c=1; c<=9; c++){
//					for(int d=1; d<=9; d++){
//						for(int e=1; e<=9; e++){
//							for(int f=1; f<=9; f++){
//								for(int g=1; g<=9; g++){
//									for(int h=1; h<=9; h++){
//										for(int i=1; i<=9; i++){
//													
//												array[0] = a;
//												array[1] = b;
//												array[2] = c;
//												array[3] = d;
//												array[4] = e;
//												array[5] = f;
//												array[6] = g;
//												array[7] = h;
//												array[8] = i;
//												
//												validos++;
//												rowprint(array, validos);
//												}
//										
//											
//											cont++;
//											System.out.println(" --> "+cont);
//											
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
		
		//System.out.println(cont + "iteraciones");

	}

	public static void rowprint(int[] row, int pos){

		for(int i=0; i<row.length; i++){
			System.out.print(row[i] + " "+ pos);
		}
		//System.out.println();

	}

}
