package distribuidoraMH.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orden_cc database table.
 * 
 */
@Entity
@Table(name="orden_cc")
@NamedQuery(name="OrdenCc.findAll", query="SELECT o FROM OrdenCc o")
public class OrdenCc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CC")
	private int idCc;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_COMPRA")
	private Date fechaCompra;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="ordenCc")
	private List<Pedido> pedidos;

	public OrdenCc() {
	}

	public int getIdCc() {
		return this.idCc;
	}

	public void setIdCc(int idCc) {
		this.idCc = idCc;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setOrdenCc(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setOrdenCc(null);

		return pedido;
	}

}