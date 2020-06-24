package juego;


import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Princesa prin;
	private Obstaculos obs;
	private Soldados sold;
	private Boladefuego bola;
	private int vidas;
	private int puntos;
    private boolean juegoFin = false;

	
	// Variables y métodos propios de cada grupo
	// ...
	{
	this.prin = new Princesa(150,500,60,30);
	this.obs= new Obstaculos(825,500,20,30);
	this.sold= new Soldados(750,500,60,30);
	this.bola= new Boladefuego(175,500,20);
	}
	Juego()
	{	vidas = 3;
	   puntos= 0;
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 13", 800, 600);

	

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		
		entorno.escribirTexto("VIDAS: "+ vidas, 700, 50);		
		entorno.escribirTexto("Puntaje: "+ puntos, 600, 50);
		prin.dibujar(this.entorno);
		obs.dibujar(this.entorno);
		obs.moverIzquierda();
		sold.dibujar(this.entorno);
		sold.moverIzquierda();
		
	  if(this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) && prin.getX()<this.entorno.ancho()/2) {
			prin.moverDerecha();
		}
		if(this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)&& prin.getX()>20) {
			prin.moverIzquierda();
		}	
		if(this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)&& prin.getX()<this.entorno.ancho()) {
			bola.dibujar(this.entorno);
			bola.moverDerecha();
			
		}	
	      if(this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)) {
	     	prin.saltar();
	    }
		
       if(this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)) {
   	    prin.gravedad();
     }
	      
	      if(colision()) {
				this.sold.toco();
				vidas = vidas -1;
				System.out.println(vidas);
				if(vidas==0)
				 entorno.escribirTexto("F", 325, 200);
				 		   

    }
}

    public boolean colision() {
	boolean seTocanY = this.sold.getY()-this.sold.getAltosoldado()/2  < this.prin.getY() + this.prin.getAlto()/2 ;
	boolean seTocanX = this.sold.getX()>this.prin.getX()-(this.prin.getAncho()) &&	this.sold.getX() < this.prin.getX()+(this.prin.getAncho());
	if(seTocanY && seTocanX) {
		return true;
	}
	return false;


	}

	  @SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
