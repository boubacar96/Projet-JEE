package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.AlbumDao;
import dao.ImageDao;


@WebServlet("/viewAlbum")
public class AfficherAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_LIST_IMAGES = "/WEB-INF/afficherAlbum.jsp";
       
    
    public AfficherAlbum() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, JSONException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		if(id != null && id.matches("[0-9]+")) {
			if(AlbumDao.getAlbum(Integer.parseInt(id)) != null) {
				request.setAttribute("album", AlbumDao.getAlbum(Integer.parseInt(id)));
				//request.setAttribute("images", ImageDao.listerImageAlbum(Integer.parseInt(id)));
				 //System.out.println(request.getServletContext().getRealPath("/Albums"));
				this.getServletContext().getRequestDispatcher(VUE_LIST_IMAGES).forward(request, response);	
			
			}else {
				response.sendRedirect(request.getContextPath() + "");
			}
			
		}else {
			response.sendRedirect(request.getContextPath() + "");
		}
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
