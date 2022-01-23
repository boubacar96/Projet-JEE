package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDao;


@WebServlet("/update")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_UPDATE_USER = "/WEB-INF/modifieruser.jsp";
       

    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
				
			if(id != null && id.matches("[0-9]+")) {
			Utilisateur user = UtilisateurDao.get(Integer.parseInt(id));
			request.setAttribute("utilisateur", user);
			this.getServletContext().getRequestDispatcher(VUE_UPDATE_USER).forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath()+"/listUser");
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String profil = request.getParameter("profil");
		
		if(id != null && id.matches("[0-9]+")) {
			UtilisateurDao.modifier(new Utilisateur(Integer.parseInt(id), nom, prenom, login, password, profil));
			response.sendRedirect(request.getContextPath()+"/listUser");
			} else {
				response.sendRedirect(request.getContextPath()+"/listUser");
			}
	}

}
