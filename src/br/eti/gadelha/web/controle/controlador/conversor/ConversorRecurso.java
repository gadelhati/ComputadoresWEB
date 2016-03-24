package br.eti.gadelha.web.controle.controlador.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.eti.gadelha.ejb.controle.modelo.oque.Recurso;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@FacesConverter(forClass = Recurso.class)
public class ConversorRecurso implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if(value != null && !value.isEmpty()) {
			return (Recurso) uiComponent.getAttributes().get(value);
		}
		return null;
	}
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if(value instanceof Recurso) {
			Recurso recurso = (Recurso) value;
			if (recurso != null && recurso instanceof Recurso) {// && recurso.getId() != null
                uiComponent.getAttributes().put( Long.toString(recurso.getId()), recurso);
                return Long.toString(recurso.getId());
                //recurso.getId().toString()
            }
		}
		return "";
	}
}