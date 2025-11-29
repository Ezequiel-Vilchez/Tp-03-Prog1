public class Cola {
    private ListaEnlazada lista;

    public Cola(){
        this.lista = new ListaEnlazada();
    }

    //Insertar al final de la cola
    public void insertar(Object dato){
        lista.agregar(dato);//uso el metodo que estaba en listaenlazada para agregarlo al final de la cola
    }

    //Quitar del inicio de la cola
    public Object quitar(){
        return lista.eliminarInicio();
    }

    public boolean estaVacia(){
        return lista.estaVacia();
    }
}
