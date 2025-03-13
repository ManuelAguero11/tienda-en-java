
package PIA;

/**
 *
 * @author aguer
 */

import java.util.List;
import java.util.HashMap;


public class Empresa {
    private HashMap<Integer, Usuario> usuarios;
    private HashMap<Integer, Pelicula> peliculas;
    private HashMap<Integer, Serie> series;
    private HashMap<Integer, Videojuego> videojuegos;
    private HashMap<String, Cliente> clientes;
    
    public Empresa(List<Usuario> usuario, List<Pelicula> pelicula) {
        this.usuarios = new HashMap<Integer, Usuario>();
        for(Usuario u : usuarios.values()){
                this.usuarios.put(u.getId(), u);
        }
        this.peliculas = new HashMap<Integer, Pelicula>();
        for(Pelicula p : peliculas.values()){
                this.peliculas.put(p.getId(), p);
        }
        this.series = new HashMap<Integer, Serie>();
        for(Serie s : series.values()){
                this.series.put(s.getId(), s);
        }
        this.videojuegos = new HashMap<Integer, Videojuego>();
        for(Videojuego v : videojuegos.values()){
                this.videojuegos.put(v.getId(), v);
        }
        this.clientes = new HashMap<String, Cliente>();
        for(Cliente c : clientes.values()){
                this.clientes.put(c.getId(), c);
        }
    }
    
    public Empresa(){
	this.usuarios = new HashMap<Integer, Usuario>();
        this.peliculas = new HashMap<Integer, Pelicula>();
        this.series = new HashMap<Integer, Serie> ();
        this. videojuegos = new HashMap<Integer, Videojuego> ();
        this.clientes = new HashMap<String, Cliente> ();
    }
    
    public HashMap<Integer, Usuario> getUsuarios(){
        return usuarios;
    }
    
    public Usuario getUsuario(int id){
        return usuarios.get(id);
    }
    
    public void addUsuario(Usuario usuario){
        usuarios.put(usuario.getId(), usuario);
    }
    
    public HashMap<Integer, Pelicula> getPeliculas(){
        return peliculas;
    }
    
    public Pelicula getPelicula(int id){
        return peliculas.get(id);
    }
    
    public void addPelicula(Pelicula pelicula){
        peliculas.put(pelicula.getId(), pelicula);
    }
    
    public HashMap<Integer, Serie> getSeries(){
        return series;
    }
    
    public Serie getSerie(int id){
        return series.get(id);
    }
    
    public void addSerie(Serie serie){
        series.put(serie.getId(), serie);
    }
    
    public HashMap<Integer, Videojuego> getVideojuegos(){
        return videojuegos;
    }
    
    public Videojuego getVideojuego(int id){
        return videojuegos.get(id);
    }
    
    public void addVideojuego(Videojuego videojuego){
        videojuegos.put(videojuego.getId(), videojuego);
    }
    
    public HashMap<String, Cliente> getClientes(){
        return clientes;
    }
    
    public Cliente getCliente(String id){
        return clientes.get(id);
    }
    
    public void addCliente(Cliente cliente){
        clientes.put(cliente.getId(), cliente);
    }
    
}
