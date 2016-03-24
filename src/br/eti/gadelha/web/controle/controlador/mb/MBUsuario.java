package br.eti.gadelha.web.controle.controlador.mb;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.primefaces.event.CaptureEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import br.eti.gadelha.ejb.controle.interfaces.local.DAOLocalUsuario;
import br.eti.gadelha.ejb.controle.modelo.oque.quem.Usuario;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@ManagedBean(name="mbUsuario")
@ViewScoped
public class MBUsuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB private DAOLocalUsuario daoUsuario;
	private Usuario usuario;
	private List<Usuario> lista;
	
	private String filename;
	private String ass;
	
	public MBUsuario() {
		super();
	}
	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
		this.lista = new ArrayList<>();
		listar();
	}
	
	//VALIDANDO A SESSÃO
	public String logIn() {
		try {
			if(consultar()){//!=null
				if(daoUsuario.consultar(usuario).getId() == usuario.getId()) {
					if(daoUsuario.consultar(usuario).getSenha().equals(usuario.getSenha())) {
						FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
						FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lista", daoUsuario.listar());
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Seção iniciada"));
						
						System.out.println("SO: "+System.getProperty("os.name"));
						System.out.println("Arquitetura do SO: "+System.getProperty("os.arch"));
						System.out.println("Usuário do SO: "+System.getProperty("user.name"));
						System.out.println("Versão do JRE: "+System.getProperty("java.version"));
						System.out.println("Versão do JVM: "+System.getProperty("java.vm.specification.version"));
						SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd/MM/yyyy ");  
						System.out.println("Hora do Sistema: "+ sdf.format(new Date()));
						//FacesContext.getCurrentInstance().getExternalContext().redirect("Filtro/paginas/crud/usuario.xhtml");
						
						Runtime rt = Runtime.getRuntime(); 
					    System.out.println("Memória total " + rt.totalMemory());
					    System.out.println("Memória livre " + rt.freeMemory());  
					    System.out.println("Máximo memória: " + rt.maxMemory());  
					    System.out.println("Número de processadores: " + rt.availableProcessors());
						
						InetAddress localHost = InetAddress.getLocalHost();
					    NetworkInterface netInter = NetworkInterface.getByInetAddress( localHost );
					    byte[] macAddressBytes = netInter.getHardwareAddress();
					    String macAddress =  String.format ( "%1$02x-%2$02x-%3$02x-%4$02x-%5$02x-%6$02x",
					    macAddressBytes[0], macAddressBytes[1],
					    macAddressBytes[2], macAddressBytes[3],
					    macAddressBytes[4], macAddressBytes[5] ).toUpperCase();
					    System.out.println("MAC: "+macAddress);
					    
					    try {
					    	System.out.println("Nome do PC: "+InetAddress.getLocalHost().getHostName());
					    	System.out.println("IP do PC: "+InetAddress.getLocalHost().getHostAddress());
					    } catch (UnknownHostException e) {
					    	e.printStackTrace();
					    }
					    
						return "/Filtro/paginas/crud/usuario.xhtml";
					}else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Senha incorreta"));
					}
				}else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário não encontrado"));
				}
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Seção não iniciada"));
				//ou inserir();
			}
		}catch (Exception e){
			System.out.println("catch");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("catch"));
			e.printStackTrace();
		}
		return null;
	}
	//INVALIDANDO A SESSÃO
	public String logOff() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
  		return "/index.xhtml";
	}
	
	//CRUD
	public void alterar() {
		if(consultar()){
			daoUsuario.alterar(usuario);
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
			daoUsuario.excluir(usuario);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Excluído"));
		}
	}
	public void inserir() {
		if(!consultar()) {
			daoUsuario.inserir(usuario);
			listar();
			limpar();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inserido"));
		}
	}
	public void listar() {
		this.lista = daoUsuario.listar();
	}
	
	public void limpar() {
		this.usuario = new Usuario();
	}
	public Boolean validar() {
		try {
			if(usuario!=null){
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
			if(daoUsuario.consultar(usuario) != null) {
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
	public Usuario getUsuario() {
		return usuario;
	}
	public DAOLocalUsuario getDaoUsuario() {
		return daoUsuario;
	}
	public List<Usuario> getLista() {
		return lista;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setDaoUsuario(DAOLocalUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
	@Override
	public String toString() {
		return "MBUsuario [daoUsuario=" + daoUsuario + ", usuario=" + usuario + ", lista=" + lista + ", filename="
				+ filename + ", ass=" + ass + "]";
	}
	
	//MAIS
	
	public void inativo() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Inatividade.", "O que está fazendo?"));
	}
	public void ativo() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Bem vindo de volta", "Bem, foi um longo cafézinho!"));
	}
	
	public String getAss() {
		return ass;
	}
	public void setAss(String ass) {
		this.ass = ass;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	private String getRandomImageName() {
		int i = (int) (Math.random() * 10000000);
		return String.valueOf(i);
	}
	public String getFilename() {
		return filename;
	}
	public void oncapture(CaptureEvent captureEvent) {
		filename = getRandomImageName();
		byte[] data = captureEvent.getData();
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		//String newFileName = servletContext.getRealPath( File.separator + "Filtro" + File.separator + "imagens" + File.separator + filename + ".png");
		String newFileName = servletContext.getRealPath("/Filtro/nova/" + filename + ".png");
		//String newFileName = servletContext.getRealPath(getFilename());
		//String arquivoFoto = servletContext.getRealPath(File.separator + "imagens" + File.separator + "tmp" + File.separator + foto);
		FileImageOutputStream imageOutput;
		try {
			imageOutput = new FileImageOutputStream(new File(newFileName));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
		}
		catch(IOException e) {
			throw new FacesException("Error in writing captured image.", e);
		}
	}
	
	public void onRowSelect(SelectEvent event) {}
	public void onRowUnselect(UnselectEvent event) {}
	public void onRowDblClckSelect(final SelectEvent event) {}
	
	/*
	public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" + File.separator + "images" + File.separator + "prime_logo.png";
         
        pdf.add(Image.getInstance(logo));
    }
	*/
}