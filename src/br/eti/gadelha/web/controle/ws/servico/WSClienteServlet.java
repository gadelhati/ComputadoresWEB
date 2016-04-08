package br.eti.gadelha.web.controle.ws.servico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import br.eti.gadelha.ejb.controle.modelo.oque.quem.Pessoa;
import br.eti.gadelha.ejb.controle.modelo.oque.quem.PessoaFisica;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 08/10/2015
 * @see www.gadelha.eti.br
 * */

@WebServlet(description = "Servlet", urlPatterns = { "/WSClientServlet" })
public class WSClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(WSClienteServlet.class.getName());
	
    public WSClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Pessoa objeto = new Pessoa((long)request.getParameter("id"), (Date)request.getParameter("nascimento"), (String)request.getParameter("nome"));
		Pessoa objeto = new PessoaFisica();
		List<Pessoa> lista = new ArrayList<Pessoa>();
		lista.add(objeto);
		
		HttpSession sessao=request.getSession(true);
		
		//CLIENTE RESTeasy
		ResteasyClient cliente = new ResteasyClientBuilder().build();
		ResteasyWebTarget alvo = null;
		Response resposta = null;
		
		switch((String)request.getParameter("escolha")){
		case "alterar":
			try {
				alvo = cliente.target("http://localhost:8080/ControleWEB/rest/WSPessoa/alterar");
				resposta = alvo.request().put(Entity.entity(objeto, MediaType.APPLICATION_JSON));
				log.info("cliente: alterando"+objeto.toString());
				resposta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//dao.alterar(Pessoa);
			break;
		case "consultar":
			try {
				alvo = cliente.target("http://localhost:8080/ControleWEB/rest/WSPessoa/consultar");
				resposta = alvo.request().get();
				//String nome = resposta.readEntity(String.class);//SE FOR SÓ UMA STRING
				//Pessoa pessoa = resposta.readEntity(Pessoa.class);//SE FOR UMA Pessoa
				/*SE FOR UMA LISTA
				Users users = response.readEntity(Users.class);
				for(User user : users.getUsers()){
					System.out.println(user.getId());
					System.out.println(user.getLastName());
				}
				*/
				log.info("cliente: alterando"+objeto.toString());
				resposta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*
			if(dao.consultar(Pessoa) != null){
				sessao.setAttribute("existe", "sim");
			}*/
			break;
		case "excluir":
			try {
				alvo = cliente.target("http://localhost:8080/ControleWEB/rest/WSPessoa/excluir");
				resposta = alvo.request().delete();
				log.info("cliente: excluindo"+objeto.toString());
				resposta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//dao.excluir(Pessoa);
			break;
		case "inserir":
			try {
				alvo = cliente.target("http://localhost:8080/ControleWEB/rest/WSPessoa/inserir");
				resposta = alvo.request().post(Entity.entity(objeto, "application/vnd.com.demo.user-management.user+xml;charset=UTF-8;version=1"));
				//OU resposta = alvo.request().post(Entity.entity(cliente, MediaType.APPLICATION_XML));
				log.info("cliente: resposta obj"+resposta.readEntity(Pessoa.class));
				log.info("cliente: resposta status"+resposta.getStatus());
				log.info("cliente: inserindo"+objeto.toString());
				resposta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//dao.inserir(Pessoa);
			break;
		case "listar":
			try {
				alvo = cliente.target("http://localhost:8080/ControleWEB/rest/WSPessoa/listar");
				resposta = alvo.request().get();
				/*
				lista = resposta.readEntity(List<Pessoa>.class);
				for(Pessoa objeto : lista){
					
				}
				*/
				log.info("cliente: listando"+objeto.toString());
				resposta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//dao.listar();
			break;
		default:
			break;
		}
		
		sessao.setAttribute("Pessoa", objeto);
		sessao.setAttribute("lista", lista);
		RequestDispatcher expediente=request.getRequestDispatcher("/sucesso.jsp");
		expediente.forward(request, response);
		
		//RETORNA: resposta.readEntity(String.class);
				//RETORNA: resposta.readEntity(Pessoa.class);
				//RETORNA: resposta.getStatus(); //RETORNO OK: 200
				//if (resposta.getStatus() != 200) {
					//throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
				//}
	}
}