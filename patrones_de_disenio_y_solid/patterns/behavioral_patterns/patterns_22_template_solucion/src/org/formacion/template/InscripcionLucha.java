package org.formacion.template;

public class InscripcionLucha extends InscripcionTorneo {

	private final Polideportivo polideportivo;

	public InscripcionLucha(Polideportivo polideportivo) {
		super(new Torneo("torneo lucha"));
		this.polideportivo = polideportivo;
	}

	@Override
	protected boolean puedeApuntarse(Solicitud solicitud) {
		if (solicitud.getEdat() < 15) {
			// menores de 15 no pueden apuntarse
			return false;
		}
		
		if (solicitud.getPeso() < 60) {
			// peso minimo, 60 kilos
			return false;
		}
		return true;
	}

	@Override
	protected void cierraTorneo() {
		polideportivo.reserva(torneo, 4);
	}
	
	@Override
	protected int maximoPartipantes() {
		return 6;
	}


}
