package logical;

public class Armstrong {
	
	public static void main(String[] args) {
		for(int i=100;i<=999;i++)
		{
			
			int number = i;
			int temp =number;
			int sum = 0;
			while(number!=0)
			{
				int rem = number%10;
				sum=  sum+(rem*rem*rem);
				number  =number/10;		
			}		
			if(temp==sum)
			{
				System.out.println(temp+" : is armstrong");
			}
			else
			{
				System.out.println(temp+" : is not armsrong.");
			}
		}
		
	}
}
