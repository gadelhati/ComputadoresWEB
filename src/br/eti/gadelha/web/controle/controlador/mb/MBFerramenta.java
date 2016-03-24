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

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalFerramenta;
import br.eti.gadelha.ejb.controle.modelo.oque.Ferramenta;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 05/12/2015
 * @see www.gadelha.eti.br
 **/

@ManagedBean(name="mbFerramenta")
@ViewScoped
public class MBFerramenta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB private DAOLocalFerramenta daoFerramenta;
	private Ferramenta ferramenta;
	private List<Ferramenta> lista;
	
	public MBFerramenta() {
		super();
	}
	@PostConstruct
	public void init() {
		this.ferramenta = new Ferramenta();
		this.lista = new ArrayList<>();
		listar();
	}
	
	//CRUD
	public void alterar() {
		if(consultar()){
			daoFerramenta.alterar(ferramenta);
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
			daoFerramenta.excluir(ferramenta);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Excluído"));
		}
	}
	public void inserir() {
		if(!consultar()) {
			daoFerramenta.inserir(ferramenta);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inserido"));
		}
	}
	public void listar() {
		this.lista = daoFerramenta.listar();
	}
	
	public void limpar() {
		this.ferramenta = new Ferramenta();
	}
	public Boolean validar() {
		try {
			if(ferramenta!=null){
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
			if(daoFerramenta.consultar(ferramenta) != null) {
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
	public Ferramenta getFerramenta() {
		return ferramenta;
	}
	public DAOLocalFerramenta getDaoFerramenta() {
		return daoFerramenta;
	}
	public List<Ferramenta> getLista() {
		return lista;
	}
	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}
	public void setDaoFerramenta(DAOLocalFerramenta daoFerramenta) {
		this.daoFerramenta = daoFerramenta;
	}
	public void setLista(List<Ferramenta> lista) {
		this.lista = lista;
	}
	@Override
	public String toString() {
		return "MBFerramenta [daoFerramenta=" + daoFerramenta + ", ferramenta=" + ferramenta + ", lista="
				+ lista + "]";
	}
}