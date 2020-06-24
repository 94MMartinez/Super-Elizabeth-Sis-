package juego;


import java.awt.Color;
import java.util.LinkedList;
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
	private Piso piso;
	private int vidas;
	private int puntos;
    private boolean juegoFin = false;
	private LinkedList <Boladefuego> listaBol;

	
	

	
	// Variables y métodos propios de cada grupo
	// ...
	{
	this.prin = new Princesa(150,500,60,30);
	this.obs= new Obstaculos(825,500,20,30);
	this.sold= new Soldados(750,500,50,30);
	this.bola= new Boladefuego(175,500,20);
	this.piso=new Piso(400,579,100,800);
	}
	Juego()
	{	vidas = 3;
	   puntos= 0;
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 13", 800, 600);



		this.prin = new Princesa(150,500,60,30);
		this.obs= new Obstaculos(825,500,20,30);
		this.sold= new Soldados(750,502,53,28);
		this.bola= new Boladefuego(prin.getX(),prin.getY(),20);
		listaBol = new LinkedList <Boladefuego>();

	

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
		piso.dibujar(this.entorno);
		
		entorno.escribirTexto("VIDAS: "+ vidas, 700, 50);		
		entorno.escribirTexto("Puntaje: "+ puntos, 600, 50);
		prin.dibujar(this.entorno);
		obs.dibujar(this.entorno);
		obs.moverIzquierda();
		sold.dibujar(this.entorno);
		sold.moverIzquierda();
		
		if (this.prin.getY()<498 && this.prin.getY()>350) {
			this.prin.caer();
		}
		boolean saltar=true;
		
		if (saltar && this.entorno.sePresiono(this.entorno.TECLA_ARRIBA) && this.prin.getY()>=440) {
		      this.prin.subir();
		      saltar=false;
		      
		   }

		
	  if(this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) && prin.getX()<this.entorno.ancho()/2) {
			prin.moverDerecha();
		}
		if(this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)&& prin.getX()>20) {
			prin.moverIzquierda();

		}	
		if(this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)&& prin.getX()<this.entorno.ancho()) {

		}
		if(this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)) {
			listaBol.add(new Boladefuego(prin.getX(),prin.getY(),20));
		}
		
		for(Boladefuego bola:listaBol) {
			bola.dibujar(this.entorno);
			bola.moverDerecha();
		}
		for(Boladefuego bola:listaBol) {
			if ((bola.getX()== sold.getX())|| bola.getX()==800) {
				listaBol.remove(bola);
			}
			

		}	
	     

		
		
		obs.dibujar(this.entorno);
		obs.moverIzquierda();
		sold.dibujar(this.entorno);
		sold.moverIzquierda() ;

	      
	      if(colision()) {
				this.sold.toco();
				vidas = vidas -1;
				System.out.println(vidas);
				if(vidas==0) {
				 entorno.escribirTexto("F", 325, 200);
 }
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
