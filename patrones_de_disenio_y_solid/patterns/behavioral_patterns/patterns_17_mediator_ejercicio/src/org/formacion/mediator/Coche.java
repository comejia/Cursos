package org.formacion.mediator;

public class Coche {

	private Telefono telefono;
	private Radio radio;
	
	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public void setRadio(Radio radio) {
		this.radio = radio;
	}

	public void enciende() {
		radio.enciende();
		telefono.apagaMusica();
	}
	
	public void apaga() {
		radio.apaga();
	}
	
}
