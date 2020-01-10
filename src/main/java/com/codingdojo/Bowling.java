package com.codingdojo;

public class Bowling {
	private int totalScore;
	private final int MAX_LENGTH = 21;
	private int rolls[] = new int[MAX_LENGTH];
	private int frame = 0;
	private int currentRollPosition = 0;
	
	public void forTestingPushRoll(int currentRollScore) {
		rolls[currentRollPosition++] = currentRollScore;
	}
	
	public int calculateSum() {
		int framePos = 0;
		while (frame < 10) {
			if (isStrike(framePos)) {
				totalScore = totalScore + 10 + rolls[framePos+1] + rolls[framePos + 2];
				framePos++;
			} else if (isSpare(framePos)) {
				totalScore = totalScore + 10 + rolls[framePos + 2];
				framePos = framePos+2;
			} else {
				totalScore = totalScore + rolls[framePos ] + (framePos + 1 < rolls.length ? rolls[framePos + 1] : 0);
				framePos = framePos+2;
			}
			frame++;
		}
		return totalScore;
	}

	private boolean isSpare(int framePos) {
		boolean flag = false;
		if (frame + 1 < rolls.length)
			flag = rolls[framePos] + rolls[framePos + 1] == 10;
		return flag;
	}

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
