
package PIA;

/**
 *
 * @author aguer
 */
public class Serie extends Producto{
    public Serie(int id, String titulo, int inventario, int disponibles){
        super(id, titulo, inventario, disponibles);
    }
    
    @Override
    public String toString(){
        return "ID: " + id + "\tTitulo: " + titulo + 
                "\tInventario: " + inventario + "\tDisponibles: " + disponibles +"\n\n";
    }
}
