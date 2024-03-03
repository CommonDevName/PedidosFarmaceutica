/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author lunar
 */
public class interfaz extends JFrame{
    private String[] Lista; //aqui van los productos que pondremos
    public interfaz(String tittle){
        
        super("Pedidos Farmacuetica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,600);
        setLayout(new BorderLayout());
        //bienvenida();
        contenido();
        setVisible(true);
    }
    
    public  void bienvenida(){
        //Mensaje de BIENVENIDA y entrada con ingreso de una clave
        JPanel panelBienvenida = new JPanel();
        JPasswordField clave = new JPasswordField(8);
        JLabel ms = new JLabel("Ingrese su Clave de cliente: ");
        panelBienvenida.add(ms);
        ms.setFont(new Font("San-Serif", Font.PLAIN, ms.getFont().getSize()));
        panelBienvenida.add(clave);
        //Personalizacion de opciones
        int entrada = JOptionPane.showOptionDialog(
                null,
                panelBienvenida,
                "Bienvenido",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{"Ingresar","Cancelar"},
                "Aceptar");
        
        if(entrada==JOptionPane.OK_OPTION){
            char[] Contrasena = clave.getPassword();   
            String ClaveString = new String(Contrasena);
            System.out.println("Bienvenido!");// temporalmente mientras se agrega lo del nombre que estara ligada a la clave
        }else{
            if(entrada==JOptionPane.CANCEL_OPTION){
                System.exit(0);
            }
        }
    }
    
    public void contenido(){
        //parte superior con leyenda del nombre
        JPanel contBien = new JPanel();
        add(contBien);
        JLabel bienvenida = new JLabel("Bienvenido! ¿Qué compraremos hoy?");
        bienvenida.setFont(new Font("Consolas",Font.ITALIC|Font.BOLD,20));
        contBien.setBounds(25,8,375,30);
        //contBien.setBorder(new LineBorder(Color.blue));//temporal
        contBien.add(bienvenida);
  
        //seccion para mostras busqueda y productos
        
        //hacer panel para la busqueda tanto etiqueta como menuitem
        JPanel contenedorProductos =new JPanel();
        add(contenedorProductos,BorderLayout.CENTER);//el contenedor esta ubicado en la parte centro del borderLayout del frame
       // contenedorProductos.setBorder(new LineBorder(Color.blue));//temporal
        
        //se agrega un layout al contenedor para busqueda
        contenedorProductos.setLayout(null);     
        JLabel busqueda = new JLabel("Buscar Producto: ");
        busqueda.setFont(new Font("Consolas",Font.BOLD,27));
        JPanel panelBus= new JPanel();
        panelBus.setBounds(10,60,250,40);
        //panelBus.setBorder(new LineBorder(Color.blue));//TEMPORAL
        panelBus.add(busqueda);
        contenedorProductos.add(panelBus);
        
        //creacion del cuadro de busqueda
        
        JTextField itembusqueda = new JTextField (100);
        itembusqueda.addActionListener(new ActionListener (){
        public void actionPerformed(ActionEvent e) {
               
            }
        });
        //creacion de la lista para la busqueda
        JList sugerencias = new JList<>(Lista);
        sugerencias.setVisibleRowCount(10);
        
        
    }
    
    public static void main(String[] args) {
       interfaz s = new interfaz("Pedidos Farmaceutica");
    }
    
}
