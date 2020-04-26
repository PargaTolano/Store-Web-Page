package Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="imagen")
public class Imagen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private byte[] bytes;
	
	@JsonIgnoreProperties("imagenes")
	@JsonBackReference
	@ManyToOne
	Producto producto;

	public int getId() {
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProductos(Producto producto) {
		this.producto = producto;
	}
	
	
}