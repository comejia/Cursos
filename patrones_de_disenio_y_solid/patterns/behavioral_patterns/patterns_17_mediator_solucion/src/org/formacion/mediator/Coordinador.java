package org.formacion.mediator;

public class Coordinador {

	private Telefono telefono;
	private Coche coche;
	private Radio radio;
	
	public Coordinador(Telefono telefono, Coche coche, Radio radio) {
		this.telefono = telefono;
		this.coche = coche;
		this.radio = radio;
		this.telefono.setCoordinador(this);
		this.coche.setCoordinador(this);
		this.radio.setCoordinador(this);
	}

	public void enciendeCoche() {
		radio.enciende();
		telefono.apagaMusica();
	}

	public void apagaCoche() {
		radio.apaga();
	}

	public void enciendeRadio() {
		telefono.apagaMusica();
	}

	public void apagaRadio() {
		// nada
	}

	public void recibeLlamada() {
		radio.apaga();
	}

}
