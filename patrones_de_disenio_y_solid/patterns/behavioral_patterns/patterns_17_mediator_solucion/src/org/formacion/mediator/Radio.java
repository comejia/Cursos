package org.formacion.mediator;

public class Radio {

	private boolean encendida = false;
	private Coordinador coordinador;
	
	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public void enciende() {
		encendida = true; 
		coordinador.enciendeRadio();
	}
	
	public void apaga() {
		encendida = false; 
		coordinador.apagaRadio();
	}
	
	public boolean encendida() {
		return encendida;
	}
}
