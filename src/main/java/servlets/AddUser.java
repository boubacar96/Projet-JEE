package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forms.AdduserForm;



/**
 * Servlet implementation class AddUser
 */
@WebServlet("/register")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_ADD_USER = "/WEB-INF/addUser.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VUE_ADD_USER).forward(request, response);
		/*HttpSession session = request.getSession();
    	Object form = session.getAttribute("form");
    	
    	if( form != null) {
    		session.removeAttribute("form");
    	}
    	
    	request.setAttribute("form", form);
		getServletContext().getRequestDispatcher("/WEB-INF/ajoutUtilisateur.jsp").forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdduserForm form = new AdduserForm(request);
		
//		form.ajouter();
//		request.setAttribute("form", form);
//		this.getServletContext().getRequestDispatcher(VUE_ADD_USER).forward(request, response);
		
		if(form.ajouter()) {
			response.sendRedirect(request.getContextPath()+ "");
		} else {
			request.setAttribute("form", form);
			this.getServletContext().getRequestDispatcher(VUE_ADD_USER).forward(request, response);
		}
		
	 }

}
