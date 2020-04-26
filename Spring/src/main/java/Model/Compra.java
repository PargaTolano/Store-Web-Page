package Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.Date;

@Entity
@Table(name="compra")
public class Compra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Date  fecha;
	
	private String lugar_entrega;
	
	private float  total;
	
	@JsonIgnoreProperties("compra")
	@OneToMany
	private Set<ProductoComprado> productosComprados;
	
	@JsonIgnoreProperties("compras")
	@ManyToOne
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

	public String getLugar_entrega() {
		return lugar_entrega;
	}

	public void setLugar_entrega(String lugar_entrega) {
		this.lugar_entrega = lugar_entrega;
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
