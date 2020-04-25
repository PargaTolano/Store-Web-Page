package Model;

import javax.persistence.*;


import java.util.Collection;
import java.util.List;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String descripcion;
	
	private int unidades;
	
	private float precio;
	
	private int descuento;
	
	@OneToMany
	List<Imagen> imagenes;
	
	@OneToMany
	List<Video> videos;
	
	@OneToMany
	List<ProductoComprado> productosComprados;

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public Collection<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Collection<ProductoComprado> getProductosComprados() {
		return productosComprados;
	}

	public void setProductosComprados(List<ProductoComprado> productosComprados) {
		this.productosComprados = productosComprados;
	}
	
	
}
