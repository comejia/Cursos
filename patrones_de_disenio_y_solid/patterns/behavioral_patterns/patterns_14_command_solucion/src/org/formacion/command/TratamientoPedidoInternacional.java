package org.formacion.command;

// nuevo Command esta vez para tratar los pedidos internacionales
public class TratamientoPedidoInternacional implements TratamientoPedido {

	private PedidoInternacional pedido;
	
	public TratamientoPedidoInternacional(PedidoInternacional pedido) {
		this.pedido = pedido;
	}


	// en nuestro caso la implementacion es trivial, pero en un caso mas realista sacariamos ventaja
	// de tener aislado en este metodo todo el tratamiento requirido por el pedido asociado.
	@Override
	public boolean tratar() {
		return !"Mordor".equals(pedido.getDestino());
	}

}
