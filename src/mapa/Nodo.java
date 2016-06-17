package mapa;

import grafico.Punto;

public class Nodo implements Comparable<Nodo> {
	private Punto ubicacion;
	int costo;
	int distancia;
	int total;
	Nodo padre;

	public Nodo(Punto ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Punto getUbicacion() {
		return ubicacion;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(Punto p) {
		this.distancia = ((Math.abs(this.ubicacion.getX() - p.getX()) + Math
				.abs(this.ubicacion.getY() - p.getY())) * 2);
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

//	 public int compareTo(Nodo o) {
//		 int resultado = 0;
//		 if (this.total < o.total) {
//		 resultado = -1;
//		 } else if (this.total > o.total) {
//		 resultado = 1;
//		 } else {
//		 if (this.distancia < o.distancia) {
//		 resultado = -1;
//		 } else if (this.distancia > o.distancia) {
//		 resultado = 1;
//		 } else {
//		 resultado = 0;
//		 }
//		 }
//		 return resultado;
//		 }

	 public int compareTo(Nodo nodo)
		{
			if (this.total< nodo.getTotal())
				return -1;

			if (this.total> nodo.getTotal()) 
				return 1;
			if (this.distancia < nodo.distancia) 
				return -1;
			if (this.distancia > nodo.distancia) 
				return 1;
			return posicion().compareTo(nodo.posicion());
		}

	 
	 public String posicion() {
			return String.valueOf(this.ubicacion.getX())+"-"+String.valueOf(this.ubicacion.getY());
		}

}