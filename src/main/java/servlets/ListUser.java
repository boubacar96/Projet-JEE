package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDao;

/**
 * Servlet implementation class ListUser
 */
@WebServlet("/listUser")
public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_LIST_USERS = "/WEB-INF/listerusers.jsp";
       

    public ListUser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("utilisateurs", UtilisateurDao.lister());
		this.getServletContext().getRequestDispatcher(VUE_LIST_USERS).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

}
