package org.formacion.bridge;

/**
 * Bridge entre las dos interfaces: VendedorOnlineEmpresas (y su supertipo VendedorOnline) y TiendaImpl
 */
public class VendedorEmpresasImpl implements VendedorOnlineEmpresas {
	
	private TiendaImpl impl;

	
	public VendedorEmpresasImpl(TiendaImpl impl) {
		this.impl = impl;
	}

	/**
	 * Caso sencillo donde el metodo ya existe en la API de implementacion
	 */
	@Override
	public String descripcionProducto(String producto) {
		return impl.descripcionProducto(producto);
	}
	
	
	/**
	 * Caso "complejo" donde se tiene que adaptar a la diferencia entre las dos APIs
	 * 
	 * El hecho de que la adaptacion se haga en esta clase, libera a todas las implementaciones
	 * de TiendaImpl de tener que hacer esta misma adaptacion.
	 */
	@Override
	public void compraProducto(String nombre, int cantidadPorCaja, int cajas) {
		
		for (int i = 0; i < cajas; i++) {
			impl.compraCaja(nombre, cantidadPorCaja);
		}
		
	}

}
