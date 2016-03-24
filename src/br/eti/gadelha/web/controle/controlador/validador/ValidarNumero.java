package br.eti.gadelha.web.controle.controlador.validador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="validarNumero")
public class ValidarNumero implements Validator {

	private static final String PATTERN = "[0-9]{2}";
	private Pattern pattern;
	private Matcher matcher;
	
	public ValidarNumero(){
		  pattern = Pattern.compile(PATTERN);
	}
	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()) {
			FacesMessage facesMessage = new FacesMessage(
					"Número Inválido:", "o número deve ser positivo e possuir dois algarismos");
            throw new ValidatorException(facesMessage);
		}
	}
}