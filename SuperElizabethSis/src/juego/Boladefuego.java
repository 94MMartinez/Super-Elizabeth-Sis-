package juego;

import java.awt.Color;

import entorno.Entorno;

public class Boladefuego {
	  //variables de instancia
		private double x;
		private double y;
		private double velocidad;
		private double angulo;
		private double alto;
		private double ancho;

		//constructor
		Boladefuego(double x, double y, double ancho, double alto){
			this.x=x;
			this.y=y;
			this.alto=alto;
			this.ancho=ancho;
			this.velocidad=5;
			this.angulo=0;
		
		
			
		}
		
		public void moverDerecha() {
			this.x= this.x + velocidad;
			
		}

		public void dibujar(Entorno e) {
		e.dibujarRectangulo(this.x, this.y,this.ancho,this.alto, this.angulo, Color.RED);;
	
		}
		public double getAngulo() {
			return angulo;
		}

		public double getAlto() {
			return alto;
		}

		public double getAncho() {
			return ancho;
		}

		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}
		
}