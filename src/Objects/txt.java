import java.io.*;

public class txt {
 
    //Creación del nuevo archivo de texto para validar las claves
    public void crear(String nombre){
        File file = new File(nombre);
        try{
            file.createNewFile();
            
        }catch(Exception a){
            System.out.println("No se creo el archivo correctamente"+a.getMessage());
        }
        
    }
    