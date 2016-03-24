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
	<title>ferramentas JSP</title>
	<link rel='stylesheet' href='css/style.css' type='text/css' />
	<link rel="shortcut icon" href="imagens/favicon.ico" type="image/x-icon" />
</head>
<body>

	<div class="ferramenta">
	<a target="_blank" href="http://www.oracle.com/br/technologies/java/overwiew/index.html"><img src="${pageContext.request.contextPath}/imagens/java.png" alt="java" title="JAVA 8" /></img></a>
	<a target="_blank" href="http://www.eclipse.org"><img src="${pageContext.request.contextPath}/imagens/eclipse.png" alt="eclipse" title="Eclipse Luna" /></img></a>
	<a target="_blank" href="http://www.eclipse.org/egit/"><img src="${pageContext.request.contextPath}/imagens/egit.png" alt="egit" title="EGit" /></img></a>
	<a target="_blank" href="http://www.github.com"><img src="${pageContext.request.contextPath}/imagens/github.png" alt="github" title="Git Hub" /></img></a>
	<!-- <a target="_blank" href="http://www.tomcat.apache.org/"><img src="${pageContext.request.contextPath}/imagens/tomcat.png" alt="tomcat" title="Apache Tomcat" /></img></a> -->
	<a target="_blank" href="http://www.wildfly.org"><img src="${pageContext.request.contextPath}/imagens/wildfly.png" alt="wildfly" title="WildFly 8.1" /></img></a>
	<a target="_blank" href="http://www.hibernate.org"><img src="${pageContext.request.contextPath}/imagens/hibernate.png" alt="hibernate" title="Hibernate" /></img></a>
	
	<a target="_blank" href="http://www.postgresql.org/"><img src="${pageContext.request.contextPath}/imagens/postgresql.png" alt="postgresql" title="PostgreSQL" /></img></a>
	<!-- <a target="_blank" href="http://www.mysql.com/"><img src="${pageContext.request.contextPath}/imagens/mysql.png" alt="mysql" title="MySQL" /></img></a> -->
	
	<a target="_blank" href="http://www.w3c.org"><img src="${pageContext.request.contextPath}/imagens/html5.png" alt="html5" title="HTML5" /></img></a>
	<a target="_blank" href="http://www.w3c.org"><img src="${pageContext.request.contextPath}/imagens/css3.png" alt="css3" title="CSS3" /></img></a>
	
	<!-- <a target="_blank" href="#"><img src="${pageContext.request.contextPath}/imagens/javascript.png" alt="javascript" title="Java Script" /></img></a> -->
	<!-- <a target="_blank" href="jquery.com"><img src="${pageContext.request.contextPath}/imagens/jquery.png" alt="jquery" title="JQuery" /></img></a> -->
	
	<a target="_blank" href="http://www.jsp.com"><img src="${pageContext.request.contextPath}/imagens/jsp.png" alt="jsp" title="JSP" /></img></a>
	<a target="_blank" href="http://www.javaserverfaces.java.net"><img src="${pageContext.request.contextPath}/imagens/jsf.png" alt="jsf" title="JSF" /></img></a>
	<a target="_blank" href="http://www.primefaces.org"><img src="${pageContext.request.contextPath}/imagens/primefaces.png" alt="primefaces" title="Primefaces" /></img></a>
	
	<!-- <a target="_blank" href="http://www.astah.net/"><img src="${pageContext.request.contextPath}/imagens/astah.png" alt="astah" title="Astah" /></img></a> -->
	<!-- <a target="_blank" href="http://www.junit.org/"><img src="${pageContext.request.contextPath}/imagens/junit.png" alt="junit" title="JUnit" /></img></a> -->
	</div>
	
</body>
</html>