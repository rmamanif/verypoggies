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
 * Servlet implementation class P_upd
 */
@WebServlet("/P_upd")
public class P_upd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PreparedStatement sen;
	public ResultSet res;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public P_upd() {
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
		Integer cod=Integer.parseInt(request.getParameter("txtCodigo"));
		String nom=request.getParameter("txtNombre");
		Double pre=Double.parseDouble(request.getParameter("txtPrecio"));
		String des=request.getParameter("txtDescripcion");	
		String cat=request.getParameter("txtCategoria");
		try {
			DBconn db=new DBconn();
			Producto prod=new Producto();
			String actualizar= "update producto set nom_producto=?, pro_categoria=?,pro_descripcion=?,precio=?  where id_producto=?";
			sen=db.conectar().prepareStatement(actualizar);
			sen.setString(1, nom);
			sen.setString(2, cat);
			sen.setString(3, des);
			sen.setDouble(4, pre);
			sen.setInt(5, cod);
			sen.executeUpdate();
			String bus="select * from producto where LOWER(nom_producto) = LOWER(?)";
			sen=db.conectar().prepareStatement(bus);
			sen.setString(1, nom);
			res=sen.executeQuery();
			if(res.next()) {
				prod.setId_producto(res.getInt(1));
				prod.setNom_producto(res.getString(2));
				prod.setPro_categoria(res.getString(3));
				prod.setPro_descripcion(res.getString(4));
				prod.setPrecio(res.getDouble(5));
			}
			res.close();
			sen.close();
			db.conectar().close();
			request.setAttribute("sp_data", prod);
			RequestDispatcher rd=request.getRequestDispatcher("p_edit.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
