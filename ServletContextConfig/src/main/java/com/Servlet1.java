package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/ser1")
public class Servlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>Servlet1 Calling</h1>");
		
		ServletContext cx = req.getServletContext();
		String path =  cx.getInitParameter("path");
		pw.write(path);
		
		ServletConfig cf = getServletConfig();
		String driver = cf.getInitParameter("driver");
		pw.write(driver);
	}
}
