public class Universidad {
    private String nombre;
    private String direccion; 
    private ListaEnlazada miembros;

    
    public Universidad(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.miembros = new ListaEnlazada(); 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion; 
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarMiembros(MiembroUniversidad miembro) {
        
        Nodo actual = miembros.getPrimero();
        while (actual != null) {
            
            MiembroUniversidad m = (MiembroUniversidad) actual.getDato();

            
            if (m instanceof Persona && miembro instanceof Persona) {
                if (((Persona) m).getDocumento().equals(((Persona) miembro).getDocumento())) {
                    System.out.println("Error: El miembro ya existe.");
                    return; 
                }
            }
            actual = actual.getSiguiente(); 
        }

        miembros.agregar(miembro);
        System.out.println("Miembro agregado: " + miembro.obtenerRol());
    }

    public Estudiante buscarEstudianteBinario(String documentoBuscado) {
        
        Object[] todosLosMiembros = miembros.convertirAArray();

        
        int countEst = 0;
        for (Object o : todosLosMiembros) {
            if (o instanceof Estudiante)
                countEst++;
        }

        
        Estudiante[] estudiantesArray = new Estudiante[countEst];
        int k = 0;
        for (Object o : todosLosMiembros) {
            if (o instanceof Estudiante) {
                estudiantesArray[k] = (Estudiante) o; 
                k++;
            }
        }

        this.ordenarPorDocumento(estudiantesArray);

        
        int inicio = 0;
        int fin = estudiantesArray.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2; 
            Estudiante est = estudiantesArray[medio];

            int comparacion = est.getDocumento().compareTo(documentoBuscado);

            if (comparacion == 0) {
                return est; 
            } else if (comparacion < 0) {
                inicio = medio + 1; 
            } else {
                fin = medio - 1; 
            }
        }
        return null; 
    }

    private void ordenarPorDocumento(Estudiante[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].getDocumento().compareTo(arr[j + 1].getDocumento()) > 0) {
                    Estudiante temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    
    public void mostrarMiembros() {
        System.out.println("--- Miembros de " + nombre + " (" + direccion + ") ---");

        Nodo actual = miembros.getPrimero();
        while (actual != null) {
            MiembroUniversidad m = (MiembroUniversidad) actual.getDato();
            System.out.println(m.obtenerInformacionCompleta());
            actual = actual.getSiguiente(); 
        }
    }
}