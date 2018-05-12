/****************************************************************************
 *
 * Created by: Heejo Suh
 * Created on: Apr 2018
 * Created for: learning
 * 
 * This program creates the magic square of numbers
 ****************************************************************************/

public class MagicSquare{
	//creates the magic squares
    //--------------------------
    public boolean checkMagicSquare(Integer[] squares) {
    	//literally check every row & column if the total equals 15

    	if ((squares.length == 9) && 
    		//horizontally
    		(squares[0] + squares[1] + squares[2] == 15) && 
    		(squares[3] + squares[4] + squares[5] == 15) && 
    		(squares[6] + squares[7] + squares[8] == 15) && 
    		//vertically
    		(squares[0] + squares[3] + squares[6] == 15) && 
    		(squares[1] + squares[4] + squares[7] == 15) && 
    		(squares[2] + squares[5] + squares[8] == 15) && 
    		//Crossing
    		(squares[2] + squares[4] + squares[6] == 15) &&
    		(squares[0] + squares[4] + squares[8] == 15)
    		) {
	    		return true;
    	} else {
    		//nope
    		return false;
    	}
    }

    //--------------------------
    public void showSquare(Integer[] squares) {
    	//Shows the magic square

    	for ( int index= 0; index < squares.length; index++ ) {  
	    	if (index==0 || index==3 || index==6) {
	    		//new line
	    		System.out.print("\n------------\n| ");
	    	}
    		System.out.print(squares[index] + " | ");
    	}
		System.out.println("\n");
    }
    	

    //--------------------------
    public Integer[] swap(Integer[] squares, int pos1, int pos2) {
    	//Swap inputs

	Integer init1 = squares[pos1];
	squares[pos1] = squares[pos2];
	squares[pos2] = init1;
    	
    	return squares;
    }

    //--------------------------
    public void modify(Integer[] squares, int start, int end) {
    	//Modifies the square using recursion
    	
    	if(start == end && checkMagicSquare(squares)) {
    		//if have checked for magic square and modified every number
    		showSquare(squares);
    	} else {
    		for(int i = start; i <= end; i++) {

    			//swap number
    			squares = swap(squares, start, i);
    			//check again
    			//recursion with next number
    			modify(squares, start + 1, end);
    			//swap number again
    			squares = swap(squares, start, i);
    		}
    	}
    }
    
    //--------------------------
	public static void main(String[] args) {
		//run program
		Integer[] intArray= {1, 2, 3, 4, 5, 6, 7, 8, 9};
    	MagicSquare getSquare = new MagicSquare();
    	getSquare.modify(intArray, 0, 8); //start index is 0, end index is 8 (not 9)
	}
}
