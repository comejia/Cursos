package org.formacion.chain;

public interface LectorDocumentos {

	// El metodo acepta permite que sea el propio LectorDocumentos el que indique si 
	// puede procesar un tipo de documento o no, liberando de esta responsabilidad al
	// ProcesadorDocumentos
	boolean acepta(Documento documento);
	
	String contenido(Documento documento);

}
