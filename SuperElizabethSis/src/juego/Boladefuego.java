package juego;

import java.awt.Color;

import entorno.Entorno;

public class Boladefuego {
	  //variables de instancia
		private double x;
		private double y;
		private double diametro;
		private double velocidad;
		private double angulo;

		//constructor
		Boladefuego(double x, double y, double diametro){
			this.x=x;
			this.y=y;
			this.diametro=diametro;
			this.velocidad=2;
			this.angulo=0;
		
		
			
		}
		
		public void moverDerecha() {
			this.x= this.x + velocidad;
			
		}
	
		public double getDiametro() {
			return diametro;
		}

		public void dibujar(Entorno e) {
		e.dibujarCirculo(this.x, this.y,this.diametro, Color.RED);;
	
		}


		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}
		
}