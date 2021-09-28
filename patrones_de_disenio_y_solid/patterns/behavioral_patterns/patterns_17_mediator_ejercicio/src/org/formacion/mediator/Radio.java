package org.formacion.mediator;

public class Radio {

	private boolean encendida = false;
	private Telefono telefono;
	
	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public void enciende() {
		encendida = true; 
		telefono.apagaMusica();
	}
	
	public void apaga() {
		encendida = false; 
	}
	
	public boolean encendida() {
		return encendida;
	}
}
