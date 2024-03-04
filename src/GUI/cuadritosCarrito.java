/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author lunar
 */
public class cuadritosCarrito extends JFrame {
    
        Color customColor2 = new Color( 0x63, 0xc9,0xf2);
        JPanel ProCar = new JPanel();
        JPanel contenedor1=new JPanel();
        JPanel contenedor2=new JPanel();
        JLabel infoN = new JLabel("Nombre: ");
        JLabel infoC = new JLabel("xN: ");
        infoN.setFont(new Font("Verdana", Font.ITALIC,10));
        infoC.setFont(new Font("Verdana", Font.ITALIC,10));
        contenedor1.setBounds(5, 0, 50, 20);
        contenedor2.setBounds(5, 20, 20, 20);
        contenedor1.setBackground(customColor2);
        contenedor2.setBackground(customColor2);
        contenedor1.add(infoN);
        contenedor2.add(infoC);
        ProCar.setLayout(null);
        ProCar.setBackground(customColor2);
        ProCar.setBounds(15,100,100,40);
        ProCar.add(contenedor1);
        ProCar.add(contenedor2);
        
}
