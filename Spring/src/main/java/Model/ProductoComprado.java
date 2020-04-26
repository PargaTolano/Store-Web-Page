package Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ProductoComprado")
public class ProductoComprado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int unidades;
	
	private float costo;
	
	@JsonIgnoreProperties("productosComprados")
	@JsonBackReference
	@ManyToOne
	Producto producto;
	
	@JsonIgnoreProperties("productosComprados")
	@ManyToOne
	Compra compra;
	
	@JsonIgnoreProperties("productosComprados")
	@ManyToOne
	CarritoDeCompra carrito;

	public int getId() {
		return id;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	
}