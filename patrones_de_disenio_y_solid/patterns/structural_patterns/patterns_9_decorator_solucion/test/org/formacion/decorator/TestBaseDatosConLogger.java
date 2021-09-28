package org.formacion.decorator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestBaseDatosConLogger {

	private Logger logger = new Logger();
	private BaseDatos sinLogger = new BaseDatosMemoria();
	
	private BaseDatos bbdd;
	
	@Before
	public void init() {
		
		// construimos un decorator a la base de datos que usara el mecanismo de logging logger.
		// Estos son los dos parametros necesarios para la construccion del decorator.
		// Fijaos como el tipo devuelto se asigna a una variable del tipo BaseDatos: el cliente
		// no necesita saber (una vez hecha la creación) que está trabajando con un decorator.
		bbdd = new LoggerDecorator(logger, sinLogger);
	}
	
	
	// de este test no hay que modificar nada
	@Test
	public void test_logger_decorator() {
		
		assertFalse("logger no esta vacio",logger.obtener().contains("inserta entrada"));
		bbdd.inserta("entrada");
		
		assertTrue("bbdd no ha recibido entrada", sinLogger.registros().contains("entrada"));
		assertTrue("no se ha registrado la entrada", logger.obtener().contains("inserta entrada"));

		// lectura con el adapter con logger
		List<String> registros = bbdd.registros();
		
		assertTrue("el adapter no tiene la nueva entrada", registros.contains("entrada"));
	
		assertTrue("no se ha registrado la lectura", logger.obtener().contains("lectura"));
	}

	
}
