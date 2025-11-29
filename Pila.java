public class Pila {
    private ListaEnlazada lista;

    public Pila() {
        this.lista = new ListaEnlazada();
    }

    //Insertar(push)
    public void push(Object dato){
        lista.agregarAlInicio(dato);
    }

    // Quitar(pop)
    public Object pop(){
        return lista.eliminarInicio();
    }

    //metodo peek
    public Object peek(){
        if (lista.estaVacia()) {
            return null;
        }else {
            //Obtiene el nodo primero y de ese nodo saca el dato
            return lista.getPrimero().getDato();
        }
    }

    public boolean estaVacia(){
        
        return lista.estaVacia();
    }
}
