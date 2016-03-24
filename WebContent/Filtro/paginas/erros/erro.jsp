<%@ page
	info="Desenvolvido por Marcelo Gadelha"
	language="java"
	session="true"
	buffer="10kb"
	autoFlush="true"
	isErrorPage="true"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erro - JSP</title>
<link rel='stylesheet' href='css/style.css' type='text/css' />
<link rel="shortcut icon" href="imagens/favicon.ico" type="image/x-icon" />
<script type="text/javascript" src="js/js.js"> </script>
</head>
<body>
	Erro:<%=exception.toString()%>
	<img src="${pageContext.request.contextPath}/Filtro/paginas/imagens/InstitutoHidrográficoPB.png" alt="IH" /></img>
</body>
</html>