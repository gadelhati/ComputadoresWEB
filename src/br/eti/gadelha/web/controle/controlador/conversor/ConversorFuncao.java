package br.eti.gadelha.web.controle.controlador.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.eti.gadelha.ejb.controle.modelo.como.Funcao;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 04/03/2016
 * @see www.gadelha.eti.br
 **/

@FacesConverter(forClass = Funcao.class)
public class ConversorFuncao implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if(value != null && !value.isEmpty()) {
			return (Funcao) uiComponent.getAttributes().get(value);
		}
		return null;
	}
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if(value instanceof Funcao) {
			Funcao funcao = (Funcao) value;
			if (funcao != null && funcao instanceof Funcao) {// && recurso.getId() != null
				uiComponent.getAttributes().put( Long.toString(funcao.getId()), funcao);
                return Long.toString(funcao.getId());
			}
		}
		return "";
	}
}