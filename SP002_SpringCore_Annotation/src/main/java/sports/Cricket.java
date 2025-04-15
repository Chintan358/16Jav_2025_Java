package sports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Cricket implements Sport {

	@Autowired
	@Qualifier("extraPlayers")
	Players players;
	
	@Override
	public void sportDetails() {
		
		System.out.println("Cricket is a natinal game of England");
		players.noOfPlayers();
		
	}

}
