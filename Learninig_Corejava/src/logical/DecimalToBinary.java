package logical;

public class DecimalToBinary {
	public static void main(String[] args) {
		
		
		int number = 300;
		String str = "";
		int f = 1;
		while(number !=0)
		{  	
			Integer rem = number%16;
			if(rem>=10 && rem<=15)
			{
				char c = (char) (rem+55);
				str= c+str;
			}
			else
			{
				str = rem+str;
			}
			number=number/16;	
			f*=10;
		}
		System.out.println(str);
	}
}
