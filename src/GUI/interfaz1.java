package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GUI.CuadritosCarrito;
import Models.*;

public class interfaz1 extends JFrame implements interfazAcciones {
    private ListaMedicamentos listaMed = new ListaMedicamentos();
    private Carrito carroDeCompras = new Carrito(); 
    private CuadritosCarrito[] cuadritos = new CuadritosCarrito[10];
    private int iCuadrito = 0;
    public interfaz1(String tittle) {
        super("Pedidos Farmacéutica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setLayout(null); // Establecer el layout como null
        contenido();
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("/home/CommonName/Projects/Java/PedidosFarmaceutica/ass/pedidos/pendiente/CarritoPendiente"));
            carroDeCompras = (Carrito)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    public void contenido() {
        //colores 
        Color customColor = new Color(0x7f, 0xb8, 0xae);
        Color customColor1 = new Color(0xed, 0xec, 0xb3);
        UIManager.put("OptionPane.background", customColor1);
        UIManager.put("Panel.background", customColor1);
        
        // Parte superior con leyenda del nombre
        JPanel a = new JPanel();
        a.setBounds(0, 0, 3000, 40);
        a.setBackground(customColor);
        
        JLabel bienvenida = new JLabel("Bienvenido! ¿Qué compraremos hoy?");
        bienvenida.setFont(new Font("Inconsolata", Font.ITALIC | Font.BOLD, 20));
        bienvenida.setForeground(Color.WHITE);
        bienvenida.setBounds(35, 8, 450, 30);
        add(bienvenida);

        // Creación del panel para la búsqueda
        JPanel b =new JPanel();
        b.setBackground(customColor);
        b.setBounds(0, 60, 800, 50);
        
        JPanel panelBus = new JPanel();
        JLabel busqueda = new JLabel("Buscar Producto: ");
        busqueda.setFont(new Font("Inconsolata", Font.BOLD, 25));
        busqueda.setForeground(Color.WHITE);
        panelBus.add(busqueda);
        panelBus.setBackground(customColor);
        panelBus.setBounds(35, 65, 250, 40);  
        add(a);
        add(panelBus);

        // Creación del cuadro de búsqueda
        JTextField itembusqueda = new JTextField(10);
        itembusqueda.setBounds(285, 65, 250, 40);
        add(itembusqueda);

        // Creación de la lista para la búsqueda
        ImageIcon lupa = new ImageIcon(getClass().getResource("/home/CommonName/Projects/Java/PedidosFarmaceutica/ass/iconos/lupa.png"));
        Image resizedImageL = lupa.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon resizedIconL = new ImageIcon(resizedImageL);
        JLabel imagenL=new JLabel(resizedIconL);
        imagenL.setBounds(535, 66, 40, 40);
        add(imagenL);
        
        JList<String> sugerencias = new JList<>();
        sugerencias.setVisibleRowCount(5);
        sugerencias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sugerencias.setVisible(false);
        JScrollPane scrollpaneList = new JScrollPane(sugerencias);
        scrollpaneList.setBounds(285, 105, 250, 80);
        scrollpaneList.setVisible(false);
        add(scrollpaneList);
        
        
        itembusqueda.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e) {

                String text = itembusqueda.getText().toLowerCase();
                DefaultListModel<String> list = new DefaultListModel<>();
                for (Medicamento med : listaMed.getMedicamentos()) {
                    if (med.getNombreComercial().toLowerCase().contains(text)) {
                    list.addElement(med.getNombreComercial());
                    }
                }  
                sugerencias.setModel(list);
                sugerencias.setVisible(!list.isEmpty());
                scrollpaneList.setVisible(!list.isEmpty());
            }      
        });  

        //creacion del area productos 
        JPanel productos = new JPanel();
        productos.setLayout(new GridLayout(5, 1));
        JLabel nombre = new JLabel();
        JLabel sustancias = new JLabel();
        JLabel laboratorio = new JLabel();
        JLabel fraccion = new JLabel();
        JLabel precio = new JLabel();
        productos.add(nombre);
        productos.add(sustancias);
        productos.add(laboratorio);
        productos.add(fraccion);
        productos.add(precio);
        productos.setBackground(customColor);
        productos.setBounds(35, 210, 550, 250);
        add(productos);
        
        sugerencias.addListSelectionListener(new ListSelectionListener() {
            
            public void valueChanged(ListSelectionEvent e){
                String medName = (String)((JList)e.getSource()).getSelectedValue();
                ObjectInputStream ois;
                try{
                    ois = new ObjectInputStream(new FileInputStream("/home/CommonName/Projects/Java/PedidosFarmaceutica/ass/medicamentos/"+medName));
                    Medicamento med = (Medicamento)ois.readObject();
                    nombre.setText(med.getNombreComercial());
                    sustancias.setText(med.getSustanciasactivas());
                    laboratorio.setText(med.getLaboratorio());
                    fraccion.setText(med.getFraccion());
                    precio.setText(Integer.toString(med.getPrecio()));
                    ois.close();
                } catch (Exception ei) {
                    System.err.println(ei.getStackTrace());
                }

            }
        });

        //cracion de botones de compra
        JButton btnAnadir = new JButton("Añadir al Carrito");
        JButton btnComprar1 = new JButton("Comprar");
        btnAnadir.setBackground(customColor1);;
        btnAnadir.setBounds(50,507,128,25);
        btnComprar1.setBackground(customColor1);
        btnComprar1.setBounds(400,507,128,25);
        add(btnComprar1);
        add(btnAnadir);
               
        //Creación del area carrito
        ImageIcon car =new ImageIcon(getClass().getResource("/home/CommonName/Projects/Java/PedidosFarmaceutica/ass/iconos/carrito.png"));
        Image resizedImageCar = car.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedIconcar = new ImageIcon(resizedImageCar);
                
        JPanel carrito= new JPanel();
        JLabel txtCarrito =new JLabel("Carrito");
        JLabel imagen=new JLabel(resizedIconcar);
        imagen.setBounds(15, 12, 40, 40);
        txtCarrito.setFont(new Font("Inconsolata", Font.ITALIC|Font.BOLD,25));
        txtCarrito.setForeground(Color.white);
        txtCarrito.setHorizontalAlignment(SwingConstants.CENTER);
        txtCarrito.setVerticalAlignment(SwingConstants.CENTER);
        txtCarrito.setBounds(70,25,100,25);
        carrito.setLayout(null);
        carrito.setBackground(customColor);
        carrito.setBounds(620, 60, 240, 485);
        carrito.add(imagen);
        carrito.add(txtCarrito);
        
        
        //GRID DEL CARRITO    
        JPanel ContProCa =new JPanel();
        ContProCa.setBounds(10, 60, 219, 338);
        ContProCa.setLayout(new GridLayout(5, 2));
        ContProCa.setBackground(customColor1);
        carrito.add(ContProCa);
        
        //Botones del Carrito
        JButton btnLimpiar = new JButton("Limpiar el Carrito");
        JButton btnComprar = new JButton("Comprar todo el carrito");
        btnLimpiar.setBackground(customColor1);
        btnLimpiar.setBounds(55,410,140,25);
        btnComprar.setBackground(customColor1);
        btnComprar.setBounds(40,445,170,25);       
        carrito.add(btnLimpiar);
        carrito.add(btnComprar);
        
        add(carrito);
        
        //accion para añadir carrito 
        btnAnadir.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e) {
                ObjectInputStream ois;
                ObjectOutputStream oos;
                String medName = nombre.getText();
                try{
                    ois = new ObjectInputStream(new FileInputStream("/home/CommonName/Projects/Java/PedidosFarmaceutica/ass/medicamentos/"+medName));
                    oos = new ObjectOutputStream(new FileOutputStream("/home/CommonName/Projects/Java/PedidosFarmaceutica/ass/pedidos/pendiente/CarritoPendiente"));
                    Medicamento med = (Medicamento)ois.readObject();
                    Item item = new Item(med, 1);
                    carroDeCompras.agregar(item);
                    oos.writeObject(carroDeCompras);
                    cuadritos[iCuadrito] = new CuadritosCarrito(med.getNombreComercial(), "1");
                    ContProCa.add(cuadritos[iCuadrito]);
                    iCuadrito++;
                    ois.close();
                } catch (Exception ei) {
                    System.err.println(ei.getStackTrace());
                }
            }
   
        });
        
        //accion comprar
        ImageIcon icono = new ImageIcon(getClass().getResource("/home/CommonName/Projects/Java/PedidosFarmaceutica/ass/iconos/enviado.png"));
        Image resizedImage = icono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
        btnComprar1.addActionListener(e -> {
            int respuesta=JOptionPane.showConfirmDialog(null, "¿Confirmar pedido?", "Proceso de Pedido", JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION){
                ObjectInputStream ois;
                ObjectOutputStream oos;
                String medName = nombre.getText();
                try{
                    ois = new ObjectInputStream(new FileInputStream("/home/CommonName/Projects/Java/PedidosFarmaceutica/ass/medicamentos/"+medName));
                    oos = new ObjectOutputStream(new FileOutputStream("/home/CommonName/Projects/Java/PedidosFarmaceutica/ass/pedidos/Pedido"));
                    Medicamento med = (Medicamento)ois.readObject();
                    Item item = new Item(med, 1);
                    carroDeCompras.agregar(item);
                    oos.writeObject(carroDeCompras);
                    ois.close();
                } catch (Exception ei) {
                    System.err.println(ei.getStackTrace());
                }
                JOptionPane.showMessageDialog(null, "Pedido enviado", "", JOptionPane.PLAIN_MESSAGE, resizedIcon);
            }
        });
        
        btnComprar.addActionListener(e -> {
            int respuesta=JOptionPane.showConfirmDialog(null, "¿Confirmar pedido?", "Proceso de Pedido", JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION){
                ObjectInputStream ois;
                ObjectOutputStream oos;
                String medName = nombre.getText();
                try{
                    ois = new ObjectInputStream(new FileInputStream("/home/CommonName/Projects/Java/PedidosFarmaceutica/ass/medicamentos/"+medName));
                    oos = new ObjectOutputStream(new FileOutputStream("/home/CommonName/Projects/Java/PedidosFarmaceutica/ass/pedidos/Pedido"));
                    Medicamento med = (Medicamento)ois.readObject();
                    Item item = new Item(med, 1);
                    carroDeCompras.agregar(item);
                    oos.writeObject(carroDeCompras);
                    ois.close();
                } catch (Exception ei) {
                    System.err.println(ei.getStackTrace());
                }
                JOptionPane.showMessageDialog(null, "Pedido enviado", "", JOptionPane.PLAIN_MESSAGE, resizedIcon);
            }
        });
        
        //Accion Limpiar
        
        btnLimpiar.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < carroDeCompras.getItems().length; i++){
                    carroDeCompras.getItems()[i] = null;
                    cuadritos[i] = null;
                    iCuadrito--;
                }
                
            
            }
   
        });
        
        add(b);
    }
    
    /*public static void main(String[] args) { 
        // Mensaje de BIENVENIDA y entrada con ingreso de una clave
        JPanel panelBienvenida = new JPanel();
        JPasswordField clave = new JPasswordField(8);
        JLabel ms = new JLabel("Ingrese su Clave de cliente: ");
        panelBienvenida.add(ms);
        ms.setFont(new Font("Verdana", Font.PLAIN, ms.getFont().getSize()));
        
        panelBienvenida.add(clave);
        

        // Personalización de opciones
        int entrada = JOptionPane.showOptionDialog(
                null,
                panelBienvenida,
                "Bienvenido",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{"Ingresar", "Cancelar"},
                "Aceptar");
        
        

        if (entrada==JOptionPane.OK_OPTION){
            interfaz1 s =new interfaz1("Pedidos Farmacéutica");
        }
        if (entrada == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        }
        
    }*/

    @Override
    public void verificarContrasena() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void anadirCarrito() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void limpiarCarrito() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
