package Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="video")
public class Video {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private byte[] bytes;
	
	@JsonIgnoreProperties("videos")
	@JsonBackReference
	@ManyToOne
	Producto producto;

	public int getId() {
		return id;
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

