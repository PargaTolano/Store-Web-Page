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
	
	@OneToMany
	private Set<ProductoComprado> productosComprados;
	
	@OneToOne
	private Usuario usuario;

	public int getId() {
		return id;
	}
	public Set<ProductoComprado> getProductosComprados() {
		return productosComprados;
	}

	public void setProductosComprados(Set<ProductoComprado> productosComprados) {
		this.productosComprados = productosComprados;
	}
}
