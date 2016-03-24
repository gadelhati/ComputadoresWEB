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
	<title>cabecalho JSP</title>
	<link rel='stylesheet' href='css/style.css' type='text/css' />
	<link rel="shortcut icon" href="imagens/favicon.ico" type="image/x-icon" />
</head>
<body>

	<form action="${pageContext.request.contextPath}/ServletUsuario" method="post">
	
	<div class="ferramenta">
		<a href="logIn.jsp"><img src="${pageContext.request.contextPath}/imagens/login.png" alt="login" title="Login" /></img></a>
		<a href="ServletUsuario?escolha=listar"><img src="${pageContext.request.contextPath}/imagens/usuario.png" alt="usuario" title="Usuários" /></img></a>
		<a href="ServletEstrutura?escolha=listar"><img src="${pageContext.request.contextPath}/imagens/estrutura.png" alt="estrutura" title="Estruturas" /></img></a>
		<a href="ServletCego?escolha=listar"><img src="${pageContext.request.contextPath}/imagens/estrutura.png" alt="cego" title="Sinais Cegos" /></img></a>
		<a href="ServletFarol?escolha=listar"><img src="${pageContext.request.contextPath}/imagens/farol.png" alt="farol" title="Faróis" /></img></a>
		<a href="ServletMantenedor?escolha=listar"><img src="${pageContext.request.contextPath}/imagens/torre.png" alt="mantenedor" title="Mantenedores" /></img></a>
		<a href="ServletRadar?escolha=listar"><img src="${pageContext.request.contextPath}/imagens/radar.png" alt="radar" title="Radares" /></img></a>
		<a href="ServletFormato?escolha=listar"><img src="${pageContext.request.contextPath}/imagens/farol.png" alt="formato" title="Formatos" /></img></a>
	</div>
	
	<div class="estrutura">
		<div>
		<table>
			<tr>
				<th colspan="4">
					<img class="logo" src="${pageContext.request.contextPath}/imagens/InstitutoHidrográfico.png" alt="IH" /></img>
				</th>
			</tr>
			<tr>
				<c:if test="${usuario!=null}">
					<th colspan="4">
						<c:out value="${usuario.email}"/>
					</th>
					<th colspan="2"><input type="submit" name="escolha" value="logout" /></th>
				</c:if>
				<c:if test="${usuario==null}">
					<tr><td colspan="2"><input type="email" id="email" name="email" placeholder="e-mail" tabindex="1" required="required" title="Entre com um email válido" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" /></td></tr>
					<tr><td colspan="2"><input type="password" id="senha" name="senha" placeholder="Senha" tabindex="2" required="required" title="Entre com sua senha" pattern="[a-zA-Z0-9]*"/></td></tr>
					<th colspan="2"><input type="submit" name="escolha" value="login" /></th>
				</c:if>
			</tr>		
		</table>
		</div>
	</div>
	falta a opção de logOf dentro de cabeçalho
	
	</form>
</body>
</html>
	