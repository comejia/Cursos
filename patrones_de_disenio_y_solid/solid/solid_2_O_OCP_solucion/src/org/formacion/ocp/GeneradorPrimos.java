package org.formacion.ocp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GeneradorPrimos {

	
	public List<Integer> primos (int limit) {
		
		List<Integer> primos = new ArrayList<>();
		for (int i = 2; i < limit; i++) {
			if (esPrimo(i)) {
				primos.add(i);
			}
		}
		
		Collections.sort(primos, getOrdenacion());
		return primos;

	}
	
	private boolean esPrimo (int candidato) {
		for (int i = 2; i < candidato; i++) {
			if (candidato % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Punto de "extension" de nuestra clase: permite que las subclases adapten (open) la forma
	 * de ordenar los resultados sin necesidad de modificar esta clase (closed)
	 * 
	 * @return comparador que se usara para ordenar el resultado del metodo primos(int)
	 */
	protected Comparator<Integer> getOrdenacion () {
		return ( a, b ) ->  a > b? 1: -1;
	}
}
