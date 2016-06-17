package mapa;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import app.Inicio;
import grafico.DibujoTDA;
import grafico.PoliLinea;
import grafico.Punto;

public class Camino {
	private Mapa mapa;
	private Nodo origen;
	private Nodo destino;
	
	public Camino(Mapa mapa){
		this.mapa = mapa;
	}
	public Mapa getMapa() {
		return mapa;
	}
	public Nodo getOrigen() {
		return origen;
	}
	public void setOrigen(Nodo origen) {
		this.origen = origen;
	}
	public void setOrigen(Punto punto) {
		this.origen = new Nodo(punto);
	}
	public Nodo getDestino() {
		return destino;
	}
	public void setDestino(Nodo destino) {
		this.destino = destino;
	}
	public void setDestino(Punto punto) {
		this.destino = new Nodo(punto);
	}
	
	public DibujoTDA buscarCamino(){
	
//		
//		int xdesde = Math.min(origen.getUbicacion().getX(), destino.getUbicacion().getX());
//		int xhasta = Math.max(origen.getUbicacion().getX(), destino.getUbicacion().getX());
//		int ydesde = Math.min(origen.getUbicacion().getY(), destino.getUbicacion().getY());
//		int yhasta = Math.max(origen.getUbicacion().getY(), destino.getUbicacion().getY());
//		
		
		int xdesde = origen.getUbicacion().getX();
		int xhasta =  destino.getUbicacion().getX();
		int ydesde =origen.getUbicacion().getY();
		int yhasta = destino.getUbicacion().getY();
		
		Punto porigen=new Punto(xdesde, ydesde);
		Punto pdestino=new Punto(xhasta, yhasta);
		Nodo origen=new Nodo(porigen);
		Nodo destino= new Nodo(pdestino);
		Buscar b =new Buscar();
		
		
		List<Punto> cmc = new ArrayList<Punto>();
		cmc=b.busquedaDeCamino(origen,destino,mapa);
//		for(int x = xdesde; x <= xhasta; x++){
//			Punto punto = new Punto(x,origen.getUbicacion().getY());
//			
//			cmc.add(punto);
//		}
//		
//		for(int y = ydesde; y <= yhasta; y++){
//			Punto punto = new Punto(destino.getUbicacion().getX(),y);
//			cmc.add(punto);
//		}
//		 
		return dibujarCamino(cmc); // retorna el camino dibujado 
	}
	
	private DibujoTDA dibujarCamino(List<Punto> cmc){
		int[][] xy = new int[2][cmc.size()];
		int index = 0;
		for(Punto p : cmc){
			xy[0][index] = p.getX();
			xy[1][index] = p.getY();
			index++;
		}
		Inicio.camino = new Camino(Inicio.mapa);
		return new PoliLinea(xy[0],xy[1],Color.red);
	}
}
