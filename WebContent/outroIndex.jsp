<%@ page
	info="Desenvolvido por Marcelo Gadelha"
	language="java"
	session="true"
	buffer="10kb"
	autoFlush="true"
	isErrorPage="false"
	errorPage="paginas/erros/erro.jsp"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- JSTL -->

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link rel='stylesheet' href='css/style.css' type='text/css' />
<link rel="shortcut icon" href="imagens/favicon.ico" type="image/x-icon" />
</head>
<body>

	<form action="${pageContext.request.contextPath}/Servlet" method="post">
		<input type="email" name="email" placeholder="e-mail" tabindex="1" required="required" title="Entre com um email válido" />
		<input type="password" name="senha" placeholder="Senha" tabindex="2" required="required" title="Entre com sua senha" />
		<input type="submit" name="escolha" value="alterar" />
	</form>
	
	<form action="${pageContext.request.contextPath}/Servlet" method="post">
		<input type="email" name="email" placeholder="e-mail" tabindex="1" required="required" title="Entre com um email válido" />
		<input type="password" name="senha" placeholder="Senha" tabindex="2" required="required" title="Entre com sua senha" />
		<input type="submit" name="escolha" value="consultar" />
	</form>
	
	<form action="${pageContext.request.contextPath}/Servlet" method="post">
		<input type="email" name="email" placeholder="e-mail" tabindex="1" required="required" title="Entre com um email válido" />
		<input type="password" name="senha" placeholder="Senha" tabindex="2" required="required" title="Entre com sua senha" />
		<input type="submit" name="escolha" value="excluir" />
	</form>
	
	<form action="${pageContext.request.contextPath}/Servlet" method="post">
		<input type="email" name="email" placeholder="e-mail" tabindex="1" required="required" title="Entre com um email válido" />
		<input type="password" name="senha" placeholder="Senha" tabindex="2" required="required" title="Entre com sua senha" />
		<input type="submit" name="escolha" value="inserir" />
	</form>
	
	<form action="${pageContext.request.contextPath}/Servlet" method="post">
		<input type="submit" name="escolha" value="listar" />
	</form>

</body>
</html>