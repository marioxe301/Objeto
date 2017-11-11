

//clase hija

public class Archivo_Usuario extends Objeto {
    
    String extension;

    public Archivo_Usuario(String extension, String nombre, int tamaño) {
        super(nombre, tamaño);
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    
    
    
    
}
