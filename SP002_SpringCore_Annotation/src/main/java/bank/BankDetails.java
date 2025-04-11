package bank;

import org.springframework.stereotype.Component;

@Component("bank")
public class BankDetails implements User {

	@Override
	public void userDetails() {
		// TODO Auto-generated method stub
		System.out.println("Bank details calling");
	}

}
