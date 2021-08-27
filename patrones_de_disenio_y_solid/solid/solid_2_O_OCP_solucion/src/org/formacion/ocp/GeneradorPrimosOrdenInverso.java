package org.formacion.ocp;

import java.util.Comparator;

/**
 * La nueva clase adapta el comportamiento de GeneradorPrimos sin necesidad de modificar la clase.
 * 
 * Usa el punto de extension habilitado: getOrdenacion
 */
public class GeneradorPrimosOrdenInverso extends GeneradorPrimos {

	protected Comparator<Integer> getOrdenacion () {
		return ( a, b ) ->  a > b? -1: 1;
	}

	
}
