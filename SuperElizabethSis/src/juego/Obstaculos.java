package juego;

import java.awt.Color;

import entorno.Entorno;

public class Obstaculos {
	  //variables de instancia
		private int x;
		private int y;
		private int alto;
		private int ancho;
		private int velocidad;
		
	
		//constructor
		Obstaculos(int x, int y, int alto, int ancho){
			this.x=x;
			this.y=y;
			this.alto=alto;
			this.ancho=ancho;
			this.velocidad=2;
		}
		
		
		public void moverIzquierda() {
			this.x= this.x - velocidad;
		}
	    
		public void dibujar(Entorno e) {
			e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.GRAY);
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
