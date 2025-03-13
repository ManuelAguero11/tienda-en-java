/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIA;

/**
 *
 * @author aguer
 */
public class Cliente {
    private String id;
    private String nombre;
    private String telefono;
    private String servicio;
    
    public Cliente(){
        this.id = "000";
        this.nombre = "";
        this.telefono = "";
        this.servicio = "";
    }
    
    public Cliente(String id, String nombre, String numContacto, String servicio){
        this.id = id;
        this.nombre = nombre;
        this.telefono = numContacto;
        this.servicio = servicio;
    }
        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
    @Override
    public String toString(){
        return "\n\tTicket num: " + id + "\n\tCliente: " + nombre + "\n\tTelefono: " + telefono
                + "\n\tServicios: " + servicio;
    }
    
    
}
