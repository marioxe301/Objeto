

//clase hija

import java.util.ArrayList;
import java.util.Scanner;


public class Directorio extends Objeto {
    //hereda clases del padre
    
    String permisos; //Para ver si el usuario quiere Read, Write o Cancelar
    private ArrayList <Objeto> directorio;

    public Directorio(String permisos, ArrayList<Objeto> directorio, String nombre, int tamaño) {
        super(nombre, tamaño);
        this.permisos = permisos;
        this.directorio = directorio;
    }

    public String getPermisos() {
        return permisos;
    }
    
    public Directorio buscarCarpeta(String nombre,Directorio direc){
       if(nombre.equals(direc.nombre)){
           return direc;
       }
       if (direc.getDirectorio() == null){
           return null;
       }else{
            for (int i = 0; i < direc.getDirectorio().size(); i++) {
                Objeto obj = direc.getDirectorio().get(i);
                obj = direc.buscarCarpeta(nombre, direc);
                if(obj != null){
                    return direc;
                }
                
           }
       }
       return null;
    }
    
    public Objeto buscarArchivo(String nombre, Directorio direc){
        for(Objeto a: directorio){
           if((a instanceof Archivo_Sistema && nombre == a.nombre) || (a instanceof Archivo_Usuario && nombre == a.nombre)){
               return a;
           }
        }
        if (direc.getDirectorio() == null){
            
        }
        else{
            for (int i = 0; i < direc.getDirectorio().size(); i++) {
                Objeto obj = direc.getDirectorio().get(i);
                obj = direc.buscarArchivo(nombre, direc);
           }
       }
       return null;
    }
    
    
    public void añadirCarpeta(Directorio direc){
        if(directorio != null){
            directorio.add(direc);
        }else{
            directorio = new ArrayList<>();
            directorio.add(direc);
        }
    }
    
    public void añadirArchivo(String opcion){
        Scanner datos = new Scanner(System.in);
        if(opcion == "AS"){
            directorio.add(new Archivo_Sistema(datos.next(),datos.next(),datos.nextInt()));
        }
        
        if(opcion=="AU"){
            directorio.add(new Archivo_Usuario(datos.next(),datos.next(),datos.nextInt()));
        }
    }
    
    public void setPermisos(int permisos) {
        System.out.println("1 - Read");
        System.out.println("2 - Write");
        System.out.println("3 - Cancel");
        if(permisos == 1)
            this.permisos = "read";
        if(permisos == 2)
            this.permisos = "write";
        if(permisos == 3)
            this.permisos = "cancel";
    }
    
    

    public ArrayList<Objeto> getDirectorio() {
        return directorio;
    }
    
}
