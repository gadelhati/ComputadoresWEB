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

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalFuncao;
import br.eti.gadelha.ejb.controle.modelo.como.Funcao;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 04/03/2016
 * @see www.gadelha.eti.br
 **/

@ManagedBean(name="mbFuncao")
@ViewScoped
public class MBFuncao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB private DAOLocalFuncao daoFuncao;
	private Funcao funcao;
	private List<Funcao> lista;
	
	public MBFuncao() {
		super();
	}
	@PostConstruct
	public void init() {
		this.funcao = new Funcao();
		this.lista = new ArrayList<>();
		listar();
	}
	
	//CRUD
	public void alterar() {
		if(consultar()){
			daoFuncao.alterar(funcao);
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
			daoFuncao.excluir(funcao);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Excluído"));
		}
	}
	public void inserir() {
		if(!consultar()) {
			daoFuncao.inserir(funcao);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inserido"));
		}
	}
	public void listar() {
		this.lista = daoFuncao.listar();
	}
	
	public void limpar() {
		this.funcao = new Funcao();
	}
	public Boolean validar() {
		try {
			if(funcao!=null){
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
			if(daoFuncao.consultar(funcao) != null) {
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
	public Funcao getFuncao() {
		return funcao;
	}
	public DAOLocalFuncao getDaoFuncao() {
		return daoFuncao;
	}
	public List<Funcao> getLista() {
		return lista;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	public void setDaoFuncao(DAOLocalFuncao daoFuncao) {
		this.daoFuncao = daoFuncao;
	}
	public void setLista(List<Funcao> lista) {
		this.lista = lista;
	}
	@Override
	public String toString() {
		return "MBFuncao [daoFuncao=" + daoFuncao + ", funcao=" + funcao + ", lista="
				+ lista + "]";
	}
}