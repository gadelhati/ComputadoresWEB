package br.eti.gadelha.web.controle.service.inicializador;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.eti.gadelha.web.controle.service.WSPessoa;

/**
 * @autor Marcelo Ribeiro Gadelha
 * @since 08/10/2015
 * @see www.gadelha.eti.br
 * */

@ApplicationPath("/rs")
public class Inicializador extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	
	public Inicializador() {
		singletons.add(new WSPessoa());
	}
	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}