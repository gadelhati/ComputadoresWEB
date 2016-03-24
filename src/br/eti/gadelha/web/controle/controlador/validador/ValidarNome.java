package br.eti.gadelha.web.controle.controlador.validador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="validarNome")
public class ValidarNome implements Validator {

	private static final String PATTERN = "[A-Za-z]{1,45}";
	private Pattern pattern;
	private Matcher matcher;
	
	public ValidarNome(){
		  pattern = Pattern.compile(PATTERN);
	}
	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()) {
			FacesMessage facesMessage = new FacesMessage("Nome Inválido:", "de uma a 45 letras");
            throw new ValidatorException(facesMessage);
		}
	}
}