package distribuidoraMH.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedidos database table.
 * 
 */
@Entity
@Table(name="pedidos")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PEDIDO")
	private int idPedido;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_PEDIDO")
	private Date fechaPedido;

	@Column(name="NUM_PEDIDO")
	private int numPedido;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to OrdenCc
	@ManyToOne
	@JoinColumn(name="ID_CC")
	private OrdenCc ordenCc;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="pedido")
	private List<Producto> productos;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public int getNumPedido() {
		return this.numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public OrdenCc getOrdenCc() {
		return this.ordenCc;
	}

	public void setOrdenCc(OrdenCc ordenCc) {
		this.ordenCc = ordenCc;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setPedido(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setPedido(null);

		return producto;
	}

}