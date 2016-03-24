package br.eti.gadelha.web.controle.controlador.mb;

public class MBLog {
	/*
	//VALIDANDO A SESSÃO
	public String logIn() {
		try {
			if(consultar()){//!=null
				//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("atributo");
				if(daoPessoa.consultar(pessoa).getId() == pessoa.getId()) {
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pessoa", pessoa);
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
	public String logOut() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.xhtml";
	}
	*/
}