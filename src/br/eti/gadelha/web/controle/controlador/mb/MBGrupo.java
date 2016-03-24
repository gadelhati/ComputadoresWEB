package br.eti.gadelha.web.controle.controlador.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalGrupo;
import br.eti.gadelha.ejb.controle.modelo.oque.Grupo;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 06/03/2016
 * @see www.gadelha.eti.br
 **/

@ManagedBean(name="mbGrupo")
@SessionScoped
public class MBGrupo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB private DAOLocalGrupo daoGrupo;
	private Grupo grupo;
	private List<Grupo> lista;
	
	public MBGrupo() {
		super();
	}
	@PostConstruct
	public void init() {
		this.grupo = new Grupo();
		this.lista = new ArrayList<>();
		listar();
	}
	
	//CRUD
	public void alterar() {
		if(consultar()){
			daoGrupo.alterar(grupo);
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
			daoGrupo.excluir(grupo);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Excluído"));
		}
	}
	public void inserir() {
		if(!consultar()) {
			daoGrupo.inserir(grupo);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inserido"));
		}
	}
	public void listar() {
		this.lista = daoGrupo.listar();
	}
	
	public void limpar() {
		this.grupo = new Grupo();
	}
	public Boolean validar() {
		try {
			if(grupo!=null){
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
			if(daoGrupo.consultar(grupo) != null) {
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
	public Grupo getGrupo() {
		return grupo;
	}
	public DAOLocalGrupo getDaoGrupo() {
		return daoGrupo;
	}
	public List<Grupo> getLista() {
		return lista;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public void setDaoGrupo(DAOLocalGrupo daoGrupo) {
		this.daoGrupo = daoGrupo;
	}
	public void setLista(List<Grupo> lista) {
		this.lista = lista;
	}
	@Override
	public String toString() {
		return "MBGrupo [daoGrupo=" + daoGrupo + ", grupo=" + grupo + ", lista="
				+ lista + "]";
	}
}