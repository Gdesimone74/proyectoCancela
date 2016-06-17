package mapa;

import grafico.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Buscar {

	public ArrayList<Punto> busquedaDeCamino(Nodo origen, Nodo destino,
			Mapa mapa) {
		SortedSet<String> expandidosTotal = new TreeSet();
		SortedSet<Nodo> expandido = new  TreeSet();
		ArrayList<Punto> camino = new ArrayList<Punto>();

		Nodo solucion = buscarCamino(origen, destino, mapa, expandido, camino,
				expandidosTotal);
		while (origen.getUbicacion().getX() != solucion.getUbicacion().getX()
				&& origen.getUbicacion().getY() != solucion.getUbicacion()
						.getY() || solucion.getPadre() != null) {
			camino.add(solucion.getUbicacion());
			solucion = solucion.getPadre();
		}
		
		return camino;
	}

	// private Nodo buscarCamino(Nodo origen, Nodo destino, Mapa mapa,
	// ArrayList<Nodo> expandido, ArrayList<Punto> camino, ArrayList<String>
	// expandidosTotal) {
	// System.out.println("estoy: "+origen.getUbicacion().getX()+" "+origen.getUbicacion().getY()+" "+"voy: "+destino.getUbicacion().getX()+" "+destino.getUbicacion().getY());
	// expandidosTotal.add(origen.getUbicacion().toString());
	// expandoAbajo(origen,destino,mapa,expandido,expandidosTotal);
	// expandoArriba(origen,destino,mapa,expandido,expandidosTotal);
	// expandoIquierda(origen,destino,mapa,expandido,expandidosTotal);
	// expandoDerecha(origen,destino,mapa,expandido,expandidosTotal);
	// expandoArDer(origen,destino,mapa,expandido,expandidosTotal);
	// expandoArIzq(origen,destino,mapa,expandido,expandidosTotal);
	// expandoAbDer(origen,destino,mapa,expandido,expandidosTotal);
	// expandoAbIzq(origen,destino,mapa,expandido,expandidosTotal);
	//
	//
	//
	// System.out.println(expandido.size());
	// Collections.sort(expandido);
	// Nodo solucion=expandido.get(0);
	//
	// expandido.remove(solucion);
	// if(solucion.getUbicacion().getX()==destino.getUbicacion().getX()&&solucion.getUbicacion().getY()==destino.getUbicacion().getY())
	// {
	// return solucion;
	// }
	// else
	// {
	// return
	// buscarCamino(solucion,destino,mapa,expandido,camino,expandidosTotal);
	// }
	//
	// }

	private Nodo buscarCamino(Nodo origen, Nodo destino, Mapa mapa,
			SortedSet<Nodo> expandido, ArrayList<Punto> camino,
			SortedSet<String> expandidosTotal) {

		while (!origen.getUbicacion().esIgual(destino.getUbicacion())) {
			 System.out.println("estoy: "+origen.getUbicacion().getX()+" "+origen.getUbicacion().getY()+" "+"voy: "+destino.getUbicacion().getX()+" "+destino.getUbicacion().getY());
			expandidosTotal.add(origen.posicion());
			expandoAbajo(origen, destino, mapa, expandido, expandidosTotal);
			expandoArriba(origen, destino, mapa, expandido, expandidosTotal);
			expandoIquierda(origen, destino, mapa, expandido, expandidosTotal);
			expandoDerecha(origen, destino, mapa, expandido, expandidosTotal);
			expandoArDer(origen, destino, mapa, expandido, expandidosTotal);
			expandoArIzq(origen, destino, mapa, expandido, expandidosTotal);
			expandoAbDer(origen, destino, mapa, expandido, expandidosTotal);
			expandoAbIzq(origen, destino, mapa, expandido, expandidosTotal);
			
			Nodo solucion = expandido.first();
			origen=solucion;
			expandido.remove(solucion);
			if (solucion.getUbicacion().esIgual(destino.getUbicacion())) {
				return solucion;
			}

		}
		return null;
	}

	private SortedSet<Nodo> expandoAbIzq(Nodo origen, Nodo destino, Mapa mapa,
			SortedSet<Nodo> expandido, SortedSet<String> expandidosTotal) {
		int x;
		int y;
		if (origen.getUbicacion().getX() - 1 != -1
				&& origen.getUbicacion().getY() + 1 != 400) {
			x = origen.getUbicacion().getX() - 1;
			y = origen.getUbicacion().getY() + 1;
		} else {
			return expandido;
		}
		Punto punto = new Punto(x, y);
		Nodo sig = new Nodo(punto);
		if (mapa.getDensidad(punto) == 3) {
			return expandido;
		}

		if (expandidosTotal.contains(sig.posicion())) {
			return expandido;
		}

		if (mapa.getDensidad(punto) == 0) {
			sig.setCosto(origen.getCosto() + (1*14));
		}
		if (mapa.getDensidad(punto) == 1) {
			sig.setCosto((origen.getCosto() + (2*14)));
		}
		if (mapa.getDensidad(punto) == 2) {
			sig.setCosto((origen.getCosto() + (3*14)));
		}
		sig.setDistancia(destino.getUbicacion());
		sig.setTotal(sig.getCosto() + sig.getDistancia());
		sig.setPadre(origen);
		expandido.add(sig);
		expandidosTotal.add(sig.posicion());
		return expandido;

	}

	private SortedSet<Nodo> expandoAbDer(Nodo origen, Nodo destino, Mapa mapa,
			SortedSet<Nodo> expandido, SortedSet<String> expandidosTotal) {
		int x;
		int y;
		if (origen.getUbicacion().getX() + 1 != 400
				&& origen.getUbicacion().getY() + 1 != 400) {
			x = origen.getUbicacion().getX() + 1;
			y = origen.getUbicacion().getY() + 1;
		} else {
			return expandido;
		}
		Punto punto = new Punto(x, y);
		if (mapa.getDensidad(punto) == 3) {
			return expandido;
		}
		Nodo sig = new Nodo(punto);
		if (mapa.getDensidad(punto) == 3) {
			return expandido;
		}

		if (expandidosTotal.contains(sig.posicion())) {
			return expandido;
		}

		if (mapa.getDensidad(punto) == 0) {
			sig.setCosto(origen.getCosto() + (1*14));
		}
		if (mapa.getDensidad(punto) == 1) {
			sig.setCosto((origen.getCosto() + (2*14)));
		}
		if (mapa.getDensidad(punto) == 2) {
			sig.setCosto((origen.getCosto() + (3*14)));
		}
		sig.setDistancia(destino.getUbicacion());
		sig.setTotal(sig.getCosto() + sig.getDistancia());
		sig.setPadre(origen);
		expandido.add(sig);
		expandidosTotal.add(sig.posicion());
		return expandido;

	}

	private SortedSet<Nodo> expandoArIzq(Nodo origen, Nodo destino, Mapa mapa,
			SortedSet<Nodo> expandido, SortedSet<String> expandidosTotal) {
		int x;
		int y;
		if (origen.getUbicacion().getX() - 1 != -1
				&& origen.getUbicacion().getY() - 1 != -1) {
			x = origen.getUbicacion().getX() - 1;
			y = origen.getUbicacion().getY() - 1;
		} else {
			return expandido;
		}
		Punto punto = new Punto(x, y);
		Nodo sig = new Nodo(punto);
		if (mapa.getDensidad(punto) == 3) {
			return expandido;
		}

		if (expandidosTotal.contains(sig.posicion())) {
			return expandido;
		}

		if (mapa.getDensidad(punto) == 0) {
			sig.setCosto(origen.getCosto() + (1*14));
		}
		if (mapa.getDensidad(punto) == 1) {
			sig.setCosto((origen.getCosto() + (2*14)));
		}
		if (mapa.getDensidad(punto) == 2) {
			sig.setCosto((origen.getCosto() + (3*14)));
		}
		sig.setDistancia(destino.getUbicacion());
		sig.setTotal(sig.getCosto() + sig.getDistancia());
		sig.setPadre(origen);
		expandido.add(sig);
		expandidosTotal.add(sig.posicion());
		return expandido;

	}

	private SortedSet<Nodo> expandoArDer(Nodo origen, Nodo destino, Mapa mapa,
			SortedSet<Nodo> expandido, SortedSet<String> expandidosTotal) {
		int x;
		int y;
		if (origen.getUbicacion().getX() + 1 != 400
				&& origen.getUbicacion().getY() - 1 != -1) {
			x = origen.getUbicacion().getX() + 1;
			y = origen.getUbicacion().getY() - 1;
		} else {
			return expandido;
		}
		Punto punto = new Punto(x, y);
		Nodo sig = new Nodo(punto);
		if (mapa.getDensidad(punto) == 3) {
			return expandido;
		}

		if (expandidosTotal.contains(sig.posicion())) {
			return expandido;
		}

		if (mapa.getDensidad(punto) == 0) {
			sig.setCosto(origen.getCosto() + (1*14));
		}
		if (mapa.getDensidad(punto) == 1) {
			sig.setCosto((origen.getCosto() + (2*14)));
		}
		if (mapa.getDensidad(punto) == 2) {
			sig.setCosto((origen.getCosto() + (3*14)));
		}
		sig.setDistancia(destino.getUbicacion());
		sig.setTotal(sig.getCosto() + sig.getDistancia());
		sig.setPadre(origen);
		expandido.add(sig);
		expandidosTotal.add(sig.posicion());
		return expandido;
	}

	private SortedSet<Nodo> expandoDerecha(Nodo origen, Nodo destino,
			Mapa mapa, SortedSet<Nodo> expandido,
			SortedSet<String> expandidosTotal) {
		int x;
		int y;
		if (origen.getUbicacion().getX() + 1 != 400) {
			x = origen.getUbicacion().getX() + 1;
			y = origen.getUbicacion().getY();
		} else {
			return expandido;
		}
		Punto punto = new Punto(x, y);
		Nodo sig = new Nodo(punto);
		if (mapa.getDensidad(punto) == 3) {
			return expandido;
		}

		if (expandidosTotal.contains(sig.posicion())) {
			return expandido;
		}

		if (mapa.getDensidad(punto) == 0) {
			sig.setCosto(origen.getCosto() + (1*10));
		}
		if (mapa.getDensidad(punto) == 1) {
			sig.setCosto((origen.getCosto() + (2*10)));
		}
		if (mapa.getDensidad(punto) == 2) {
			sig.setCosto((origen.getCosto() + (3*10)));
		}
		sig.setDistancia(destino.getUbicacion());
		sig.setTotal(sig.getCosto() + sig.getDistancia());
		sig.setPadre(origen);
		expandido.add(sig);
		expandidosTotal.add(sig.posicion());
		return expandido;

	}

	private SortedSet<Nodo> expandoIquierda(Nodo origen, Nodo destino,
			Mapa mapa, SortedSet<Nodo> expandido,
			SortedSet<String> expandidosTotal) {
		int x;
		int y;
		if (origen.getUbicacion().getX() - 1 != -1) {
			x = origen.getUbicacion().getX() - 1;
			y = origen.getUbicacion().getY();
		} else {
			return expandido;
		}
		Punto punto = new Punto(x, y);
		Nodo sig = new Nodo(punto);
		if (mapa.getDensidad(punto) == 3) {
			return expandido;
		}

		if (expandidosTotal.contains(sig.posicion())) {
			return expandido;
		}

		if (mapa.getDensidad(punto) == 0) {
			sig.setCosto(origen.getCosto() + (1*10));
		}
		if (mapa.getDensidad(punto) == 1) {
			sig.setCosto((origen.getCosto() + (2*10)));
		}
		if (mapa.getDensidad(punto) == 2) {
			sig.setCosto((origen.getCosto() + (3*10)));
		}
		sig.setDistancia(destino.getUbicacion());
		sig.setTotal(sig.getCosto() + sig.getDistancia());
		sig.setPadre(origen);
		expandido.add(sig);
		expandidosTotal.add(sig.posicion());
		return expandido;

	}

	private SortedSet<Nodo> expandoArriba(Nodo origen, Nodo destino, Mapa mapa,
			SortedSet<Nodo> expandido, SortedSet<String> expandidosTotal) {
		int x;
		int y;
		if (origen.getUbicacion().getY() - 1 != -1) {
			y = origen.getUbicacion().getY() - 1;
			x = origen.getUbicacion().getX();
		} else {
			return expandido;
		}
		Punto punto = new Punto(x, y);
		Nodo sig = new Nodo(punto);
		if (mapa.getDensidad(punto) == 3) {
			return expandido;
		}

		if (expandidosTotal.contains(sig.posicion())) {
			return expandido;
		}

		if (mapa.getDensidad(punto) == 0) {
			sig.setCosto(origen.getCosto() + (1*10));
		}
		if (mapa.getDensidad(punto) == 1) {
			sig.setCosto((origen.getCosto() + (2*10)));
		}
		if (mapa.getDensidad(punto) == 2) {
			sig.setCosto((origen.getCosto() + (3*10)));
		}
		sig.setDistancia(destino.getUbicacion());
		sig.setTotal(sig.getCosto() + sig.getDistancia());
		sig.setPadre(origen);
		expandido.add(sig);
		expandidosTotal.add(sig.posicion());
		return expandido;

	}

	private SortedSet<Nodo> expandoAbajo(Nodo origen, Nodo destino, Mapa mapa,
			SortedSet<Nodo> expandido, SortedSet<String> expandidosTotal) {
		int x;
		int y;
		if (origen.getUbicacion().getY() + 1 != 400) {
			y = origen.getUbicacion().getY() + 1;
			x = origen.getUbicacion().getX();
		} else {
			return expandido;
		}
		Punto punto = new Punto(x, y);
		Nodo sig = new Nodo(punto);
		if (mapa.getDensidad(punto) == 3) {
			return expandido;
		}

		if (expandidosTotal.contains(sig.posicion())) {
			return expandido;
		}
		if (mapa.getDensidad(punto) == 0) {
			sig.setCosto(origen.getCosto() + (1*10));
		}
		if (mapa.getDensidad(punto) == 1) {
			sig.setCosto((origen.getCosto() + (2*10)));
		}
		if (mapa.getDensidad(punto) == 2) {
			sig.setCosto((origen.getCosto() + (3*10)));
		}
		sig.setDistancia(destino.getUbicacion());
		sig.setTotal(sig.getCosto() + sig.getDistancia());
		sig.setPadre(origen);
		expandido.add(sig);
		expandidosTotal.add(sig.posicion());
		return expandido;
	}

}