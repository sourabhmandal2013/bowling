package com.codingdojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {

	Bowling game;
	
	@Before
	public void prepTest() {
		game = new Bowling();
	}
	
	private void populate(int withWhat, int howMany) {
		for (int i = 0; i < howMany; i++) {
			game.forTestingPushRoll(withWhat);
		}
	}
	private void reset() {
			game = new Bowling();
	}
	
	@Test
	public void zeroesAndOnesTest() {
		populate(1, 20);
		assertEquals(20, game.calculateSum());
		reset();
		populate(0, 20);
		assertEquals(0, game.calculateSum());
	}
	
	@Test
	public void oneStrikeTest() {
		game.forTestingPushRoll(10);
		game.forTestingPushRoll(3);
		game.forTestingPushRoll(4);
		populate(0, 16);
		assertEquals(24, game.calculateSum());
	}
	@Test
	public void oneSpareTest() {
		game.forTestingPushRoll(5);
		game.forTestingPushRoll(5);
		game.forTestingPushRoll(3);
		populate(0, 17);
		assertEquals(16, game.calculateSum());
	}
	
	@Test
	public void perfectGameTest() {
		populate(10, 12);
		assertEquals(300, game.calculateSum());
	}
	
	@Test
	public void ninesAndZeroes() {
		for (int i = 0; i < 20; i++) {
			if(i%2==0)
				game.forTestingPushRoll(9);
			else
				game.forTestingPushRoll(0);
		}
		assertEquals(90, game.calculateSum());
	}
	@Test
	public void fiveAndSpares() {
		populate(5, 21);
		assertEquals(150, game.calculateSum());
	}
	
	@Test
	public void customScenario() {
		game.setRolls(new int[] {1,4,4,5,6,4,5,5,10,0,1,7,3,6,4,10,2,8,6});
		assertEquals(133, game.calculateSum());
	}

}
