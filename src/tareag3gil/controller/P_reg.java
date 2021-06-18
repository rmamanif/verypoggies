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
 * Servlet implementation class P_reg
 */
@WebServlet("/P_reg")
public class P_reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public PreparedStatement sen;
	public ResultSet res;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public P_reg() {
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
		String nom=request.getParameter("txtNombre");
		Double pre=Double.parseDouble(request.getParameter("txtPrecio"));
		String des=request.getParameter("txtDescripcion");	
		String cat=request.getParameter("txtCategoria");
		Producto brod= new Producto();
		if(nom.toString().isBlank() || cat.isBlank()) {
			response.sendRedirect("p_reg.jsp");
		}else if(des.toString().isBlank() || pre.toString().isBlank()) {
			response.sendRedirect("p_reg.jsp");
		}else {
		try {DBconn db=new DBconn();
			String registro= "insert into producto (nom_producto,pro_categoria,pro_descripcion,precio) values (?,?,?,?)";
			sen=db.conectar().prepareStatement(registro);
			sen.setString(1, nom);
			sen.setString(2, cat);
			sen.setString(3, des);
			sen.setDouble(4, pre);
			sen.executeUpdate();
			String info_reg="select * from producto where LOWER(nom_producto)=LOWER(?)";
			sen=db.conectar().prepareStatement(info_reg);
			sen.setString(1, nom);
			res=sen.executeQuery();
			if(res.next()) {
				brod.setId_producto(res.getInt(1));
				brod.setNom_producto(res.getString(2));
				brod.setPro_descripcion(res.getString(3));
				brod.setPro_categoria(res.getString(4));
				brod.setPrecio(res.getDouble(5));
			res.close();
			sen.close();
			db.conectar().close();
			}
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("p_reg.jsp");
			rd.forward(request, response);}
		request.setAttribute("sp_data", brod);
		RequestDispatcher rd=request.getRequestDispatcher("p_reg_res.jsp");
			rd.forward(request, response);
		}
	}

}
