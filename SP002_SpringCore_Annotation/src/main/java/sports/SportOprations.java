package sports;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SportOprations {
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Appconfig.class);
		
		Sport cricket = context.getBean("cricket",Sport.class);
		Sport hockey = context.getBean("hockey",Sport.class);
		
		cricket.sportDetails();
		hockey.sportDetails();
		
	}
}
