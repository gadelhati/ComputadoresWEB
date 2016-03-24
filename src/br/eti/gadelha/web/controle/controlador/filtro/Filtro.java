package br.eti.gadelha.web.controle.controlador.filtro;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.jboss.logging.Logger;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 06/10/2015
 * @see www.gadelha.eti.br
 **/

@WebFilter("/Filtro/*")
public class Filtro implements Filter, Serializable {

	private static final long serialVersionUID = 1L;
    public Filtro() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String ip = request.getRemoteAddr();
		Logger.getLogger(this.getClass()).info("Filtro: ip "+ip);
		/*
			HttpServletRequest requisicao = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			HttpSession sessao = requisicao.getSession();
			Aluno aluno = (Aluno) sessao.getAttribute("aluno");
		*/
		//HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			//HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			//Aluno aluno = (Aluno)session.getAttribute("aluno");
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aluno", aluno);
		/*
		Aluno aluno = (Aluno)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aluno");
		if(aluno == null){
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		}else {
			// pass the request along the filter chain
			Aluno aluno2 = new Aluno();
			aluno2.setId(34);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aluno", aluno2);
			chain.doFilter(request, response);
			FacesContext.getCurrentInstance().getExternalContext().redirect("Filtro/paginas/sucesso.xhtml");
		}*/
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}