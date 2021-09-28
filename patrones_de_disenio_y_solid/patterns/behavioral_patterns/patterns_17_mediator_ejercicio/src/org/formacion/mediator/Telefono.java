package org.formacion.mediator;

public class Telefono {

	private boolean musicaOn = false;
	private Radio radio;
	
	public void setRadio(Radio radio) {
		this.radio = radio;
	}

	public void recibeLlamada() {
		radio.apaga();
	}

	public void enciendeMusica() {
		musicaOn = true;
	}
	
	public void apagaMusica() {
		musicaOn = false;
	}
	
	public boolean musicaEncendida() {
		return musicaOn;
	}
}
