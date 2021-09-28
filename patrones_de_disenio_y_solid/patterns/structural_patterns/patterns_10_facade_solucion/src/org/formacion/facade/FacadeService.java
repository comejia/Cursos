package org.formacion.facade;

public class FacadeService {

	private ServicioConfiguracion configuracion = new ServicioConfiguracion();
	private ServicioFidelizacion fidelizacion = new ServicioFidelizacion();
	private ServicioComunicacion comunicacion = new ServicioComunicacion();

	public void inscripcionExpress (String cliente, String email) {
		
		fidelizacion.crearTarjeta(cliente, ServicioFidelizacion.Tipo.BASICA);
		configuracion.addEmail(cliente, email);
		PreferenciasComunicacion preferencias = new PreferenciasComunicacion(false, true, true);
		comunicacion.setPreferencias(cliente, preferencias);
	}
	

}
