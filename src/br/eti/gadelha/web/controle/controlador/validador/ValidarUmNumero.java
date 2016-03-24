package br.eti.gadelha.web.controle.controlador.validador;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@FacesValidator(value="validarUmNumero")
public class ValidarUmNumero implements Validator {

	private static final String PATTERN = "[0-9]";
	private Pattern pattern;
	private Matcher matcher;
	
	@Size(min=2,max=5)
	private String name;
	@Min(10) @Max(20)
	private Integer age;
	@DecimalMax(value= "99.9", message = "Shold not exceed 99.9")
	private Double amount;
	@Digits(integer=3,fraction=2)
	private Double amount2;
	@AssertTrue
	private boolean checked;
	@Past
	private Date pastDate;
	@Future
	private Date futureDate;
	//@Pattern(regexp="^[-+]?\\d+$")
	//private String regex;
	
	/*
	@Inject
	@Named(value="validationMessages")
	ResourceBundle validationBundle;
	*/
	
	//<h:inputText id="valor" value="mbBean.nome" validator="validador" />//@FacesValidator
	//<h:inputText id="valor" value="mbBean.nome" validator="mbBean.validador" />

	
	public ValidarUmNumero(){
		  pattern = Pattern.compile(PATTERN);
	}
	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()) {
			FacesMessage facesMessage = new FacesMessage("Número Inválido:", "o número deve possuir um algarismos");
            throw new ValidatorException(facesMessage);
		}
	}
}