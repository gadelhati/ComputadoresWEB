package br.eti.gadelha.web.controle.controlador.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.eti.gadelha.ejb.controle.modelo.oque.Ferramenta;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 24/12/2015
 * @see www.gadelha.eti.br
 **/

@FacesConverter(forClass = Ferramenta.class)
public class ConversorFerramenta implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if(value != null && !value.isEmpty()) {
			return (Ferramenta) uiComponent.getAttributes().get(value);
		}
		return null;
	}
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if(value instanceof Ferramenta) {
			Ferramenta ferramenta = (Ferramenta) value;
			if (ferramenta != null && ferramenta instanceof Ferramenta) {// && recurso.getId() != null
				uiComponent.getAttributes().put( Long.toString(ferramenta.getId()), ferramenta);
                return Long.toString(ferramenta.getId());
			}
		}
		return "";
	}
}