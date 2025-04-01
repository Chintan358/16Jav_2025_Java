package com;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener {
		
	int currentUser = 0;
	int totalUser = 0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		currentUser++;
		totalUser++;
		ServletContext cx = se.getSession().getServletContext();
		cx.setAttribute("cuser", currentUser+"");
		cx.setAttribute("tuser", totalUser+"");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		currentUser--;
		ServletContext cx = se.getSession().getServletContext();
		cx.setAttribute("cuser", currentUser+"");
		
	}
	
}
