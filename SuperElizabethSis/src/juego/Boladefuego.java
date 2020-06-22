package juego;

import java.awt.Color;

import entorno.Entorno;

public class Boladefuego {
	  //variables de instancia
		private double x;
		private double y;
		private double diametro;

		//constructor
		Boladefuego(double x, double y, double diametro){
			this.x=x;
			this.y=y;
			this.diametro=diametro;

		
		
			
		}
		
		public void moverDerecha() {
			this.x= this.x +1;
			
		}
	    
		public void dibujar(Entorno e) {
			e.dibujarCirculo(this.x, this.y, this.diametro, Color.red);
		}

		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}

}
