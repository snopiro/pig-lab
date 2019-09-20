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
		name = sc.next();
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
		
		fakescore = score;
		
		if(isTrue) {
			int dice = (int) Math.random() * 5 + 1;
			if(dice>1) {
				fakescore += dice;	
			}
			else
				bust();
				
		}
		else {
			score = fakescore;
		}
	}
	
	//bust method
	public void bust() {
		System.out.println();
	}
}
