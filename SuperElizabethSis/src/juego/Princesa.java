package juego;

import java.awt.Color;

import entorno.Entorno;

public class Princesa {
     //variables de instancia
	private int x;
	private int y;
	private int alto;
	private int ancho;
	//constructor
	Princesa(int x, int y, int alto, int ancho){
		this.x=x;
		this.y=y;
		this.alto=alto;
		this.ancho=ancho;
	
	
		
	}
	
	public void moverDerecha() {
		this.x= this.x +1;
		
	}
	public void moverIzqierda() {
		this.x= this.x - 1;
		
	}
    
	public void dibujar(Entorno e) {
		e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.GREEN);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
   
}