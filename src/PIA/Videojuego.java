
package PIA;

/**
 *
 * @author aguer
 */
public class Videojuego extends Producto{
    public Videojuego(int id, String titulo, int inventario, int disponibles){
        super(id, titulo, inventario, disponibles);
    }
    
    @Override
    public String toString(){
        return "ID: " + id + "\tTitulo: " + titulo + 
                "\tInventario: " + inventario + "\tDisponibles: " + disponibles +"\n\n";
    }
}
