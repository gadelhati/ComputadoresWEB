package br.eti.gadelha.web.controle.controlador.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.eti.gadelha.ejb.controle.modelo.oque.Grupo;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 06/03/2016
 * @see www.gadelha.eti.br
 **/

@FacesConverter(forClass = Grupo.class)
public class ConversorGrupo implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if(value != null && !value.isEmpty()) {
			return (Grupo) uiComponent.getAttributes().get(value);
		}
		return null;
	}
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if(value instanceof Grupo) {
			Grupo grupo = (Grupo) value;
			if (grupo != null && grupo instanceof Grupo) {// && recurso.getId() != null
				uiComponent.getAttributes().put( Long.toString(grupo.getId()), grupo);
                return Long.toString(grupo.getId());
			}
		}
		return "";
	}
}