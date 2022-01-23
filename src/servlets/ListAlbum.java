package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlbumDao;


@WebServlet("/listAlbum")
public class ListAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_LIST_ALBUM = "/WEB-INF/listAlbum.jsp";
       
    
    public ListAlbum() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("albums", AlbumDao.listerAlbum());
		this.getServletContext().getRequestDispatcher(VUE_LIST_ALBUM).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
