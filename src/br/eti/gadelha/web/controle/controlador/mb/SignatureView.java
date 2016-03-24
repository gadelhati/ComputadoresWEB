package br.eti.gadelha.web.controle.controlador.mb;

import javax.faces.bean.ManagedBean;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 27/08/2015
 * @see www.gadelha.eti.br
 **/

@ManagedBean(name="signatureView")
public class SignatureView {
     
    private String value;
 
    public String getValue() {
        return value;
    }
 
    public void setValue(String value) {
        this.value = value;
    }
}