package Models;

import java.io.File;
import java.util.Scanner;

public class Clave{

    public static boolean isCorrect(String clave){
        boolean correct = true;
        try {
            Scanner s = new Scanner(new File("/home/CommonName/Projects/Java/PedidosFarmaceutica/ass/clave.txt"));
            while(s.hasNextLine()){
                //
            }
            s.close();
        } catch (Exception e){
            e.printStackTrace();    
        }
            System.out.println(correct);
        return correct;
    }
}
