package org.formacion.template;

public abstract class InscripcionTorneo {

	protected final Torneo torneo;

	public InscripcionTorneo(Torneo torneo) {
		this.torneo = torneo;
	}
	
	public Torneo getTorneo() {
		return torneo;
	}

	public boolean apunta (Solicitud solicitud) {
		
		if (! puedeApuntarse(solicitud)) {
			return false;
		}
		
		if (torneo.getAceptadas().size() >= maximoPartipantes()) {
			return false;
		}

		torneo.apunta(solicitud);
		
		if (torneo.getAceptadas().size() == maximoPartipantes()) {
			cierraTorneo();
		}

		return true;
	}
	
	protected abstract boolean puedeApuntarse (Solicitud solicitud);
	
	protected abstract int maximoPartipantes();
	
	protected abstract void cierraTorneo();

}
