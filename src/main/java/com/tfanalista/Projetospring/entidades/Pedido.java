package com.tfanalista.Projetospring.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tfanalista.Projetospring.entidades.enuns.StatusPedidos;

@Entity
public class Pedido implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'z'" , timezone = "GMT")
	private Instant moment;
	
	private Integer status;
	
	//associação JPA para chave estrangeira com a tabela usuário
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;

	// coleção itens 
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItensPedido> itens = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)//mapeamento um para um com o mesmo ID
	private Pagamento pagamento;
	
	public Pedido() {
	
	}
	public Pedido(Long id, Instant moment, Usuario cliente, StatusPedidos status) {
		super();
		this.id = id;
		this.moment = moment;
		this.cliente = cliente;
		setStatus(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	

	public StatusPedidos getStatus() {
		return StatusPedidos.valorOF(status);
	}
	public void setStatus(StatusPedidos status) {
		if(status != null) {
		this.status = status.getCode();
		}
	}
	
	@JsonIgnore
	public Set<ItensPedido> getItens(){
		return itens;
	}
	
	
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((moment == null) ? 0 : moment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (moment == null) {
			if (other.moment != null)
				return false;
		} else if (!moment.equals(other.moment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", moment=" + moment + ", cliente=" + cliente + "]";
	}
	
	
	
}
