import java.util.Scanner;

public class Person {
	
	//instance variables
	private String name;
	private int score;
	
	//initializing scanner
	Scanner sc = new Scanner(System.in);
	
	//constructor
	public Person(String _name) {
		name = _name;
		score = 0;
	}	
	
	//getters
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	//roll method
	public void roll(boolean isTrue) {
		if(isTrue) {
			int dice = (int) Math.random() * 5 + 1;
			if(dice>1) {
				score += dice;
			}
			
		}
	}
}
