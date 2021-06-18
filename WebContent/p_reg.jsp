<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Nuevo producto</h1>
	<form action="P_reg" method="POST">
    <table>
    <tr>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Descripcion</th>
			<th>Categoria</th>
		</tr>
    <tr>
           <td><input type="text" name="txtNombre" size="12">
           <td><input type="text" name="txtPrecio" size="4"></td>
           <td><input type="text" name="txtDescripcion"></td>
           <td><input type="text" name="txtCategoria"></td>
           <td><input type="submit" value="Registrar"></td> 
    </tr>
    </table>
    </form>
</body>
</html>