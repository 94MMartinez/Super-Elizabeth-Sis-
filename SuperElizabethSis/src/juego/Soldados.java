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
			Color source = new Color(1f,0f,0f,.5f );
			Color transparencia = new Color(source.getRed(), source.getGreen(), source.getBlue(),Color.TRANSLUCENT);
			e.dibujarRectangulo(this.x, this.y, this.anchosoldado, this.altosoldado, 0, transparencia);
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

}
