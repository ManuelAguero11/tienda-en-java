
package PIA;

/**
 *
 * @author aguer
 */
public class Producto {
    protected int id;
    protected String titulo;
    protected int inventario;
    protected int disponibles;
    
    public Producto(){
        this.id = 0;
        this.titulo = "";
        this.inventario = 0;
        this.disponibles = 0;
    }
    
    public Producto(int id, String titulo, int inventario, int disponibles){
        this.id = id;
        this.titulo = titulo;
        this.inventario = inventario;
        this.disponibles = disponibles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }
    
    
    @Override
    public String toString(){
        return "ID: " + id + "\tTitulo: " + titulo + 
                "\tInventario: " + inventario + "\tDisponibles: " + disponibles +"\n\n";
    }
}
