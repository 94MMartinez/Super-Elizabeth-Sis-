package juego;

import java.awt.Color;
import java.awt.PageAttributes.ColorType;

import entorno.Entorno;
import java.awt.color.*;
public class Princesa {
     //variables de instancia
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad;
	private int salto;
	private int gravedad;
	private int saltoo;
	static boolean piso = true;

	//constructor
	Princesa(int x, int y, int alto, int ancho){
		this.x=x;
		this.y=y;
		this.alto=alto;
		this.ancho=ancho;
		this.velocidad=3;
     	this.salto=-90;
     	this.gravedad=-1;
    }
	
	
	public void caer() {
		this.y=this.y - this.gravedad;
	}
	public void subir() {
		this.y=this.y + this.salto;
	}
	
	public void moverDerecha() {
		this.x= this.x +velocidad;
	}
	public void moverIzquierda() {
		this.x= this.x -velocidad;
	}
	public void dibujar(Entorno e) {
		Color source = new Color(1f,0f,0f,.5f );
		Color transparencia = new Color(source.getRed(), source.getGreen(), source.getBlue(),Color.TRANSLUCENT);
		e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, transparencia);
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getAlto() {
		return alto;
   }  
	public int getAncho() {
		return ancho;
	}
}