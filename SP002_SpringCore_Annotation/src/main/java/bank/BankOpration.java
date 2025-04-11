package bank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankOpration {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext cx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		Account saving  = cx.getBean("saving",Account.class);
		Account loan = cx.getBean("loan",Account.class);
		
		saving.getBalance();
		loan.getBalance();
		
	}
}
