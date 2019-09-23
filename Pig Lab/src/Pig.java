import java.util.Scanner;

public class Pig {
	
	//instance variables
	private boolean playAgain;
	private int turn;
	private int scoreWin;
	
	//new players
	private Person person1 = new Person();
	private Person person2 = new Person();

	//initiating scanner
	Scanner sc = new Scanner(System.in);
	
	//main play method.  helper methods below
	public void play() {
		
		welcome();
		
		//person answers whether or not they want to play
		if(sc.next().equals("y")) 
			playAgain = true;
		
		else 
			playAgain = false;
		
		//while the people want to play, they will get to play.
		while(playAgain) {
			
			System.out.println();
			setScoreWin();
			setPlayers();
			setFirstTurn();
			setTurn();
			
			//while both people's scores are under the winning score, they will get to play
			while(person1.getScore() < scoreWin && person2.getScore() < scoreWin) {
				takeTurn();
				scoreboard();
				swapTurns();
			}
			
			//if person1 reaches above the winning score
			if(person1.getScore() >= scoreWin) {
				
				//the other person will roll.
				int dummyRoll = (int)(Math.random() * 6 + 1);
				
				System.out.println(person2.getName() + " has one more roll. ");
				System.out.println(person2.getName() + " has rolled a " + dummyRoll + ".\n");
				person2.setScore(person2.getScore() + dummyRoll);
				scoreboard();
				
				//whoever has the higher score wins or if they have same, it ties
				if(person1.getScore() > person2.getScore())
					System.out.println(person1.getName() + " wins!");
				else if(person1.getScore() == person2.getScore())
					System.out.println("Tie!");
				else if(person1.getScore() < person2.getScore())
					System.out.println(person2.getName() + " wins!");
				
			}
			
			//same as above but for person2
			else if(person2.getScore() >= scoreWin) {
				
				int dummyRoll = (int)(Math.random() * 6 + 1);
				
				System.out.println(person1.getName() + " has one more roll. ");
				System.out.println(person1.getName() + " has rolled a " + dummyRoll + ".\n");
				person1.setScore(person1.getScore() + dummyRoll);
				scoreboard();
				
				if(person1.getScore() > person2.getScore())
					System.out.println(person1.getName() + " wins!");
				else if(person1.getScore() == person2.getScore())
					System.out.println("Tie!");
				else if(person1.getScore() < person2.getScore())
					System.out.println(person2.getName() + " wins!");
				
			}
			
			System.out.print("\nPlay again. y/n? ");
			
			//if they want to play again, their scores are reset
			if(sc.next().equals("y")) {
				playAgain = true;
				person1.setScore(0);
				person2.setScore(0);
				turn = 1;
			}
			
			//if not, they break the play loop
			else {
				playAgain = false;
			}
		
		}
		System.out.println("\nYou have concluded Pig.exe. Get out of my sight.");
	}
	
	//welcome method
	public void welcome() {
		
		System.out.println("Welcome. You have launched Pig.exe. The fate of your life ");
		System.out.println("rests on your performance in this game. The rules ");
		System.out.println("are as follows: You roll a die. As long as it does ");
		System.out.println("not land on 1, you bank that roll to your potential ");
		System.out.println("score. After each successful roll, you may roll again ");
		System.out.println("if you so desire. If you are greedy and you roll a");
		System.out.println("1, you lose all of your banked score. If you're a safe");
		System.out.println("chicken, and decide not to roll, you can add the banked score ");
		System.out.print("to your real score. Do you want to play? y/n? ");
		
	}
	
	//sets the score that needs to be reached to initiate win roll
	public void setScoreWin() {
		
		System.out.print("Set the score you want to play to: ");
		scoreWin = sc.nextInt();
		System.out.println();
	}
	
	//sets the names of the players
	public void setPlayers() {
		
		System.out.print("Name of player 1: ");
		person1.setName(sc.next());
		System.out.print("Name of player 2: ");
		person2.setName(sc.next());
		System.out.println();	
		
	}
	
	//method for setting the first turn
	public void setFirstTurn() {
		
		boolean yaynay = true; //dummy boolean to determine if roll needs to be done again
		while(yaynay) {
			
			//both players roll
			int personOneRoll = person1.initialRoll();
			int personTwoRoll = person2.initialRoll();
						
			System.out.println("Both players will now roll to determine roll order.\n");
			System.out.println(person1.getName() + " has rolled a " + personOneRoll);
			System.out.println(person2.getName() + " has rolled a " + personTwoRoll);
			System.out.println();
			
			//sets turn
			if(personOneRoll > personTwoRoll) {
				turn = 1;
				yaynay = false;
			}
				
			else if(personOneRoll < personTwoRoll) {
				turn = 2;
				yaynay = false;
			}
			
			//if they are equal, will roll again.
			else {
				System.out.println("Both players rolled the same.");
				yaynay = true;
			}
		}
	}
	
	//prints to console whose turn it is
	public void setTurn() {
		
		if(turn == 1) {
			System.out.println("It is now " + person1.getName() + "'s turn. ");
		}
		
		else if(turn == 2) {
			System.out.println("It is now " + person2.getName() + "'s turn. ");
		}
		
	}
	
	//sets the turn to the other player's
	public void swapTurns() {
		
		if(turn == 1)
			turn = 2;
		
		else if(turn == 2)
			turn = 1;
		
		setTurn();
	}
	
	//makes whosever's turn it is start rolling
	public void takeTurn() {
		
		if(turn == 1) {
			person1.roll(true);
		}
		else if(turn == 2) {
			person2.roll(true);
		}
		
	}
	
	//displays score board
	public void scoreboard() {
		System.out.println("*******************");
		System.out.println(person1.getName() + "'s total score is " + person1.getScore() + ".\n");
		System.out.println(person2.getName() + "'s total score is " + person2.getScore() + ".\n");
		System.out.println("*******************");
	}
	
	//main method
	public static void main(String[] args) {
		
		Pig pig = new Pig();
		pig.play();
		
	}
}
