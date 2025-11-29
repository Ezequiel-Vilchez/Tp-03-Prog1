public class ListaEnlazada {
    private Nodo primero;
    private int tamano;

    public ListaEnlazada() {
        this.primero = null;
        this.tamano = 0;
    }

    public void agregar(Object dato) {
        Nodo nuevo = new Nodo(dato);

        if (this.primero == null) {
            this.primero = nuevo;

        } else {
            Nodo actual = this.primero;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;

        }
        tamano++;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public int getTamano() {
        return tamano;
    }

    public Object[] convertirAArray() {

        int tamano = 0;
        Nodo actual = primero;

        while (actual != null) {
            tamano++;
            actual = actual.siguiente;
        }

        Object[] array = new Object[tamano];

        actual = primero;
        int i = 0;

        while (actual != null) {

            array[i] = actual.dato;

            i++;
            actual = actual.siguiente;
        }
        return array;
    }

    
    public void agregarAlInicio(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (this.primero == null) {
            this.primero = nuevo;
        } else {
            nuevo.siguiente = this.primero;
            this.primero = nuevo;
        }
        tamano++;
    }

    
    public Object eliminarInicio() {
        if (this.primero == null) {
            return null;
        }

        Object dato = this.primero.dato;
        this.primero = this.primero.siguiente;
        tamano--;
        return dato;
    }
}