public class Pila {
    private ListaEnlazada lista;

    public Pila() {
        this.lista = new ListaEnlazada();
    }

    public void push(Object dato){
        lista.agregarAlInicio(dato);
    }

    public Object pop(){
        return lista.eliminarInicio();
    }

    public Object peek(){
        if (lista.estaVacia()) {
            return null;
        }else {
            return lista.getPrimero().getDato();
        }
    }

    public boolean estaVacia(){
        
        return lista.estaVacia();
    }
}
