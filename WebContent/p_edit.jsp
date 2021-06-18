<jsp:useBean id="sp_data" class="tareag3gil.model.Producto" scope="request"></jsp:useBean>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Producto</h3>
<form action="P_upd" method="POST">
<table>
	<tr>
		<td>Codigo: </td>
		<td><input name="txtCodigo" value="<%=sp_data.getId_producto() %>" readonly="readonly"></td>
	</tr>
	<tr>
		<td>Nombre: </td>
		<td><input name="txtNombre" value="<%=sp_data.getNom_producto() %>"></td>
	</tr>
	<tr>
		<td>Categoria: </td>
		<td><input name="txtCategoria" value="<%=sp_data.getPro_categoria() %>"></td>
	</tr>
	<tr>
		<td>Descripcion </td>
		<td><input name="txtDescripcion" value="<%=sp_data.getPro_descripcion() %>"> </td>
	</tr>
	<tr>
		<td>Precio</td>
		<td><input name="txtPrecio" value="<%=sp_data.getPrecio() %>"></td>
	</tr>
	<tr>
	<td><input type="submit" value="Actualizar"> </td>
	</tr>
</table>
</form>
	<a href="index.jsp">Volver</a>
</body>
</html>