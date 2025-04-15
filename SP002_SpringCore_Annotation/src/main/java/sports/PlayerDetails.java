package sports;

import org.springframework.stereotype.Component;

@Component
public class PlayerDetails implements Players {

	@Override
	public void noOfPlayers() {
		System.out.println("There are 11 players in criket and 11 players in hockey");
	}

}
