package draw;

public class TicTacToe extends UserSelectionProcessor {

	private int player1 = -1;
	//private int player2 = 1; Not needed.
	private int whoIsSelecting = -1;
	
	private int[][] selection = new int[3][3]; //Create new two dimensional array. { {0,0,0}, {0,0,0}, {0,0,0} }
	
	/*
	 * Removed code, move from static selection multidimensional array to private multidimensional array.
	 *
	public void wipeBoard(){ //Method to wipe the board values.
		for (int row = 0; row < selection.length; row++){
			for (int column = 0; column < selection[row].length; column++){
				selection[row][column] = 0;
			}
		}
	}
	*/
	
	public void wipeScreen(){ //Method to wipe screen. Unfortunately we can not delete anything, console doesn't allow it.
		for (int i=0;i<=25;i++){//50 is reasonable.
			System.out.println();
		}
	}
	
	public void drawBoard(){ //Drawing board method.
		
		for (int r = 0; r < selection.length; r++){ //For every row there is run the for loop.
			
			System.out.println("   |   |   "); //Just make a head part.
			
			for (int c = 0; c < selection[r].length; c++){ //For every column, run the loop.
				if (selection[r][c] == -1){ //If the value is -1, result is X.
					System.out.print(" X ");
				} else if (selection[r][c] == 0){ //If the value is 0, result is nothing.
					System.out.print("   ");
				} else if (selection[r][c] == 1){ //If the value if 1, result is an O.
					System.out.print(" O ");
				}
				if (c<2){ //Just to make the board look cleaner, we do not want an extra pipe at the end.
					System.out.print("|");
				}
			}
			
			System.out.println(); //Since we're on to a new row, make a new line, otherwise the next print function will just amend on to the X, O or blank.
			
			if (r<2){ //Once again, however, to avoid unnecessary base.
				System.out.println("___|___|___");  
			}
			
		}
		
		System.out.println("   |   |   "); //Just to make sure there are three pipes per row of the board.
	}

	private void makeMove(int[] userIn) {
		selection[userIn[0]][userIn[1]] = whoIsSelecting;
		whoIsSelecting = -whoIsSelecting;
	}
	
	public boolean requestMove(int ui){
		int[] takePoints = selectionOn3by3Grid(ui);
		if (selection[takePoints[0]][takePoints[1]] == 0){
			makeMove(takePoints);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void chooseCharacter(String player) {
		if (player.equalsIgnoreCase("x")){
			player1=-1;
		} else if (player.equalsIgnoreCase("o")){
			player1=1;
		} else {
			player1=-1;
			System.out.println("Selection invalid. Player1 is X. Player2 is O.");
		}
		whoIsSelecting = player1;
		//player2=(-player1); Not needed
	}

	@Override
	public void displayPlayerTurn() {
		if (whoIsSelecting == player1){
			System.out.println("It is Player1's turn!");
		} else {
			System.out.println("It is Player2's turn!");
		}
	}
	

	    // Checks for win; Row, Column and Diagonal

	    public boolean checkForWin() {
	        return checkRowsWin() || checkColumnsWin() || checkDiagonalsWin();  	
	        
	    }
	    
	    //[Player1HasWon, Player2HasWon]

	    // Check rows for win.

	    private boolean checkRowsWin() {
	        for (int r = 0; r < 3; r++) {
	            if ((selection[r][0] + selection[r][1] + selection[r][2]) == -3) {
	                System.out.println("Player 'X' WINS!!!");
	                return true;
	            }else if ((selection[r][0] + selection[r][1] + selection[r][2]) == 3) {
	                System.out.println("Player 'O' WINS!!!");     
	                return true;
	            } 
	        }
	        return false;
	    }

	    // Check Columns for Win.

	    private boolean checkColumnsWin() {
	    	for (int c = 0; c < 3; c++) {
	            if ((selection[0][c] + selection[1][c] + selection[2][c]) == -3) {
	                System.out.println("Player 'X' WINS!!!");
	                return true;
	            }else if ((selection[0][c] + selection[1][c] + selection[2][c]) == 3) {
	                System.out.println("Player 'O' WINS!!!");
	                return true;
	            }
	    	}
	    	return false;
	    }
	    
	   // Check both diagonals for Win
	   
		private boolean checkDiagonalsWin() {
		
		    if ((selection[0][0] + selection[1][1] + selection[2][2] == -3) || (selection[0][2] + selection[1][1] + selection[2][0] == -3)) {
	    		System.out.println("Player 'X' WINS!!!");
	    		return true;
		    }
		    else if ((selection[0][0] + selection[1][1] + selection[2][2] == 3) || (selection[0][2] + selection[1][1] + selection[2][0] == 3)) {
		    	System.out.println("Player 'O' WINS!!!");
		    	return true;
		    }
		    return false;
		}
}