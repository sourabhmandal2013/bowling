# Project Title

Bowling Score Calculater

## Getting Started

* Bowling Score 
 * Rules of bowling
 * Rules: Cumulative Sum
 *	Total : [10,2]  :  [frames, rolls]
 *	Special Cases: 
 *	 
 *	1. Strike Condition-> At[n,0], result = 10 : 10 + [n+1,0] + [n+1,1]
 *	2. Spare Condition-> if[n,0] + [n,1] = 10 : 10 + ([n+1,0] )
 *	3. Final Condition -> LAST FRAME = 10th frame 1 throw extra 
 *
 * 
 * Testcases to use : BowlingTest.java
 * 
 * 
 * calculateSum() returns the Score of the game
 

### Installing

mvn install

## Running the tests

mvn test 

### Some Test Scenarios

Game 1 -> X X X X X X X X X X X X (12 rolls: 12 strikes) = 10 frames * 30 points = 300
Game 2 -> 9- 9- 9- 9- 9- 9- 9- 9- 9- 9- (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90
Game 3 -> 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
