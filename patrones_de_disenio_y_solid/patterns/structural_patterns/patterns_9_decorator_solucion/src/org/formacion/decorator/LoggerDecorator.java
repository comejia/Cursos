package org.formacion.decorator;

import java.util.List;

/**
 * Decorator que ofrece la funcionalidad de BaseDatos insertando
 * notificaciones a un sistema de logs
 */
public class LoggerDecorator implements BaseDatos {

	private final Logger logger; // para registrar los logs
	private final BaseDatos impl; // implementacion real del sistema de base de datos
	
	public LoggerDecorator(Logger logger, BaseDatos impl) {
		this.logger = logger;
		this.impl = impl;
	}

	// los metodos del decorator insertaran el log correspondiente y delegaran
	// la invocacion a la implementacion pasada en el constructor
	
	@Override
	public void inserta(String registro) {
		logger.add("inserta " + registro);
		impl.inserta(registro);
	}

	@Override
	public List<String> registros() {
		logger.add("lectura");
		return impl.registros();
	}

	

}
