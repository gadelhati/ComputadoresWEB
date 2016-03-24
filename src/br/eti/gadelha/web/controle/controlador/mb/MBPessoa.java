package br.eti.gadelha.web.controle.controlador.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalPessoa;
import br.eti.gadelha.ejb.controle.modelo.oque.quem.Pessoa;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@ManagedBean(name="mbPessoa")
@ViewScoped
public class MBPessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB private DAOLocalPessoa daoPessoa;
	private Pessoa pessoa;
	private List<Pessoa> lista;
	private List<Pessoa> selecionados;
    
	public MBPessoa() {
		super();
	}
	@PostConstruct
	public void init() {
		this.pessoa = new Pessoa();
		this.lista = new ArrayList<>();
		this.selecionados = new ArrayList<>();
		listar();
	}
	
	//VALIDANDO A SESSÃO
	public String logIn() {
		try {
			if(consultar()){//!=null
				//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("atributo");
				if(daoPessoa.consultar(pessoa).getId() == pessoa.getId()) {
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pessoa", pessoa);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id", pessoa.getId());
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lista", daoPessoa.listar());
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Seção iniciada"));
					return "/Filtro/paginas/crud/pessoa.xhtml";
				}
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Seção não iniciada"));
				//ou inserir();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//INVALIDANDO A SESSÃO
  	public String logOff() throws IOException{
  		/*
  		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", null);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lista", null);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("lista");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Seção encerrada"));
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
		}catch (Exception e){
			e.printStackTrace();
		}
  		*/
  		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
  		return "/index.xhtml";
  	}
  	
	//CRUD
	public void alterar() {
		if(consultar()){
			daoPessoa.alterar(pessoa);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alterado"));
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Manutenção", "Alterado"));
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Manutenção", "Alterado"));
		}
	}
	public Boolean consultar() {
		/*
		URL url = getClass().getResource("/Filtro/sons/cartoon001.wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
		*/
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
			daoPessoa.excluir(pessoa);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Excluído"));
		}
	}
	public void inserir() {
		if(!consultar()) {
			daoPessoa.inserir(pessoa);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inserido"));
		}
	}
	public void listar() {
		this.lista = daoPessoa.listar();
	}
	
	public void limpar() {
		this.pessoa = new Pessoa();
	}
	public Boolean validar() {
		try {
			//(String.valueOf(pessoa.getId()).matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))? true:false
			//"[a-z]{2,20}@[a-z]{2,20}.com(.|)[a-z]{0,2}"
			//"[a-zA-Z0-9]{2,20}"
			if(pessoa!=null){
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
			if(daoPessoa.consultar(pessoa) != null) {
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
		/*
		 * servlet filter
		 * phase listener
		 * container managed security
		 * jguard
		 * spring security
		 * apache shiro	PROPRIETÁRIO
		 */
		return null;
	}
	
	//GET & SET
	public Pessoa getPessoa() {
		return pessoa;
	}
	public DAOLocalPessoa getDaoPessoa() {
		return daoPessoa;
	}
	public List<Pessoa> getLista() {
		return lista;
	}
	public List<Pessoa> getSelecionados() {
		return selecionados;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public void setDaoPessoa(DAOLocalPessoa daoPessoa) {
		this.daoPessoa = daoPessoa;
	}
	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}
	public void setSelecionados(List<Pessoa> selecionados) {
		this.selecionados = selecionados;
	}
	@Override
	public String toString() {
		return "MBPessoa [daoPessoa=" + daoPessoa + ", pessoa=" + pessoa + ", lista=" + lista + ",selecionados=" + selecionados + "]";
	}
	/*
	public void onRowSelect(SelectEvent event) {}
	public void onRowUnselect(UnselectEvent event) {}
	public void onRowDblClckSelect(final SelectEvent event) {}
	*/
}