package org.formacion.template;

public class InscripcionTenis extends InscripcionTorneo {

	private final Polideportivo polideportivo;
	
	public InscripcionTenis(Polideportivo polideportivo) {
		super(new Torneo("torneo tenis"));
		this.polideportivo = polideportivo;
	}

	@Override
	protected boolean puedeApuntarse(Solicitud solicitud) {
		if (solicitud.getEdat() < 10) {
			// menores de 10 no pueden apuntarse
			return false;
		}
		
		return true;
	}

	@Override
	protected void cierraTorneo() {
		
		polideportivo.reserva(torneo, 8);
	}

	@Override
	protected int maximoPartipantes() {
		return 4;
	}
	
	
}
