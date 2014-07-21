package com.epam.jjp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.jjp.sc.domain.Battle;

public class BattleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Battle battle;

	@Override
	public void init() throws ServletException {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		battle = context.getBean("theBattle", Battle.class);
		context.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("battle") == null) {
			session.setAttribute("battle", battle);
		}
		
		request.setAttribute("battle", session.getAttribute("battle"));
		
		RequestDispatcher viewDispathcer = request.getRequestDispatcher("/battle.jsp");
		viewDispathcer.forward(request, response);
	}
	
}
