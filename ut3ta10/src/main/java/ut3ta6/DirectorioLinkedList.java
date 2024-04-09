package ut3ta6;

import java.util.LinkedList;

public class DirectorioLinkedList {

    private LinkedList<String> sucursales = new LinkedList<>();


    /*
    La ejecución es constante. El metodo ejecuta una única sentencia, la cual
    invoca a un método de la clase LinkedList, el cual no cuenta con ningún
    bucle, por lo que, salvo algún detalle adicional de bajo nivel, debería 
    ser constante, independientemente de cualquier condición.
     */ 
    
    public void agregar(String sucursal) {
        this.sucursales.addLast(sucursal);
    }

    /*
     * La ejecución es lineal dependiendo N la longitud de la lista.
     *  El método cuenta con una única línea que invoca a un método de la clase 
     * LinkedList, el cual recorre toda la lista hasta encontrar aquel que contiene
     * el dato deseado. Con esto la ejecución ha de ser lineal dependiendo de la
     * longitud de la lista.
     */
    public boolean quitarSucursal(Comparable sucursal) {
        return this.sucursales.remove(sucursal);
    }

    /*
     * La ejecución es lineal dependiendo N la longitud de la lista.
     *  El método cuenta con una línea condicional que invoca a un método de la clase 
     * LinkedList, el cual recorre toda la lista hasta encontrar aquel que contiene
     * el dato deseado. El resto de líneas del método son de tiempo constante. Con esto la 
     * ejecución ha de ser lineal dependiendo de la longitud de la lista.
     */

    public String buscar(Comparable sucursal) {
        if (this.sucursales.indexOf(sucursal) < 0) {
            return null;
        }
        return sucursal.toString();
    }

    /*
     * La ejecución del método es lineal dependiendo de N la longitud de la lista.
     * El método contiene un bucle for que itera a través de todos los elementos 
     * de la lista para obtener sus valores.
     */
    public String litarSucursales() {
        StringBuilder sb = new StringBuilder();

        for (String string : sucursales) {
            sb.append(string + "\n");
        }
        return sb.toString();
    }

    //Ídem

    public String litarSucursales(String separador) {
        StringBuilder sb = new StringBuilder();

        for (String string : sucursales) {
            sb.append(string + separador);
        }
        return sb.toString();
    }

    /*
     * El método es de tiempo de ejecución constante.
     * Esto dado que simplemente utiliza un método de la clase LinkedList
     * que lo único que hace es devolver un valor preestablecido de la misma.
     */
    public int cantidadDeSucursales() {
        return this.sucursales.size();
    }

    /*
     * El método es de tiempo de ejecución constante.
     * Esto dado que simplemente utiliza un método de la clase LinkedList
     * que lo único que hace es realizar una comparación con un valor 
     * predefinido y devolver el resultado de la misma.
     */
    public boolean estaVacio() {
        return this.sucursales.isEmpty();
    }

    public static void main(String[] args) {

        DirectorioLinkedList d = new DirectorioLinkedList();
        String[] archivo = ManejadorArchivosGenerico.leerArchivo("suc2.txt");

        for (String string : archivo) {
            d.agregar(string);
        }

        /*
         * d.quitarSucursal("Shenzhen");
         */ d.quitarSucursal("Tokio");
        System.out.println(d.litarSucursales());
        System.out.println(d.cantidadDeSucursales());

        d.quitarSucursal("Tokio");
        System.out.println(d.litarSucursales());
        System.out.println(d.cantidadDeSucursales());

        // System.out.println(d.litarSucursales(";_"));
        // System.out.println(d.cantidadDeSucursales());

    }
}
