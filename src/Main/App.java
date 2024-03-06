package Main;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GUI.interfaz1;
import static Models.Clave.isCorrect;

public class App{

    public static void main(String[] args){
        //TODO: init Models, GUI & Drivers. 
        // Mensaje de BIENVENIDA y entrada con ingreso de una clave
        JPanel bienvenida = new JPanel();
        JPasswordField clave = new JPasswordField(8);
        JLabel ms = new JLabel("Ingrese su Clave de cliente: ");
        bienvenida.add(ms);
        ms.setFont(new Font("Verdana", Font.PLAIN, ms.getFont().getSize()));
        bienvenida.add(clave);
        
        // Personalización de opciones
        int entrada = JOptionPane.showOptionDialog(
        null,
        bienvenida,
        "Bienvenido",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE,
        null,
        new Object[]{"Ingresar", "Cancelar"},
        "Aceptar");

        if (entrada==JOptionPane.OK_OPTION){
            if(isCorrect(clave.getText())){
                    interfaz1 s =new interfaz1("Pedidos Farmacéutica");
            }
        }
        if (entrada == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        }
        
    }

    private void initModels(){

    }

    private void initUI(){

    }

    private void initDrivers(){

    }
}
