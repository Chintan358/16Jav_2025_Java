package bank;

import org.springframework.stereotype.Component;

@Component("personal")
public class PersonalDetails implements User {

	@Override
	public void userDetails() {
		// TODO Auto-generated method stub
		System.out.println("Personal info calling...");
	}

}
