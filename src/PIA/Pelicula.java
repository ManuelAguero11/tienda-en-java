
package PIA;

/**
 *
 * @author aguer
 */
public class Pelicula extends Producto{
    
    public Pelicula(int id, String titulo, int inventario, int disponibles){
        super(id, titulo, inventario, disponibles);
    }
    
    @Override
    public String toString(){
        return "ID: " + id + "\tTitulo: " + titulo + 
                "\tInventario: " + inventario + "\tDisponibles: " + disponibles +"\n\n";
    }
}
