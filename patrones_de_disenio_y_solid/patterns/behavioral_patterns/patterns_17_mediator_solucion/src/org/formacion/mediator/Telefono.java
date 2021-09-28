package org.formacion.mediator;

public class Telefono {

	private boolean musicaOn = false;
	private Coordinador coordinador;
	
	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public void recibeLlamada() {
		coordinador.recibeLlamada();
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
