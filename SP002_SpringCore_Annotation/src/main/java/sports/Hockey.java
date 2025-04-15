package sports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Hockey implements Sport{

	@Autowired
	@Qualifier("playerDetails")
	Players players;
	
	@Override
	public void sportDetails() {
		// TODO Auto-generated method stub
		System.out.println("Hockey is a national game of india");
		players.noOfPlayers();
	}

}
