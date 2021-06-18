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
import tareag3gil.model.Producto;

/**
 * Servlet implementation class P_bsq
 */
@WebServlet("/P_bsq")
public class P_bsq extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PreparedStatement sen;
	public ResultSet res;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public P_bsq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProcessRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProcessRequest(request, response);
	}

	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto brod=new Producto();
		String nom=request.getParameter("nom");
		try {
			DBconn db=new DBconn();
			String bus="select * from producto where LOWER(nom_producto) = LOWER(?)";
			sen=db.conectar().prepareStatement(bus);
			sen.setString(1, nom);
			res=sen.executeQuery();
			if(res.next()) {
				brod.setId_producto(res.getInt(1));
				brod.setNom_producto(res.getString(2));
				brod.setPro_categoria(res.getString(3));
				brod.setPro_descripcion(res.getString(4));
				brod.setPrecio(res.getDouble(5));
			}
			res.close();
			sen.close();
			db.conectar().close();
			request.setAttribute("sp_data", brod);
			RequestDispatcher rd=request.getRequestDispatcher("p_edit.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
