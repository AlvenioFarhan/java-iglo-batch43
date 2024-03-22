package main;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
        //Break: Hentikan proses iteration
        for (int index = 1; index < 10; index++) {
            System.out.printf("Index is %d\n", index);
            if (index == 3) {
                break;
            } 
        }

        for (int xIndex= 0; xIndex < 10; xIndex++) {
            System.out.printf("Index X is %d\n", xIndex);
            for (int yIndex = 0; yIndex < 10; yIndex++) { //Hanya break di lapisan paling bawah saja, atau yang bersangkutan
            	System.out.printf("Index Y is %d\n", yIndex);
                if (yIndex == 5) {
                    break;
                }
            }
        }		
        
        //Continue: skip ke iteration berikutnya
        for (int index = 1; index <= 10; index++) {
            if (index < 9) {
                continue;
            }
            System.out.printf("Get index %d\n", index);
        }              

        //Return akan diajarkan kemudian setelah mempelajari function.
	}

}
