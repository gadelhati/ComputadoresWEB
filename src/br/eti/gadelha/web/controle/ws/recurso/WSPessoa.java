package br.eti.gadelha.web.controle.ws.recurso;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Form;

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalPessoa;
import br.eti.gadelha.ejb.controle.modelo.oque.quem.Pessoa;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 08/10/2015
 * @see www.gadelha.eti.br
 * */

@WebService
@Path("/WSPessoa")
//Consumes e Produces PODEM VIR AQUI
public class WSPessoa {
	
	//http://localhost:8080/rest/WSPessoa/RecursoPessoa?parametro=ESTE
	//http://localhost:8080/WEBCONTEXT/CLASSLEVEL@PATH/METHODLEVEL@PATH
	//@Path("/{idioma: [A-Z][A-Z]}")
	@GET
	//@Override
	//@Wrapped(element = "mensagensOlaMundo")
	public String digaOla(@QueryParam("parametro") @DefaultValue("Gadelha") String parametro) {  
		return "Olá Mundo! <br /> O parâmetro de \"Query\"enviado foi: " + parametro;  
	}/*  
	//http://localhost:8080/SinaisWEBRE/RecursoPessoa/ESTE
	@GET  
	@Path("/{parametro}")
	public String digaOlaPath(@PathParam("parametro") String parametro) {  
		return "Olá Mundo! <br /> O parâmetro de \"URI\" enviado foi: " + parametro;
	}
	@GET
	@Path("/{message}")
	public Response publishMessage(@PathParam("message") String msgStr){
		String responseStr = "Received message: "+msgStr;
		return Response.status(200).entity(responseStr).build();
	}
	*/

	@EJB DAOLocalPessoa dao;
	public WSPessoa() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path(value = "/teste")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
	public Pessoa teste(/*Pessoa objeto*/) {
		Pessoa objeto = new Pessoa();
		dao.consultar(objeto);
		//return objeto.getEmail();
		return objeto;
	}
	@GET
	@Path(value = "/testar/{valor1}/{valor2}")//PathParam e Regular Expression{}
	@Produces({MediaType.APPLICATION_JSON})
	public Pessoa testar(@PathParam("valor1") Long valor1, @PathParam("valor2") Long valor2) {
		//@PathParam,	/path/valor1/valor2
		//@QueryParam,	/path?parametro1=valor1&parametro2=valor2
		//@MatrixParam,	/path;parametro1=valor1;parametro2=valor2
		//@HeaderParam
		//@FormParam
		//@CookieParam
		Pessoa objeto = new Pessoa();
		objeto.setId(valor1);
		return dao.consultar(objeto);
	}
	
	private static final Logger log = Logger.getLogger(WSPessoa.class.getName());
	//CRUD
	@PUT
	@Path(value = "/alterar")
	public void alterar(@Form Pessoa objeto) {
		log.info("web: altetando"+objeto.toString());
		dao.alterar(objeto);
	}
	@GET
	@Path(value = "/consultar")
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa consultar(@Form Pessoa objeto) {
		log.info("web: consultando"+objeto.toString());
		return dao.consultar(objeto);
	}
	@DELETE
	@Path(value = "/excluir")
	public void excluir(@Form Pessoa objeto) {
		log.info("web: excluindo"+objeto.toString());
		dao.excluir(objeto);
	}
	@POST
	@Path(value = "/inserir")
	@Consumes("application/vnd.com.demo.user-management.user+xml;charset=UTF-8;version=1")
	public void inserir(Pessoa objeto) {
		log.info("web: inserindo"+objeto.toString());
		dao.inserir(objeto);
		//return Response.status(200);
	}
	@GET
	@Path(value = "/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> listar() {
		log.info("web: listando");
		return dao.listar();
	}
	@POST
	@Path(value = "/forma")
	public void forma(@FormParam("id") Long id, @FormParam("nascimento") Date nascimento, @FormParam("nome") String nome) {
		Pessoa objeto = new Pessoa(id, nascimento, nome);
		log.info("web: inserindo"+objeto.toString());
		dao.inserir(objeto);
		//return Response.status(200);
	}
}