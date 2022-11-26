package udemy.web;

import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Index")
public class HolaMundo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("Hola Mundo hello");
	}
}
