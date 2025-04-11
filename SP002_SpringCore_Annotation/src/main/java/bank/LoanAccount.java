package bank;

import org.springframework.stereotype.Component;

@Component("loan")
public class LoanAccount implements Account {

	@Override
	public void getBalance() {
		
		System.out.println("LoanAccount balance calling...");
		
	}

}
