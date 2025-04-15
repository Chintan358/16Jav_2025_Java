package sports;

import org.springframework.stereotype.Component;

@Component
public class ExtraPlayers implements Players {

	@Override
	public void noOfPlayers() {
		
		System.out.println("Thre are 4 extra players in cricket and 4 in hokey");
		
	}

}
