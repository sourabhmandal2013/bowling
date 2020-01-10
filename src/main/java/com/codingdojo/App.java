package com.codingdojo;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
	private int totalScore;
	private int rolls[] = new int[21];
	private int rollNo = 0;
//	private int[] rolls = new int[] { 1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 0, 1, 7, 3, 6, 4, 10, 0, 2, 8, 6 };
//	private int[] rolls = new int[] {1,4,4,5,6,4,5,5,10,0,1,7,3,6,4,10,2,8,6};

	// Format for easy calc
	public void addRolls(int inputRolls[]) {
		ArrayList<Integer> out = new ArrayList<Integer>();
		for (int i = 0; i < inputRolls.length; i++) {
			if (inputRolls[i] != 10)
				out.add(inputRolls[i]);
			else if (inputRolls[i] == 10) {
				out.add(inputRolls[i]);
				out.add(0);
			}
		}
		rolls = out.stream().mapToInt(i -> i).toArray();
		System.out.println(rolls.length);
	}
	private int checkStrikeAndSpare() {
		int res = 0;
		if ((rollNo%2==0) && rolls[rollNo] == 10) {
			res = 10 + (rollNo + 2 < rolls.length ? rolls[rollNo + 2] : 0) + (rollNo + 3 < rolls.length ? rolls[rollNo + 3] : 0);
			rollNo++;
		}else {
			if(rollNo%2==0) {
				if (rolls[rollNo] + (rollNo + 1 < rolls.length ? rolls[rollNo + 1] : 0) == 10) {
					res = 10 + (rollNo + 2 < rolls.length ? rolls[rollNo + 2] : 0);
					rollNo++;
				}
			}
			else {
				if (rolls[rollNo] + (rollNo - 1 > 0 ? rolls[rollNo - 1] : 0) == 10) {
					res = 10 + (rollNo + 1 < rolls.length ? rolls[rollNo + 1] : 0);
					rollNo++;
				}
			}
		}
		return res;
	}
	
	public int calculateScore() {
		totalScore = 0;
		for (rollNo = 0; rollNo < rolls.length; rollNo++) {
			int specialConditions = checkStrikeAndSpare();
			totalScore = totalScore + (specialConditions != 0 ? specialConditions : rolls[rollNo]);
			if(rollNo%2!=0)
					System.out.println("totalScore at " + rollNo +" : "+ totalScore );
		}
		return totalScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int currentScore) {
		this.totalScore = currentScore;
	}

	public int[] getRolls() {
		return rolls;
	}

	public void setRolls(int[] rolls) {
		this.rolls = rolls;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
}
