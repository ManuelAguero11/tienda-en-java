
package PIA;

/**
 *
 * @author aguero
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;



public class Main {
    
    public static void main(String args[]) {
        /*try{
            File f = new File("Archivos\\Usuarios.txt");
            Scanner lector = new Scanner(f);
            while(lector.hasNextLine()){
                String info = lector.nextLine();
                System.out.println(info);
            }
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }*/
        
        Empresa empresa = new Empresa();
        
        // lectura archivo usuarios
        //
        File archU = new File("Archivos\\Usuarios.txt");
        Scanner lector;
        try{
            lector = new Scanner(archU);
        }catch(FileNotFoundException e){
        	System.out.println("Archivo " + archU.getAbsolutePath() + " no encontrado");
        	return;
        }
        int id;
        String nombre;
        String contra;
        String estado;
        boolean estatus;
        String comp = "";
        
       /* while(lector.hasNextInt()){
            id = lector.nextInt();
            nombre = "";
            while(!lector.hasNextInt())
                    nombre += " " + lector.next();
            nombre = nombre.substring(1, nombre.length());
            contra = "";
            while(lector.hasNextInt())
                contra += " " + lector.next();
            contra = contra.substring(1, contra.length());
            estatus = false;
            estado = "";
            while(lector.hasNext("Activo") || lector.hasNext("Inactivo")){
                comp = lector.next();
                if(comp.charAt(0) == 'A'){
                    estatus = true;
                    estado = "Activo";
                }
                else{
                    estatus = false;
                    estado = "Inactivo";
                }
            }
            empresa.addUsuario(new Usuario(id, nombre, contra, estatus, estado));
        }*/
       while(lector.hasNextInt()){
            
            id = lector.nextInt();
            nombre = "";
            contra = "";
            nombre = lector.next() + " ";
            nombre += lector.next();
            contra = lector.next();
            estatus = false;
            estado = "";
            estado = lector.next();
            if(estado.matches("Activo"))
                estatus = true;
            empresa.addUsuario(new Usuario(id, nombre, contra, estatus, estado));
        }
        //lector.reset();
       lector.close();
        
        // lectura archivo peliculas
        //
        File archP = new File("Archivos\\Peliculas.txt");
        try{
            lector = new Scanner(archP);
        }catch(FileNotFoundException e){
            System.out.println("Archivo" + archP.getAbsolutePath() + "no encontrado.");
            lector.close();
            return;
        }
        
        String titulo;
        int inventario;
        int disponibles;
        
        while(lector.hasNextInt()){
            id = lector.nextInt();
            titulo = "";
            while(!lector.hasNextInt())
                titulo = lector.next();
            inventario = 0;
            inventario = lector.nextInt();
            disponibles = 0;
            disponibles = lector.nextInt();
            empresa.addPelicula(new Pelicula(id, titulo, inventario, disponibles));
        }
        //lector.reset();
        lector.close();
        
        // lectura archivo series
        //
        File archS = new File("Archivos\\Series.txt");
        try{
            lector = new Scanner(archS);
        }catch(Exception e){
            System.out.println("Archivo" + archP.getAbsolutePath() + "no encontrado.");
            lector.close();
            return;
        }
        
        while(lector.hasNext()){
            id = lector.nextInt();
            titulo = "";
            while(!lector.hasNextInt())
                titulo = lector.next();
            inventario = 0;
            inventario = lector.nextInt();
            disponibles = 0;
            disponibles = lector.nextInt();
            empresa.addSerie(new Serie(id, titulo, inventario, disponibles));
        }
        //lector.reset();
        lector.close();
        
        File archV = new File("Archivos\\Videojuegos.txt");
        try{
            lector = new Scanner(archV);
        }catch(Exception e){
            System.out.println("Archivo" + archP.getAbsolutePath() + "no encontrado.");
            lector.close();
            return;
        }
        
        while(lector.hasNextInt()){
            id = lector.nextInt();
            titulo = "";
            while(!lector.hasNextInt())
                titulo = lector.next();
            inventario = 0;
            inventario = lector.nextInt();
            disponibles = 0;
            disponibles = lector.nextInt();
            empresa.addVideojuego(new Videojuego(id, titulo, inventario, disponibles));
        }
        //lector.reset();
        lector.close();
        
        // lectura archivo clientes
        // 
        File archC = new File("Archivos\\Clientes.txt");
        try{
            lector = new Scanner(archC);
        }catch(FileNotFoundException e){
            System.out.println("Archivo" + archP.getAbsolutePath() + "no encontrado.");
            lector.close();
            return;
        }
        String nomCliente;
        String telefono;
        String servicios;
        
        while(lector.hasNext()){
            String folio = "";
            folio = lector.next();
            nomCliente = "";
            nomCliente = lector.next() + " ";
            nomCliente += lector.next();
            telefono = "";
            telefono = lector.next();
            servicios = "";            
            servicios = lector.next();           
            empresa.addCliente(new Cliente(folio, nomCliente, telefono, servicios));
        }
        lector.close();
        
        // impresion usuarios
        for(Usuario u : empresa.getUsuarios().values())
            System.out.println(u.toString());
        /*
        * impresion peliculas 
        for(Pelicula p : empresa.getPeliculas().values())
            System.out.println(p.toString());*/
        /*
        * impresion series
        for(Serie s : empresa.getSeries().values())
            System.out.println(s.toString());*/
        /*
        * impresion videojuegos
        for(Videojuego v : empresa.getVideojuegos().values())
            System.out.println(v.toString());*/
        /*
        * impresion clientes
        for(Cliente c : empresa.getClientes().values())
            System.out.println(c.toString());*/
        
        
        System.out.println("\tDigi4Klip 2.0\n");
        boolean acceso = true;
        Scanner scan = new Scanner(System.in);
        do{
            try{
                System.out.print("\tIngrese su ID: ");
            
                int num = scan.nextInt();
                Usuario u = empresa.getUsuario(num);

                if(!empresa.getUsuarios().containsKey(num)){
                    System.out.println("\tID no registrado. Ingrese un ID valido.");
                    acceso = false;
                }else if(!empresa.getUsuario(num).isEstatus()){
                    System.out.println("\tEste usuario se encuentra INACTIVO, contacte a un administrador.");
                    acceso = false;
                }else{
                    System.out.print("\tIngrese su contraseña: ");
                    String psswrd = scan.next();
                    if(psswrd.equals(u.getContra())){
                        System.out.println("\tBienvenid@ " + u.getNombre() + "!");
                        acceso = true;
                    }
                    else{
                        System.out.println("\tContraseña incorrecta");
                        acceso = false;
                    }
                }
            }catch(Exception e){
                System.out.println("\tOcurrio un error. Pruebe de nuevo.");
                scan.close();
                return;
            }
            
        }while(!acceso);
        
        //scan.close();
        
        //
        // Menu principal
        //
        //
        int op = 0;
        do{
            System.out.print("\n\tMenu Principal\n\t1.- Renta de producto\n\t2.- Devolver producto"
                    + "\n\t3.- Buscar ticket\n\t4.- Agregar nuevo usuario\n\t5.- Agregar nuevo producto"
                    + "\n\t6.- Modificar usuario\n\t7.- Modificar producto\n\t0.- Salir\n\t");
            op = scan.nextInt();
            Scanner scan2 = new Scanner(System.in);
            Scanner info = new Scanner(System.in);
            int opcion;
            switch(op){
                case 0: System.out.println("\n\tQue tenga buen dia.");break;
                case 1:
                    // 
                    //
                    // lectura nuevo cliente
                    String numID = "";
                    nombre = "";
                    telefono = "";
                    servicios = "";
                    System.out.print("\n\tIngrese nombre cliente: ");
                    nombre = info.nextLine();
                    System.out.print("\n\tIngrese telefono de contacto: ");
                    telefono = info.next();
                    do{
                        System.out.print("\n\tIngrese ID del producto: ");
                        id = info.nextInt();
                        //
                        //
                        // busqueda y disponibilidad producto
                        if(id > 100 && id < 200){
                            if(empresa.getPelicula(id).inventario!=0){
                                if(empresa.getPelicula(id).disponibles!=0){
                                    servicios += "P_" + empresa.getPelicula(id).id;
                                    empresa.getPelicula(id).disponibles -= 1;
                                    PrintWriter escritura = null;
                                    try{
                                        escritura = new PrintWriter(archP);
                                    }catch(FileNotFoundException e){
                                        System.out.println("Archivo" + archP.getAbsolutePath() + " no encontrado.");
                                        return;
                                    }
                                    for(Pelicula p : empresa.getPeliculas().values()){
                                        escritura.printf("%s\t%s\t%s\t%s\n", p.getId(), p.getTitulo(), p.getInventario(), p.getDisponibles());
                                    }
                                    escritura.flush();
                                    escritura.close();
                                }else{
                                    System.out.println("\n\tNo hay copias disponibles de este producto\n\t"
                                            + "\n\tPresione enter para continuar...");
                                    info.nextLine();
                                }
                            }else{
                                System.out.println("\n\tEste producto aun no se encuentre disponible\n\t"
                                        + "\n\tPresione enter para continuar...");
                                info.nextLine();
                            }
                        }if(id > 200 && id < 300){
                            if(empresa.getSerie(id).inventario!=0){
                                if(empresa.getSerie(id).disponibles!=0){
                                    servicios += "S_" + empresa.getSerie(id).id;
                                    empresa.getSerie(id).disponibles -= 1;
                                    PrintWriter escritura = null;
                                    try{
                                        escritura = new PrintWriter(archS);
                                    }catch(FileNotFoundException e){
                                        System.out.println("Archivo" + archP.getAbsolutePath() + " no encontrado.");
                                        return;
                                    }
                                    for(Serie s : empresa.getSeries().values()){
                                        escritura.printf("%s\t%s\t%s\t%s\n", s.getId(), s.getTitulo(), s.getInventario(), s.getDisponibles());
                                    }
                                    escritura.flush();
                                    escritura.close();
                                }else{
                                    System.out.println("\n\tNo hay copias disponibles de este producto\n\t"
                                            + "\n\tPresione enter para continuar...");
                                    info.nextLine();
                                }
                            }else{
                                System.out.println("\n\tEste producto aun no se encuentre disponible\n\t"
                                        + "\n\tPresione enter para continuar...");
                                info.nextLine();
                            }
                        }if(id > 300 && id < 400){
                            if(empresa.getVideojuego(id).inventario!=0){
                                if(empresa.getVideojuego(id).disponibles!=0){
                                    servicios += "V_" + empresa.getVideojuego(id).id;
                                    empresa.getVideojuego(id).disponibles -= 1;
                                    PrintWriter escritura = null;
                                    try{
                                        escritura = new PrintWriter(archV);
                                    }catch(FileNotFoundException e){
                                        System.out.println("Archivo" + archP.getAbsolutePath() + " no encontrado.");
                                        return;
                                    }
                                    for(Videojuego v : empresa.getVideojuegos().values()){
                                        escritura.printf("%s\t%s\t%s\t%s\n", v.getId(), v.getTitulo(), v.getInventario(), v.getDisponibles());
                                    }
                                    escritura.flush();
                                    escritura.close();
                                }else{
                                    System.out.println("\n\tNo hay copias disponibles de este producto\n\t"
                                            + "\n\tPresione enter para continuar...");
                                    info.nextLine();
                                }
                            }else{
                                System.out.println("\n\tEste producto aun no se encuentra disponible\n\t"
                                        + "\n\tPresione enter para continuar...");
                                info.nextLine();
                            }
                        }
                        //
                        //
                        // elementos y numero ticket
                        numID = "00" + (empresa.getClientes().size() + 1);
                        System.out.print("\n\t¿Desea agregar otro poducto? 1.- Si 0.- No\n\t");
                        opcion = scan2.nextInt();
                        if(opcion == 1)
                        servicios += ",";
                        
                    }while(opcion!=0);
                    scan2.close();
                    info.close();
                    //
                    //
                    // escritura nuevo cliente
                    System.out.println("Numero de ticket: " + numID);
                    empresa.addCliente(new Cliente(numID, nombre, telefono, servicios));
                    PrintWriter escritura = null;
                    try{
                        escritura = new PrintWriter(archC);
                    }catch(FileNotFoundException e){
                        System.out.println("Archivo" + archC.getAbsolutePath() + " no encontrado.");
                        return;
                    }
                    for(Cliente c : empresa.getClientes().values()){
                        escritura.printf("%s\t%s\t%s\t%s\n", c.getId(), c.getNombre(), c.getTelefono(), c.getServicio());
                    }
                    escritura.flush();
                    break;
                case 2:
                    //
                    //
                    // devolucion producto
                    System.out.print("\n\tIngrese ID producto a devolver: ");
                    id = scan.nextInt();
                    if(id > 100 && id < 200){
                        try{
                            escritura = new PrintWriter(archP);
                            empresa.getPelicula(id).disponibles += 1;
                            System.out.print("\n\tProducto devuelto con exito");
                            System.out.print("\n\tOprima enter para continuar...");
                            scan.nextLine();
                            scan.nextLine();
                                
                            }catch(FileNotFoundException e){
                                System.out.print("\n\tOcurrio un error al devolver producto");
                                System.out.println("\n\tOprima enter para continuar...");
                                scan.nextLine();
                                scan.nextLine();
                                return;
                            }
                            for(Pelicula p : empresa.getPeliculas().values()){
                                escritura.printf("%s\t%s\t%s\t%s\n", p.getId(), p.getTitulo(), p.getInventario(), p.getDisponibles());
                            }
                            escritura.flush();
                    }if(id > 200 && id < 300){
                        try{
                            escritura = new PrintWriter(archS);
                            empresa.getSerie(id).disponibles += 1;
                            System.out.print("\n\tProducto devuelto con exito");
                            System.out.print("\n\tOprima enter para continuar...");
                            scan.nextLine();
                            scan.nextLine();
                                
                            }catch(FileNotFoundException e){
                                System.out.print("\n\tOcurrio un error al devolver producto");
                                System.out.println("\n\tOprima enter para continuar...");
                                scan.nextLine();
                                scan.nextLine();
                                return;
                            }
                            for(Serie s : empresa.getSeries().values()){
                                escritura.printf("%s\t%s\t%s\t%s\n", s.getId(), s.getTitulo(), s.getInventario(), s.getDisponibles());
                            }
                            escritura.flush();
                    }if(id > 300 && id < 400){
                        try{
                            escritura = new PrintWriter(archV);
                            empresa.getVideojuego(id).disponibles += 1;
                            System.out.print("\n\tProducto devuelto con exito");
                            System.out.print("\n\tOprima enter para continuar...");
                            scan.nextLine();
                            scan.nextLine();
                                
                            }catch(FileNotFoundException e){
                                System.out.print("\n\tOcurrio un error al devolver producto");
                                System.out.println("\n\tOprima enter para continuar...");
                                scan.nextLine();
                                scan.nextLine();
                                return;
                            }
                            for(Videojuego v : empresa.getVideojuegos().values()){
                                escritura.printf("%s\t%s\t%s\t%s\n", v.getId(), v.getTitulo(), v.getInventario(), v.getDisponibles());
                            }
                            escritura.flush();
                    }
                    break;
                case 3:
                    //
                    //
                    // busqueda e impresion ticket
                    System.out.print("\tIngrese ID que desea buscar: \n\t");
                    String ID = scan.next();
                    System.out.print("\n\t" + empresa.getCliente(ID).toString());
                    System.out.print("\n\tOprima enter para regresar...");
                    //new Scanner(System.in).nextLine();                    
                    break;
                case 4:
                    //
                    //
                    // escritura nuevo usuario
                    id = empresa.getUsuarios().size() + 1;
                    scan.nextLine();
                    System.out.print("\n\tIngrese nombre nuevo usuario: ");
                    nombre = scan.nextLine();
                    System.out.print("\n\tIngrese nueva contraseña: ");
                    contra = scan.next();
                    estatus = true;
                    estado = "Activo";
                    try{
                        escritura = new PrintWriter(archU);
                        
                        empresa.addUsuario(new Usuario(id, nombre, contra, estatus, estado));
                        System.out.print("\n\tUsuario registrado con exito.");
                        System.out.print("\n\tOprima enter para continuar...");
                        scan.nextLine();
                    }catch(FileNotFoundException e){
                        System.out.println("\n\tOcurrio un error al añadir usuario");
                        System.out.print("\n\tOprima enter para continuar...");
                        scan.nextLine();
                        return;
                    }
                    for(Usuario u : empresa.getUsuarios().values()){
                        escritura.printf("%s\t%s\t%s\t%s\n", u.getId(), u.getNombre(), u.getContra(), u.getEstado());
                    }
                    escritura.flush();
                    break;
                case 5:
                    //
                    //
                    // escritura nuevo producto
                    System.out.print("\n\tElija categoria del nuevo producto:\n\t1.- Pelicula\t2.- Serie\t"
                            + "3.- Videojuego\t0.-Cancelar y regresar\n\t");
                    opcion = scan.nextInt();
                    switch(opcion){
                        case 0: 
                            System.out.print("\n\tCancelado");
                            System.out.print("\n\tOprima enter para continuar...");
                            scan.nextLine();
                            break;
                        case 1: 
                            titulo = "";
                            id = empresa.getPeliculas().size() + 101;
                            System.out.print("\n\tIngrese titulo: ");
                            scan.nextLine();
                            titulo = scan.nextLine();
                            System.out.print("\n\tIngrese nuevo inventario: ");
                            inventario = scan.nextInt();
                            disponibles = inventario;
                            
                            try{
                                escritura = new PrintWriter(archP);

                                empresa.addPelicula(new Pelicula(id, titulo, inventario, disponibles));
                                System.out.print("\n\tProducto registrado con exito.");
                                System.out.println("\n\tOprima enter para continuar...");
                                scan.nextLine();
                                scan.nextLine();
                            }catch(FileNotFoundException e){
                                System.out.print("\n\tOcurrio un error al añadir producto");
                                System.out.println("\n\tOprima enter para continuar...");
                                scan.nextLine();
                                scan.nextLine();
                                return;
                            }
                            for(Pelicula p : empresa.getPeliculas().values()){
                                escritura.printf("%s\t%s\t%s\t%s\n", p.getId(), p.getTitulo(), p.getInventario(), p.getDisponibles());
                            }
                            escritura.flush();
                            break;
                        case 2: 
                            titulo = "";
                            id = empresa.getSeries().size() + 201;
                            System.out.print("\n\tIngrese titulo: ");
                            scan.nextLine();
                            titulo = scan.nextLine();
                            System.out.print("\n\tIngrese nuevo inventario: ");
                            inventario = scan.nextInt();
                            disponibles = inventario;
                            
                            try{
                                escritura = new PrintWriter(archS);

                                empresa.addSerie(new Serie(id, titulo, inventario, disponibles));
                                System.out.print("\n\tProducto registrado con exito.");
                                System.out.println("\n\tOprima enter para continuar...");
                                scan.nextLine();
                                scan.nextLine();
                            }catch(FileNotFoundException e){
                                System.out.print("\n\tOcurrio un error al añadir producto");
                                System.out.println("\n\tOprima enter para continuar...");
                                scan.nextLine();
                                scan.nextLine();
                                return;
                            }
                            for(Serie s : empresa.getSeries().values()){
                                escritura.printf("%s\t%s\t%s\t%s\n", s.getId(), s.getTitulo(), s.getInventario(), s.getDisponibles());
                            }
                            escritura.flush();
                            break;
                        case 3: 
                            titulo = "";
                            id = empresa.getVideojuegos().size() + 301;
                            System.out.print("\n\tIngrese titulo: ");
                            scan.nextLine();
                            titulo = scan.nextLine();
                            System.out.print("\n\tIngrese nuevo inventario: ");
                            inventario = scan.nextInt();
                            disponibles = inventario;
                            
                            try{
                                escritura = new PrintWriter(archV);

                                empresa.addVideojuego(new Videojuego(id, titulo, inventario, disponibles));
                                System.out.print("\n\tProducto registrado con exito.");
                                System.out.println("\n\tOprima enter para continuar...");
                                scan.nextLine();
                                scan.nextLine();
                            }catch(FileNotFoundException e){
                                System.out.print("\n\tOcurrio un error al añadir producto");
                                System.out.println("\n\tOprima enter para continuar...");
                                scan.nextLine();
                                scan.nextLine();
                                return;
                            }
                            for(Videojuego v : empresa.getVideojuegos().values()){
                                escritura.printf("%s\t%s\t%s\t%s\n", v.getId(), v.getTitulo(), v.getInventario(), v.getDisponibles());
                            }
                            escritura.flush();
                            break;
                    }
                    break;
                case 6:
                    //
                    //
                    // modificacion usuario
                    System.out.print("\n\tSolo pueden modificarse usuarios inactivos!!!");
                    System.out.print("\n\tOprima enter para continuar...");
                    scan.nextLine();
                    scan.nextLine();
                    
                    for(Usuario u : empresa.getUsuarios().values()){
                        if(u.isEstatus() == false){
                            System.out.print("\n\tSe encontro el siguiente usuario disponible para modificar:\n\t"
                                    + u.toString());
                            System.out.print("\n\t¿Desea reemplazarlo por un nuevo usuario?"
                                    + "\n\t1.- Si 2.- No\n\t");
                            opcion = scan.nextInt();
                            if(opcion == 1){
                                //scan.nextLine();
                                id = u.getId();
                                scan.nextLine();
                                System.out.print("\n\tIngrese nombre nuevo usuario: ");
                                nombre = scan.nextLine();
                                System.out.print("\n\tIngrese nueva contraseña: ");
                                contra = scan.next();
                                estatus = true;
                                estado = "Activo";
                                try{
                                    escritura = new PrintWriter(archU);
                                    
                                    u.setNombre(nombre);
                                    u.setContra(contra);
                                    u.setEstatus(estatus);
                                    u.setEstado(estado); 
                                    System.out.print("\n\tCambios realizados con exito.");
                                    System.out.print("\n\tOprima enter para continuar...");
                                    scan.nextLine();
                                    scan.nextLine();
                                }catch(FileNotFoundException e){
                                    System.out.println("\n\tOcurrio un error al modificar usuario");
                                    System.out.print("\n\tOprima enter para continuar...");
                                    scan.nextLine();
                                    scan.nextLine();
                                    return;
                                }
                                for(Usuario usr : empresa.getUsuarios().values()){
                                    escritura.printf("%s\t%s\t%s\t%s\n", usr.getId(), usr.getNombre(), usr.getContra(), usr.getEstado());
                                }
                                escritura.flush();
                            }
                        }
                    }
                    
                    break;
                case 7:
                    //
                    //
                    // modificacion producto
                    System.out.print("\n\tIngrese el ID del producto a modificar: ");
                    id = scan.nextInt();
                    if(id > 100 && id < 200){
                        System.out.print("\n\tIngrese nuevo inventario del producto: ");
                        inventario = scan.nextInt();
                        empresa.getPelicula(id).inventario = inventario;
                        empresa.getPelicula(id).disponibles += inventario;
                        try{
                            escritura = new PrintWriter(archP);
                            System.out.print("\n\tCambios realizados con exito.");
                            System.out.print("\n\tOprima enter para continuar...");
                            scan.nextLine();
                            scan.nextLine();
                        }catch(FileNotFoundException e){
                            System.out.println("\n\tOcurrio un error al modificar producto");
                            System.out.print("\n\tOprima enter para continuar...");
                            scan.nextLine();
                            scan.nextLine();
                            return;
                        }
                        for(Pelicula p : empresa.getPeliculas().values()){
                                    escritura.printf("%s\t%s\t%s\t%s\n", p.getId(), p.getTitulo(), p.getInventario(), p.getDisponibles());
                        }
                        escritura.flush();
                    }if(id > 200 && id < 300){
                        System.out.print("\n\tIngrese nuevo inventario del producto: ");
                        inventario = scan.nextInt();
                        empresa.getSerie(id).inventario = inventario;
                        empresa.getSerie(id).disponibles += inventario;
                        try{
                            escritura = new PrintWriter(archS);
                            System.out.print("\n\tCambios realizados con exito.");
                            System.out.print("\n\tOprima enter para continuar...");
                            scan.nextLine();
                            scan.nextLine();
                        }catch(FileNotFoundException e){
                            System.out.println("\n\tOcurrio un error al modificar producto: ");
                            System.out.print("\n\tOprima enter para continuar...");
                            scan.nextLine();
                            scan.nextLine();
                            return;
                        }
                        for(Serie s : empresa.getSeries().values()){
                                    escritura.printf("%s\t%s\t%s\t%s\n", s.getId(), s.getTitulo(), s.getInventario(), s.getDisponibles());
                        }
                        escritura.flush();
                    }if(id > 300 && id < 400){
                        System.out.print("\n\tIngrese nuevo inventario del producto: ");
                        inventario = scan.nextInt();
                        empresa.getVideojuego(id).inventario = inventario;
                        empresa.getVideojuego(id).disponibles += inventario;
                        try{
                            escritura = new PrintWriter(archV);
                            System.out.print("\n\tCambios realizados con exito.");
                            System.out.print("\n\tOprima enter para continuar...");
                            scan.nextLine();
                            scan.nextLine();
                        }catch(FileNotFoundException e){
                            System.out.println("\n\tOcurrio un error al modificar producto");
                            System.out.print("\n\tOprima enter para continuar...");
                            scan.nextLine();
                            scan.nextLine();
                            return;
                        }
                        for(Videojuego v : empresa.getVideojuegos().values()){
                                    escritura.printf("%s\t%s\t%s\t%s\n", v.getId(), v.getTitulo(), v.getInventario(), v.getDisponibles());
                        }
                        escritura.flush();
                    }
                    break;
                default:
                    System.out.println("\tEliga una opcion del menu.");
                
            }
            
        }while(op!=0);
        
    }
}
    
    
   
