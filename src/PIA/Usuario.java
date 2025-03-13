
package PIA;

/**
 *
 * @author aguer
 */
public class Usuario {
    private int id;
    private String nombre;
    private String contra;
    private boolean estatus;
    private String estado;
    
    public Usuario(){
        this.id = 000;
        this.nombre = "";
        this.contra = "";
        this.estatus = false;
        this.estado = "Inactivo";
    }
    
    public Usuario(int id, String nombre, String contra, boolean estatus, String estado){
        this.id = id;
        this.nombre = nombre;
        this.contra = contra;
        this.estatus = estatus;
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    @Override
    public String toString(){
        return "ID: " + id + "\tNombre: " + nombre + 
                "\tContraseña: " + contra + "\tEstado: " + estado +"\n\n";
    }
    
    
    
    
    
}
