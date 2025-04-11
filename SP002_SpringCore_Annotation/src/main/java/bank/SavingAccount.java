package bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("saving")
public class SavingAccount implements Account {

	@Autowired
	@Qualifier("personal")
	User user;
	
	@Override
	public void getBalance() {
		
		System.out.println("Saving account balance calling...");
		user.userDetails();
	}

}
