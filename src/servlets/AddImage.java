package servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.AddAlbumForms;
import forms.AddImageForm;

@MultipartConfig
@WebServlet("/addImage")
public class AddImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_ADD_IMAGE = "/WEB-INF/addImage.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE_ADD_IMAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		if(id != null && id.matches("[0-9]+")){
			int id1 =  Integer.parseInt(request.getParameter("id"));
			AddImageForm form = new AddImageForm(request);

			if(form.ajouter(id1)) {
				response.sendRedirect(request.getContextPath()+ "/listAlbum");
			}else {
				request.setAttribute("form", form);
				this.getServletContext().getRequestDispatcher(VUE_ADD_IMAGE).forward(request, response);
			}
			
		}else {
			response.sendRedirect(request.getContextPath()+ "");
	  }
	}

}
