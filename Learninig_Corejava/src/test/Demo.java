package test;

import java.util.Iterator;

public class Demo {
	public static void main(String[] args) {
//		int Integer  = 10;
//		System.out.println(Integer);
//		
//		byte x = 127;
//		x++;
//		x++;
//		System.out.println(x);
		
//		int[] x = {120,200,16};
//		for (int i = 0; i < x.length; i++) {
//			System.out.println(x[i]);
//		}
//		
//		System.out.println();
		
		int[] A = {0,2,4,1,3};
		
		for (int i = 0; i < A.length; i++) {
			A[i] = A[(A[i]+3)%A.length];
		}
		
		System.out.println(A[1]);
		
	}
}
