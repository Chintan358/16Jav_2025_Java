package pettern;

public class P10 {
	public static void main(String[] args) {
		
//		5
//		45
//		345
//		2345
//		12345
		
		int lines = 5;
		
		for(int i=lines; i>=1;i--)
		{
			for(int j=i;j<=lines;j++)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		
		
		
	}
}
