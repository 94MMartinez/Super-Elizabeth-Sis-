package juego;

import java.awt.Color;

import entorno.Entorno;

public class Piso {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	
	Piso(int x, int y, int alto, int ancho){
		this.x=x;
		this.y=y;
		this.alto=alto;
		this.ancho=ancho;
    }
	public void dibujar(Entorno e) {
		e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.YELLOW);
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
