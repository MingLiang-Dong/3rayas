package juego;

public class ficha {
	private String nombre, color;
	
	public ficha(String nombre, String color) {
		this.nombre=nombre;
		this.color=color;
	}
	public ficha() {
		this.nombre="";
		this.color=" ";
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getColor() {
		return "["+ color.substring(0,1).toUpperCase()+"]";
	}
}
