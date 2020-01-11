package com.codingdojo;

/*
 * Bowling Score 
 * Rules of bowling
 * Rules: Cumulative Sum
	Total : [10,2]  :  [frames, rolls]
	Special Cases: 
	 
	1. Strike Condition-> At[n,0], result = 10 : 10 + [n+1,0] + [n+1,1]
	2. Spare Condition-> if[n,0] + [n,1] = 10 : 10 + ([n+1,0] )
	3. Final Condition -> LAST FRAME = 10th frame 1 throw extra 
 *
 * 
 * Testcases to use : BowlingTest.java
 * 
 * 
 * calculateSum() returns the Score of the game
 * 
 */

public class Bowling {
	private int totalScore;
	private final int MAX_LENGTH = 21;
	private int rolls[] = new int[MAX_LENGTH];
	private int frame = 0;
	private int currentRollPosition = 0;

	/*
	 * 
	 * This Method is used for testing
	 * 
	 */
	public void forTestingPushRoll(int currentRollScore) {
		rolls[currentRollPosition++] = currentRollScore;
	}

	/*
	 * 
	 * This Method calculates the total score of the Game according to rules of
	 * bowling
	 * 
	 */
	public int calculateSum() {
		int framePos = 0;
		while (frame < 10) {
			if (isStrike(framePos)) {
				totalScore = totalScore + strikeScore(framePos);
				framePos++;
			} else if (isSpare(framePos)) {
				totalScore = totalScore + spareScore(framePos);
				framePos = framePos + 2;
			} else {
				totalScore = totalScore + rolls[framePos] + (framePos + 1 < rolls.length ? rolls[framePos + 1] : 0);
				framePos = framePos + 2;
			}
			frame++;
		}
		return totalScore;
	}

	/*
	 * 
	 * This Method calculates if a Spare scores for the current frame
	 * 
	 */
	private int spareScore(int framePos) {
		return 10 + rolls[framePos + 2];
	}

	/*
	 * 
	 * This Method calculates if a Strike scores for the current frame
	 * 
	 */
	private int strikeScore(int framePos) {
		return 10 + rolls[framePos + 1] + rolls[framePos + 2];
	}

	/*
	 * 
	 * This Method checks if a Spare is scored in the current frame
	 * 
	 */
	private boolean isSpare(int framePos) {
		boolean flag = false;
		if (frame + 1 < rolls.length)
			flag = rolls[framePos] + rolls[framePos + 1] == 10;
		return flag;
	}

	/*
	 * 
	 * This Method checks if a Strike is scored in the current frame
	 * 
	 */
	private boolean isStrike(int framePos) {
		boolean flag = false;
		if (frame < rolls.length)
			return (rolls[framePos] == 10);
		return flag;
	}

	public int[] getRolls() {
		return rolls;
	}

	public void setRolls(int[] rolls) {
		this.rolls = rolls;
	}

}
