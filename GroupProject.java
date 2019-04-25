import java.util.Scanner; //Import scanner.
import draw.TicTacToe; //Import TicTacToe from draw package.

public class GroupProject {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); //Set up a new scanner, check for user input.
		System.out.println("Would you like to play Tic Tac Toe? (Yes or y to play, otherwise you quit.)"); //Simple question.
		String doYouWantToPlay = scan.nextLine(); //Take user response.
		
		while (doYouWantToPlay.equalsIgnoreCase("yes") || doYouWantToPlay.equalsIgnoreCase("y")){ //While doYouWantToPlay equals yes or y without regards for casing, keep playing the game.
		
			boolean valid = false;
			int turn = 0;
			TicTacToe ttt = new TicTacToe(); //Draw is the object created, ttt is the name of the object's instance.
			System.out.println("Player1, please select your character. (X | O)");
			String userChar = scan.nextLine();
			ttt.chooseCharacter(userChar);
			boolean gameOver = false; //Set to true currently for testing purposes. This will yield the while loop until a response is given.
			
			while (!gameOver) {
				if (turn != 0){
					ttt.wipeScreen(); //We want to make sure the past information can not be used.
				}
				ttt.drawBoard();
				System.out.println();
				if (!valid){
					ttt.draw3by3GridUI();
				}
				
				System.out.println();
				ttt.displayPlayerTurn();
				valid = false;
				int userPosInt=0; 
				
				while (!valid){
				
					String userPos = scan.nextLine();
					
					try {
						userPosInt = Integer.parseInt(userPos);
					} catch (NumberFormatException e){
						valid = false;
					}
					
					if (userPosInt > 0 && userPosInt < 10){
						if (ttt.requestMove(userPosInt)){
							valid = true;
						}
					}
					
					if (!valid) {
						System.out.println("This is not a valid number.");
						ttt.draw3by3GridUI();
					}
					
				}

				turn++;
				
				if (turn > 4){
					gameOver = ttt.checkForWin();
					if (turn > 8 && !gameOver){ //Since we don't have a winner in 9 turns means the game is over. All nine spots taken.
						System.out.println("It's a draw!");
						gameOver = true;
					}
				}
				
			}
			
			System.out.println("\n\nWould you like to play again? (Yes or y to play, otherwise you won't play.)");
			ttt.drawBoard();
			doYouWantToPlay = scan.nextLine();
			
		}
		
		System.out.println("You have selected to close the game. Bye.");
		scan.close(); //Close scanner when done.

	}

}