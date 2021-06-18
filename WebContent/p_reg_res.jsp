<jsp:useBean id="sp_data" class="tareag3gil.model.Producto" scope="request"></jsp:useBean>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registro exitoso</h1>
<table>
	<tr>
		<td>Codigo: </td>
		<td><%=sp_data.getId_producto() %></td>
	</tr>
	<tr>
		<td>Nombre: </td>
		<td><%=sp_data.getNom_producto() %></td>
	</tr>
	<tr>
		<td>Precio: </td>
		<td><%=sp_data.getPrecio() %></td>
	</tr>
	<tr>
		<td>Descripcion: </td>
		<td><%=sp_data.getPro_descripcion() %></td>
	</tr>
	<tr>
		<td>Categoria: </td>
		<td><%=sp_data.getPro_categoria() %></td>
	</tr>
	<tr>
	<td><a href="index.jsp"><button class="btn">Volver</button></a></td>
	</tr>
</table>
</body>
</html>