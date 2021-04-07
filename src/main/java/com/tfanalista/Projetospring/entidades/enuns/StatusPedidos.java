package com.tfanalista.Projetospring.entidades.enuns;

public enum StatusPedidos {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int code;
	private StatusPedidos(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static StatusPedidos valorOF(int code) {
		for(StatusPedidos valor : StatusPedidos.values()) {
			if (valor.getCode() ==code ) {
				return valor; 
			}
		}
		throw new IllegalArgumentException("Code invalido");
	}
	
}
