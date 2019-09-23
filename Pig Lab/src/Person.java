import java.util.Scanner;

public class Person {
	
	//instance variables
	private String name;
	private int score;
	private int fakescore;
	
	//initializing scanner
	Scanner sc = new Scanner(System.in);
	
	//constructor
	public Person() {
		name = "default";
		score = 0;
	}	
	
	//getters
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	//setters
	public void setName(String _name) {
		name = _name;
	}
	
	public void setScore(int _score){
		score = _score;
	}
	
	//roll methods
	//rolling for turn deciding roll
	public int initialRoll() {
		return (int)(Math.random() * 6 + 1);
	}
	
	//general rolling
	public void roll(boolean isTrue) {

		fakescore = 0;
		
		//this will continue as long as player wants to keep rolling.
		while(isTrue) {
			
			//generates dice roll
			int dice = (int)(Math.random() * 6 + 1);
			System.out.print(getName() + " has rolled a " + dice + ". ");
			
			//if dice roll is greater than one
			if(dice>1) {
				//banked score increases by that much.
				fakescore += dice;	
				System.out.println(getName() + "'s banked score: " + fakescore);
				
				//asks if player wants to roll again. 
				System.out.print(getName() + " wants to roll again. t/f? ");
				//if yes, continues rolling
				if(sc.next().equals("t")) {
					isTrue = true;
					System.out.println();
				}
				//if no, breaks loop.
				else{
					isTrue = false;
					System.out.println();
				}
			}
			
			//bust if player lands on 1. banked score set to 0 and breaks loop
			else if(dice == 1){
				System.out.println("Bust. Unlucky.");
				fakescore = 0;
				isTrue = false;
				System.out.println();
				
			}
		}
		
		score += fakescore; //adding banked score onto total score
		
	}
}
