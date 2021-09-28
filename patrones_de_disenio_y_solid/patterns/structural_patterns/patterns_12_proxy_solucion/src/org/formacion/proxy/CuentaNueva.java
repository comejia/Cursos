package org.formacion.proxy;

public class CuentaNueva implements Cuenta {

	private Cuenta original;
	
	public CuentaNueva(String cliente) {
		original = new CuentaNormal(cliente);
	}

	public String getCliente() {
		return original.getCliente();
	}

	public int getCantidad() {
		return original.getCantidad();
	}

	public void movimiento (int importe) {
		if (original.getCantidad() + importe >= 0) {
			original.movimiento(importe);
		}
	}

}
