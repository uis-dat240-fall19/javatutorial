package battleshipgame;

import java.util.ArrayList;
import java.util.HashSet;

public class Ship {
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	HashSet<Integer> position;
	status shipStatus = status.ALIVE;
	
	public status getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(status shipStatus) {
		this.shipStatus = shipStatus;
	}

	public enum status {
		ALIVE, HIT, DESTROYED
	};
	
	public HashSet<Integer> getPosition() {
		return position;
	}

	public void setPosition(HashSet<Integer> position) {
		this.position = position;
	}

	public void checkGuess(int guessPosition) {
		if (position.contains(guessPosition)) {
			setShipStatus(status.HIT);
			position.remove(guessPosition);
		}
		if(position.isEmpty()) {
			setShipStatus(status.DESTROYED);
		}
	}

}
