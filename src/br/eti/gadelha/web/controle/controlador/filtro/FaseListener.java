package br.eti.gadelha.web.controle.controlador.filtro;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

public class FaseListener implements PhaseListener {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		//Logger.getLogger(this.getClass()).info("Finalizando Fase: "+event.getPhaseId());
		
		FacesContext facesContext = event.getFacesContext();
		String paginaCorrente = facesContext.getViewRoot().getViewId();
		
		boolean pagina = (paginaCorrente.lastIndexOf("index.xhtml") > -1);//RECUPERANDO PÁGINA CORRENTE
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		Object usuario = session.getAttribute("usuario");//RECUPERANDO OBJETO DA SESSÃO
		
		NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
		if (!pagina && usuario == null) {//INAUTENTICO
			navigationHandler.handleNavigation(facesContext, null, "Index");//REDIRECIONA
		}else {//AUTENTICO
			/*boolean paginaPessoa = (paginaCorrente.lastIndexOf("pessoa.xhtml") > -1);//RECUPERANDO PÁGINA CORRENTE
			if(pessoa instanceof Pessoa && !paginaPessoa){//DESAUTORIZADO
				navigationHandler.handleNavigation(facesContext, null, "/Filtro/paginas/crud/pessoa.xhtml");//REDIRECIONA
			}
			boolean paginaPessoaFisica = (paginaCorrente.lastIndexOf("pessoaFisica.xhtml") > -1);//RECUPERANDO PÁGINA CORRENTE
			if(pessoa instanceof PessoaFisica && !paginaPessoaFisica){//DESAUTORIZADO
				navigationHandler.handleNavigation(facesContext, null, "/Filtro/paginas/crud/pessoaFisica.xhtml");//REDIRECIONA
			}*/
		}
	}
	@Override
	public void beforePhase(PhaseEvent event) {
		//Logger.getLogger(this.getClass()).info("Iniciando Fase"+event.getPhaseId());
	}
	@Override
	public PhaseId getPhaseId() {
		//CICLO DE VIDA DO JSF:
		
		//FACES REQUEST >>>
		return PhaseId.RESTORE_VIEW;//Restauração da visão
		//return PhaseId.APPLY_REQUEST_VALUES;//os valores são atribuidos aos "input"
		//return PhaseId.PROCESS_VALIDATIONS;//validação dos "input" pelas classes "validator"
		//return PhaseId.UPDATE_MODEL_VALUES;//instancia objetos que receberão os valores atribuidos aos "input"
		//return PhaseId.INVOKE_APPLICATION;//execução dos métodos managed bean
		//return PhaseId.RENDER_RESPONSE;//Renderizar a resposta
		//<<< FACES RESPONSE
		
		//return PhaseId.ANY_PHASE;//(TODAS)
	}
}