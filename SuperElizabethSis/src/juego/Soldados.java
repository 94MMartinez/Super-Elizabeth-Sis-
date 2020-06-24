package juego;

import java.awt.Color;

import entorno.Entorno;

public class Soldados {
	  //variables de instancia
		
	    private int x;
		private int y;
		private int altosoldado;
		private int anchosoldado;
		private int velocidad;
		private int prueba;
		boolean estaVivo = true;
		//constructor
		
		Soldados(int x, int y, int altosoldado, int anchosoldado){
			this.x=x;
			this.y=y;
			this.altosoldado=altosoldado;
			this.anchosoldado=anchosoldado;
		    this.velocidad=1;
            this.prueba = 100;
		}
		
		public boolean Vivo() {
			return estaVivo;
	
		}
		
		
		public void toco() {
			this.x= this.x + this.prueba;
	
		}
		
		
		public void moverIzquierda() {
			this.x= this.x - velocidad;
			
		}
	    
		public int getAltosoldado() {
			return altosoldado;
		}

		public int getAnchosoldado() {
			return anchosoldado;
		}

		public void dibujar(Entorno e) {
			e.dibujarRectangulo(this.x, this.y, this.anchosoldado, this.altosoldado,0, Color.GREEN);
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

}
