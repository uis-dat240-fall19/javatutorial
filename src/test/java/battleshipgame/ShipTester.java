package battleshipgame;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

import battleshipgame.Ship.status;

public class ShipTester {
	@Test public void testShipLocation(){
		Ship myShip = new Ship();
		HashSet<Integer> position = new HashSet<Integer>();
		position.add(3);
		position.add(4);
		position.add(5);
		
		myShip.setPosition(position);
		myShip.checkGuess(1);
		assertTrue(myShip.getShipStatus() == status.ALIVE); 
		myShip.checkGuess(2);
		assertTrue(myShip.getShipStatus() == status.ALIVE);
		myShip.checkGuess(3);
		assertTrue(myShip.getShipStatus() == status.HIT); 
		myShip.checkGuess(4);
		assertTrue(myShip.getShipStatus() == status.HIT);
		myShip.checkGuess(5);
		assertTrue(myShip.getShipStatus() == status.DESTROYED);
		myShip.checkGuess(0);
		assertTrue(myShip.getShipStatus() == status.DESTROYED);
	}
}
