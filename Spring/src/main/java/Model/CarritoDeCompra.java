package Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="CarritoDeCompra")
public class CarritoDeCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Date  fecha;
	
	private float  total;
	
	@OneToMany
	private Set<ProductoComprado> productosComprados;
	
	@OneToOne
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Set<ProductoComprado> getProductosComprados() {
		return productosComprados;
	}

	public void setProductosComprados(Set<ProductoComprado> productosComprados) {
		this.productosComprados = productosComprados;
	}
}
