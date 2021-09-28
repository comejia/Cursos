package org.formacion.mediator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSistema {

	private Radio radio;
	private Telefono telefono;
	private Coche coche;
	
	@Before
	public void init() {
		radio = new Radio();
		telefono = new Telefono();
		coche = new Coche();
		radio.setTelefono(telefono);
		telefono.setRadio(radio);
		coche.setRadio(radio);
		coche.setTelefono(telefono);
	}
	
	@Test
	public void test_encender_apagar_coche() {
		assertFalse(radio.encendida());
		assertFalse(telefono.musicaEncendida());
		
		telefono.enciendeMusica();
		assertTrue(telefono.musicaEncendida());
		
		coche.enciende();
		
		assertTrue(radio.encendida());
		assertFalse(telefono.musicaEncendida());
	
		coche.apaga();
		assertFalse(radio.encendida());
	}

	@Test
	public void test_suena_telefono() {
		radio.enciende();
		assertTrue(radio.encendida());
		
		telefono.recibeLlamada();
		
		assertFalse(radio.encendida());
	}
	
	@Test
	public void test_enciende_radio() {
		
		telefono.enciendeMusica();
		assertTrue(telefono.musicaEncendida());
		
		radio.enciende();
		
		assertFalse(telefono.musicaEncendida());
	}
}
