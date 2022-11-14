package ArbolBinario;
//Arbol Binario de Busqueda
public class ABB {
	private Nodo raiz;

	public ABB(Nodo raiz)
	{
		this.raiz=raiz;
	}
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	/*
	public void agregar(Nodo actual, Nodo nuevo)
	{
		if(this.raiz==null)
		{
			this.raiz=n;
			return;
		}
		if(n.getDato()<this.dato)
		{
			if(this.izquierdo()!= null)
			{
				this.izquierdo.agregar(n);
			}
			else
			{
				this.izquierdo=n;
			}
		}
		else
		{
			if(this.derecho!=null)
			{
				this.derecho.agregar(n);
			}
			else
			{
				this.derecho=n;
			}
		}
	}
	*/
	public void agregar(Nodo n)
	{
		if(raiz==null)
		{
			raiz=n;
		}
		else
		{
			agregar(n, raiz);
		}
	}
	private void agregar(Nodo n, Nodo actual)
	{
		if(actual.getDato()>n.getDato())
		{
			if(actual.getIzquierdo()!=null)
			{
				agregar(n, actual.getIzquierdo());
			}
			else
			{
				actual.setIzquierdo(n);
			}
		}
		else
		{

			if(actual.getDerecho()!=null)
			{
				agregar(n, actual.getDerecho());
			}
			else
			{
				actual.setDerecho(n);
			}
		}
	}
	
	public void imprimir()
	{
		imprimirArbol(raiz);
	}
	private void imprimirArbol(Nodo n)
	{
		if(n!=null)
		{
			System.out.println(n.getDato());
			imprimirArbol(n.getIzquierdo());
			imprimirArbol(n.getDerecho());
		}
	}
	public Nodo buscar(int dato)
	{
		Nodo NodoActual=raiz;
		if(buscarDato(NodoActual, dato)==null)
		{
			System.out.println("No se encontro el dato");
			return null;
		}
		else
		{
			System.out.println("Se encontro el dato");
		}
		return buscarDato(NodoActual, dato);
	}
	private Nodo buscarDato(Nodo NodoActual, int dato)
	{
		if(NodoActual.getDato()==dato)
		{
			return NodoActual;
		}
		if(NodoActual!=null && NodoActual.getDato()!=dato)
		{
			if(NodoActual.getDato()>dato && NodoActual.getIzquierdo()!=null)
			{
				NodoActual=NodoActual.getIzquierdo();
			}
			else
			{
				if(NodoActual.getDerecho()!=null)
				{
					NodoActual=NodoActual.getDerecho();
				}
				else
				{
					return null;
				}
			}
		}
		//recursivo nodo, dato en recursivo parametros
		return buscarDato(NodoActual, dato);
	}

	public boolean eliminar(int dato)
	{
		Nodo nodo = raiz;
		Nodo nodoPadre = raiz;
		boolean esHijoIzquierdo = true;
		while(nodo.getDato()!=dato)
		{
			nodoPadre = nodo;
			if(dato<nodo.getDato())
			{
				esHijoIzquierdo=true;
				nodo = nodo.getIzquierdo();
			}
			else
			{
				esHijoIzquierdo=false;
				nodo = nodo.getDerecho();
			}
			if(nodo==null)
			{
				return false;
			}
		}
		if(nodo.getIzquierdo()==null && nodo.getDerecho()==null)
		{
			if(nodo==raiz)
			{
				nodo=null;
			}
			else
			if(esHijoIzquierdo)
			{
				nodoPadre.setIzquierdo(null);
			}
			else
			{
				nodoPadre.setDerecho(null);
			}
		}
		else
		if(nodo.getDerecho()==null)
		{
			if(nodo==raiz)
			{
				raiz=nodo.getIzquierdo();
			}
			else
			if(esHijoIzquierdo)
			{
				nodoPadre.setIzquierdo(nodo.getIzquierdo());
			}
			else
			{
				nodoPadre.setDerecho(nodo.getIzquierdo());
			}
		}
		else
		if(nodo.getIzquierdo()==null)
		{
			if(nodo==raiz)
			{
				raiz=nodo.getDerecho();
			}
			else
			if(esHijoIzquierdo)
			{
				nodoPadre.setIzquierdo(nodo.getDerecho());
			}
			else
			{
				nodoPadre.setDerecho(nodo.getDerecho());
			}
		}
		else
		{
			Nodo nodoReemplazo = encontrarReemplazo(nodo);
			if(nodo==raiz)
			{
				raiz=nodoReemplazo;
			}
			else
			if(esHijoIzquierdo)
			{
				nodoPadre.setIzquierdo(nodoReemplazo);
			}
			else
			{
				nodoPadre.setDerecho(nodoReemplazo);
			}
			nodoReemplazo.setIzquierdo(nodo.getIzquierdo());
		}
		return true;
	}
	
	private Nodo encontrarReemplazo(Nodo nodo)
	{
		Nodo reemplazarNodoPadre = nodo;
		Nodo reemplazoNodo = nodo;
		Nodo nodoAuxiliar = nodo.getDerecho();
		
		while(nodoAuxiliar!=null)
		{
			reemplazarNodoPadre=reemplazoNodo;
			reemplazoNodo=nodoAuxiliar;
			nodoAuxiliar=nodoAuxiliar.getIzquierdo();
		}
		if(reemplazoNodo!=nodo.getDerecho())
		{
			reemplazarNodoPadre.setIzquierdo(reemplazoNodo.getDerecho());
			reemplazoNodo.setDerecho(nodo.getDerecho());
		}
		return reemplazoNodo;
	}
	
	
	
	/*
	private Nodo buscarDato(int dato)
	{
		
		Nodo NodoActual=raiz;
		while(NodoActual!=null && NodoActual.getDato()!=dato)
		{
			if(NodoActual.getDato()>dato)
			{
				NodoActual=NodoActual.getDerecho();
			}
			else
			{
				NodoActual=NodoActual.getIzquierdo();
			}
		}
		//recursivo nodo, dato en recursivo parametros
		return NodoActual;
	}
	*/
	
	
	

}
