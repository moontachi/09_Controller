package myPkg;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
//@WebServlet("*.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public MemberServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doProcess(request,response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		int len = contextPath.length();

		String command =  uri.substring(len); 
		System.out.println("command : " + command); 

		MemberCommand mcommand = null;
		String viewPage = "";
		
		if(command.equals("/insertProc.do")) {
			mcommand = new MInsertCommand();
			mcommand.excute(request, response);
			viewPage = "/list.do";
		}
		else if(command.equals("/list.do")) {
			mcommand = new MListCommand(); 
			mcommand.excute(request, response);
			viewPage = "list.jsp";
		}
		else if(command.equals("/delete.do")) {
			System.out.println("/delete.do¡¢±Ÿ");
			mcommand = new MDeleteCommand(); 
			mcommand.excute(request, response);
			viewPage = "/list.do";
			
		}
		else if(command.equals("/updateForm.do")) {

		}
		else if(command.equals("/updateProc.do")) {

		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, response);
		
	}
}






