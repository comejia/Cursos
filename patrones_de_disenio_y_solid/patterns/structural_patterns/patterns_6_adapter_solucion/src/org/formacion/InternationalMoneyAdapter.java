package org.formacion;

public class InternationalMoneyAdapter implements InternationalMoneyOrganization {

	// implementacion que usaremos para "delegar" las llamadas
	// Este objeto es el que realmente realiza el trabajo
	private BancoNostrum impl;

	// Un adapter sin la implementacion asociada no puede funcionar
	public InternationalMoneyAdapter(BancoNostrum impl) {
		this.impl = impl;
	}

	// metodos que traducen de API InternationalMoneyOrganization a API BancoNostrum
	
	@Override
	public void transfer(int cantidad, String cliente) {
		impl.movimiento(cliente, cantidad);
	}

	@Override
	public int state(String cliente) {
		Integer resultado = impl.estado(cliente);
		
		// en la API InternationalMoneyOrganization el metode devuelve 0 si
		// no hay datos de el cliente. En el API BancoNostrum devolvia null,
		// asi que es necesario cambiar el valor devuelto de BancoNostrum si es null.
		if (resultado == null) {
			return 0;
		}
		// si no es null, nos sirve el mismo resultado
		return resultado;
	}
	
	
}
