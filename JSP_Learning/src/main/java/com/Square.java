package com;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class Square extends SimpleTagSupport {
	
		int number;
		
		
	
		public int getNumber() {
			return number;
		}



		public void setNumber(int number) {
			this.number = number;
		}



		@Override
		public void doTag() throws JspException, IOException {
			
			 JspWriter out=getJspContext().getOut(); 
		     out.println("Square of "+number+" is : "+(number*number)); 
			
			
		}
}
