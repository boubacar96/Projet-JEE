package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.AuthentificationForm;

/**
 * Servlet implementation class Login
 */
@WebServlet({"/login", "/logout"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_LOGIN = "/WEB-INF/login.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch(request.getServletPath()) {
		  
		  case  "/login":
			  this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
			  break;
		  default:
			  request.getSession().invalidate();
			  response.sendRedirect(request.getContextPath()+"/login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthentificationForm form = new AuthentificationForm(request);
		if(form.authentifier()) {
			
			response.sendRedirect(request.getContextPath()+ "");
		} else {
			
			String path = request.getContextPath() + "/login?error=1 ";
			String sendLogin = form.getLogin();
			path += sendLogin == null ? "" : "&user="+ sendLogin.trim();
			response.sendRedirect(path);
			
		}
		
	}

}
