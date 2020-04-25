package Model;

import javax.persistence.*;

@Entity
@Table(name="video")
public class Video {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private byte[] bytes;
	
	@ManyToOne
	Producto productos;

	public int getId() {
		return id;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public Producto getProductos() {
		return productos;
	}

	public void setProductos(Producto productos) {
		this.productos = productos;
	}
	
	
}

