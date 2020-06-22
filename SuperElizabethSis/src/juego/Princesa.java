package juego;

import java.awt.Color;

import entorno.Entorno;

public class Princesa {
     //variables de instancia
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad;
	//constructor
	Princesa(int x, int y, int alto, int ancho){
		this.x=x;
		this.y=y;
		this.alto=alto;
		this.ancho=ancho;
		this.velocidad=3;
	
	
		
	}
	
	public void moverDerecha() {
		this.x= this.x +velocidad;
		
	}
	public void moverIzquierda() {
		this.x= this.x -velocidad;
		
	}
    
	public void dibujar(Entorno e) {
		e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.PINK);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
   
}