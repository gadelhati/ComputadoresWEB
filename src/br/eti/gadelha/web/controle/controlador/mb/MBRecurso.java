package br.eti.gadelha.web.controle.controlador.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalRecurso;
import br.eti.gadelha.ejb.controle.modelo.oque.Recurso;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@ManagedBean(name="mbRecurso")
@ViewScoped
public class MBRecurso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB private DAOLocalRecurso daoRecurso;
	private Recurso recurso;
	private List<Recurso> lista;
    
	public MBRecurso() {
		super();
	}
	@PostConstruct
	public void init() {
		this.recurso = new Recurso();
		this.lista = new ArrayList<>();
		listar();
	}
	
	//CRUD
	public void alterar() {
		if(consultar()){
			daoRecurso.alterar(recurso);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alterado"));
		}
	}
	public Boolean consultar() {
		if(validar()) {
			if(autenticar()) {
				listar();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Encontrado"));
				return true;
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não encontrado"));
				return false;
			}
		}else {
			return null;
		}
	}
	public void excluir() {
		if(consultar()) {
			daoRecurso.excluir(recurso);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Excluído"));
		}
	}
	public void inserir() {
		if(!consultar()) {
			daoRecurso.inserir(recurso);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inserido"));
		}
	}
	public void listar() {
		this.lista = daoRecurso.listar();
	}
	
	public void limpar() {
		this.recurso = new Recurso();
	}
	public Boolean validar() {
		try {
			if(recurso!=null){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Válido"));
				return true;
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não válido"));
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Boolean autenticar() {
		try {
			if(daoRecurso.consultar(recurso) != null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Autenticado"));
				return true;
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não autenticado"));
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Boolean autorizar() {
		return null;
	}
	
	//GET & SET
	public Recurso getRecurso() {
		return recurso;
	}
	public DAOLocalRecurso getDaoRecurso() {
		return daoRecurso;
	}
	public List<Recurso> getLista() {
		return lista;
	}
	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	public void setDaoRecurso(DAOLocalRecurso daoRecurso) {
		this.daoRecurso = daoRecurso;
	}
	public void setLista(List<Recurso> lista) {
		this.lista = lista;
	}
	@Override
	public String toString() {
		return "MBRecurso [daoRecurso=" + daoRecurso + ", recurso=" + recurso + ", lista=" + lista + "]";
	}
}