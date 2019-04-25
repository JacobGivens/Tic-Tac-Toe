package draw;

public abstract class UserSelectionProcessor {
	
	public int[] selectionOn3by3Grid(int input){
		int[] ui = {0,0};
		for (int Row = 0; Row <= 2; Row++){
			for (int Col = 0; Col <=2; Col++){
				if ((Row*3)+(Col+1) == input){
					ui[0]=Row;
					ui[1]=Col;
					return ui;
				}
			}
		}
		return ui;
	}
	
	public void draw3by3GridUI(){
		System.out.println("Select a number on the grid.");
		for (int Row = 0; Row <= 2; Row++){
			for (int Col = 0; Col <=2; Col++){
				System.out.print((Row*3)+(Col+1) + " ");
			}
			System.out.println();
		}
	}
	
	public abstract void chooseCharacter(String Player);
	public abstract void displayPlayerTurn();
}