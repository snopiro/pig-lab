

public class Pig {
	
	public void play() {
		
		welcome();
		setPlayers();	
	
	}
	
	public void welcome() {
		System.out.println("You have launched Pig.exe. The fate of your life ");
		System.out.println("rests on your performance in this game. The rules ");
		System.out.println("are as follows: You roll a die. As long as it does ");
		System.out.println("not land on 1, you bank that roll as your potential ");
		System.out.println("score. After each successful roll, you may try to ");
		System.out.println("roll again. If you are a greedy bastard and you roll a");
		System.out.println("1, you lose all of your banked score. If you're a safe");
		System.out.println("bitch, you can add the banked score to your real score.");
		System.out.println();
	}
	
	public void setPlayers() {
		
		System.out.print("Name of player 1: ");
		Person person1 = new Person();
		System.out.print("Name of player 2: ");
		Person person2 = new Person();
		System.out.println();
		
	}
	
	public void setTurn() {
		
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		
		Pig pig = new Pig();
		pig.play();
		
		
	}

}
