package juego;


import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Image;
import entorno.Entorno;
import entorno.InterfaceJuego;
import entorno.Herramientas;

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
	private LinkedList <Boladefuego> listaBol;
	private LinkedList <Obstaculos> listaObs;
	private LinkedList <Soldados> listaSol;
	private Image fondo;
	private Image princesa;
	private Image fuego;
	private Image gameOver;
    private boolean juegofin;
    private int cont;

	
	

	
	// Variables y métodos propios de cada grupo
	// ...
	{
	this.prin = new Princesa(150,500,60,30);
	this.obs= new Obstaculos(825,500,20,30);
	this.sold= new Soldados(750,500,50,20);
	this.bola= new Boladefuego(150,500,20,20);
	this.piso=new Piso(400,579,100,800);
	}
	Juego()
	{	
		
		vidas = 3;
	    puntos= 0;
	    cont=0;
		// Inicializa el objeto entorno
		
	    this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 13", 800, 600);
		this.prin = new Princesa(150,500,60,30);
		this.obs= new Obstaculos(825,520,20,30);
		this.sold= new Soldados(800,520,53,20);
		this.bola= new Boladefuego(bola.getX(),bola.getY(),bola.getAncho(),bola.getAlto());
		listaBol = new LinkedList <Boladefuego>();
		listaSol=new LinkedList <Soldados>();
		listaObs= new LinkedList <Obstaculos>();
		gameOver = Herramientas.cargarImagen("Gameover.png");
		princesa = Herramientas.cargarImagen("prince.png");
		fuego = Herramientas.cargarImagen("Fuego.png");
	

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
		// Procesamiento de un instante de tiempoz
		// ...
       if(!juegofin());{
		fondo = Herramientas.cargarImagen("Fondo.png");
		piso.dibujar(this.entorno);
		entorno.dibujarImagen(fondo, 200, 200, 0);
		entorno.dibujarImagen(princesa, prin.getX(), prin.getY(), 0, 2);		
		entorno.escribirTexto("VIDAS: "+ vidas, 700, 50);		
		entorno.escribirTexto("Puntaje: "+ puntos, 600, 50);
		prin.dibujar(this.entorno);
		cont++;
				
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
			if(this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)) {
				listaBol.add(new Boladefuego(prin.getX(),prin.getY(),bola.getAncho(),bola.getAlto()));
			}
			
			for(Boladefuego bola:listaBol) {
				bola.dibujar(entorno);
				entorno.dibujarImagen(fuego, bola.getX(), bola.getY(), 0,1);
				bola.moverDerecha();
			}
			 if (cont%275==0 ) {
	           	 listaSol.add(new Soldados(sold.getX(),sold.getY(),53,28));
	           	 
	            }
			for(Soldados sold:listaSol) {
				
			for(Boladefuego bola:listaBol) {
				if (sold.getX()-sold.getAnchosoldado()/2 < bola.getX()+bola.getAncho()/2 && sold.getX()-sold.getAnchosoldado()/2 > bola.getX()-bola.getAncho()/2) {
					listaBol.remove(bola);
					listaSol.remove(sold);
					puntos = puntos+5;
					
				}
		    }
			}
				}
	      	   
	   		 for(Soldados sold:listaSol) {
	   			 sold.dibujar(this.entorno);
	   			 sold.moverIzquierda();
	   		 }
	   		for(Soldados sold:listaSol) {
	   			 if(sold.getY()-sold.getAltosoldado()/2< this.prin.getY()+ this.prin.getAlto()/2 && sold.getX()>this.prin.getX()-(this.prin.getAncho()) && sold.getX() < this.prin.getX()+(this.prin.getAncho())||sold.getX()==0) {
	   				 listaSol.remove(sold);
	   				 
	   				 vidas = vidas -1;
	   				}
	   		 }
	   		 
	   		 
	   		 
	   			 if (cont%250==0) {
	   	        	 listaObs.add(new Obstaculos(obs.getX(),obs.getY(),20,30));
	   	        	 
	   	         }
	   			 for(Obstaculos obs:listaObs) {
	   				 obs.dibujar(this.entorno);
	   				 obs.moverIzquierda();
	   			 }
                 for(Obstaculos obs:listaObs) {
	   				 if(obs.getY()-obs.getAlto()/2< this.prin.getY()+ this.prin.getAlto()/2 && obs.getX()>this.prin.getX()-(this.prin.getAncho()) && obs.getX() < this.prin.getX()+(this.prin.getAncho())||obs.getX()==0) {
	   					 listaObs.remove(obs);
	   					 vidas = vidas -1;
	   					 }
	   			 }
	
	      		   

        if(juegofin()) {
			entorno.dibujarImagen(fondo, 200, 200, 0);
			entorno.dibujarImagen(gameOver, 375, 300, 0);
		}
    }
	public boolean juegofin() {
		if(this.vidas <= 0) {
			return true;
		}else {
			return false;
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
