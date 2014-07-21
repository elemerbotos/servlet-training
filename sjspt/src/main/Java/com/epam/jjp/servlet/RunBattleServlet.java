package com.epam.jjp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.jjp.sc.domain.Battle;

public class RunBattleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Battle battle = (Battle) session.getAttribute("battle");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		battle.start(response.getWriter());
	}
	
}
