package tareag3gil.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconn {
	private Connection con;
	private String driver="com.mysql.cj.jdbc.Driver";
	private String cadena="jdbc:mysql://localhost:3306/sistema_facturacion";
	private String user="root";
	private String clave="";
	
	public Connection conectar() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(cadena,user,clave);
		}catch (Exception e) {
			
		}
		return con;
	}
	
}
