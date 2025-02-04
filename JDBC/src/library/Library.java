package library;

import java.util.Scanner;

public class Library {
	public static void main(String[] args) {
		
		int choice = 0;
		do
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("********Welcome********");
		System.out.println("1 : Add Books");
		System.out.println("2 : View Books");
		System.out.println("3 : Delete Book");
		System.out.println("4 : Issue Book" );
		System.out.println("0 : Exit");
		choice = sc.nextInt();
		
		LibraryOperations lo = new LibraryOperations();
		
		switch(choice)
		{
			case 1 :
				System.out.println("****Add Book****");
				System.out.println("enter Book name : ");
				String name = sc.next();
				System.out.println("Enter Qty :" );
				int qty = sc.nextInt();
				lo.addBook(name,qty);
				break;
			case 2 : 
				System.out.println("********View Book*********");
				lo.viewBook();
				break;
			case 3 :
				System.out.println("*******Delete Book*******");
				System.out.println("enter book Name : ");
				String bname = sc.next();
				lo.deleteBook(bname);
				break;
			case 4 : 
				System.out.println("*******Issue Book*******");
				System.out.println("enter book Name : ");
				String iName = sc.next();
				lo.issueBook(iName);
				break;
				
			case 0 : 
				System.out.println("You are Exit !!!");
				break;
			default : 
				System.out.println("Invalid choice !!!");
		}
		}while(choice!=0);
		
		
	}
}
