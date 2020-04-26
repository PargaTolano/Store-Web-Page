package Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="CarritoDeCompra")
public class CarritoDeCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnoreProperties("carrito")
	@OneToMany
	private Set<ProductoComprado> productosComprados;
	
	@JsonIgnoreProperties("carrito")
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
