package tareag3gil.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tareag3gil.model.DBconn;

/**
 * Servlet implementation class P_dlt
 */
@WebServlet("/P_dlt")
public class P_dlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PreparedStatement sen;
	public ResultSet res;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public P_dlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProcessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProcessRequest(request, response);
		
	}
	
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom=request.getParameter("nom");
		try {
			DBconn db=new DBconn();
			String bus="delete from producto where LOWER(nom_producto) = LOWER(?)";
			sen=db.conectar().prepareStatement(bus);
			sen.setString(1, nom);
			sen.executeUpdate();
			sen.close();
			db.conectar().close();
			RequestDispatcher rd=request.getRequestDispatcher("P_list");
			rd.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
