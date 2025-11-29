public class Cola {
    private ListaEnlazada lista;

    public Cola(){
        this.lista = new ListaEnlazada();
    }

    
    public void insertar(Object dato){
        lista.agregar(dato);
    }

    
    public Object quitar(){
        return lista.eliminarInicio();
    }

    public boolean estaVacia(){
        return lista.estaVacia();
    }
}
