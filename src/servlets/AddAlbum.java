package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.AddAlbumForms;


@WebServlet("/addAlbum")
public class AddAlbum extends HttpServlet {
	private static final long sermialVersionUID = 1L;
	private static final String VUE_ADD_ABLUM = "/WEB-INF/addAlbum.jsp";
       
 
    public AddAlbum() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VUE_ADD_ABLUM).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id != null && id.matches("[0-9]+")) {
		//int id =  Integer.parseInt();
		AddAlbumForms form = new AddAlbumForms(request);
		
		if(form.ajouter(Integer.parseInt(id))) {
			response.sendRedirect(request.getContextPath()+ "/listAlbum");
		}else {
			request.setAttribute("form", form);
			this.getServletContext().getRequestDispatcher(VUE_ADD_ABLUM).forward(request, response);
		}
		}else {
			response.sendRedirect(request.getContextPath()+ "");
		}
	}

}
