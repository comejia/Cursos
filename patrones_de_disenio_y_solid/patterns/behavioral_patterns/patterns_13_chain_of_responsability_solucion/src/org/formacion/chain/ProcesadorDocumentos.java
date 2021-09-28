package org.formacion.chain;

import java.util.Arrays;
import java.util.List;

public class ProcesadorDocumentos {

	private List<LectorDocumentos> lectores;
	
    public ProcesadorDocumentos(LectorDocumentos ... lects) {
    	   this.lectores = Arrays.asList(lects);
	}

	public String concatena (List<Documento> documentos)  {
    	
    	    String resultado = "";
    	
    	    for (Documento doc: documentos) {
    	    	    for (LectorDocumentos lector: lectores) {
    	    	    	   if (lector.acepta(doc)) {
    	    	    		   resultado += lector.contenido(doc);
    	    	    	   }
    	    	    }
    	    	    
    	    	    resultado += "\n";
    	    }
    	    
    	    return resultado;
    }

}
