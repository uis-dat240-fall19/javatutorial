package battleshipgame;

import java.util.HashSet;
import java.util.Iterator;

import battleshipgame.Ship.status;

public class BattleShipGame {
	static int numShips = 3;

	public static void main(String[] args) {
		HashSet<Ship> ships = new HashSet<Ship>();
		GameHelper helper = new GameHelper();
		createShips(ships, helper);
		int numGuesses = 0;
		numGuesses = playGame(ships);
		System.out.println("All ships are destroyed in " + numGuesses + " guesses" );
	}

	private static int playGame(HashSet<Ship> ships) {
		int numGuesses = 0;
		while (ships.isEmpty() == false) {
			String guess = GameHelper.getUserInput("Enter a guess:");
			numGuesses++;
			Integer intGuess = Integer.parseInt(guess);
			Iterator<Ship> shipIter = ships.iterator();
			while (shipIter.hasNext()) {
				Ship ship = shipIter.next();
				ship.checkGuess(intGuess);
				System.out.println(ship.getName() + " is " + ship.getShipStatus());
				if (ship.getShipStatus() == status.DESTROYED) {
					shipIter.remove();
				}
			}
		}
		return numGuesses;
	}

	private static void createShips(HashSet<Ship> ships, GameHelper helper) {
		for (int i = 0; i < numShips; ++i) {
			Ship s = new Ship();
			s.setName("Ship " + (i + 1));
			HashSet<Integer> position = helper.placeShip(3);
			s.setPosition(position);
			System.out.println(s.getPosition());
			ships.add(s);
		}
	}

}
