import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaz1 extends JFrame {
    private String[] Lista = {"Producto 1", "Producto 2", "Producto 3", "Producto 4", "Producto 5", "Producto 6", "Producto 7", "Producto 8", "Producto 9", "Producto 10"};

    public interfaz1(String tittle) {
        super("Pedidos Farmacéutica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(null); // Establecer el layout como null
        bienvenida();
        contenido();
        setVisible(true);
    }

    public void bienvenida() {
        // Mensaje de BIENVENIDA y entrada con ingreso de una clave
        JPanel panelBienvenida = new JPanel();
        JPasswordField clave = new JPasswordField(8);
        JLabel ms = new JLabel("Ingrese su Clave de cliente: ");
        panelBienvenida.add(ms);
        ms.setFont(new Font("San-Serif", Font.PLAIN, ms.getFont().getSize()));
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

        if (entrada == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        }
    }

    public void contenido() {
        // Parte superior con leyenda del nombre
        JLabel bienvenida = new JLabel("Bienvenido! ¿Qué compraremos hoy?");
        bienvenida.setFont(new Font("Consolas", Font.ITALIC | Font.BOLD, 20));
        bienvenida.setBounds(25, 8, 375, 30);
        add(bienvenida);

        // Creación del panel para la búsqueda
        JPanel panelBus = new JPanel();
        JLabel busqueda = new JLabel("Buscar Producto: ");
        busqueda.setFont(new Font("Consolas", Font.BOLD, 27));
        panelBus.add(busqueda);
        panelBus.setBounds(10, 60, 250, 40);
        add(panelBus);

        // Creación del cuadro de búsqueda
        JTextField itembusqueda = new JTextField(10);
        itembusqueda.setBounds(260, 60, 250, 40);
        add(itembusqueda);

        // Creación de la lista para la búsqueda
        JList<String> sugerencias = new JList<>(Lista);
        sugerencias.setVisibleRowCount(5);
        sugerencias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sugerencias.setVisible(false);
        JScrollPane scrollpaneList = new JScrollPane(sugerencias);
        scrollpaneList.setBounds(260, 100, 250, 80);
        scrollpaneList.setVisible(false);
        add(scrollpaneList);
        
        
        itembusqueda.addActionListener(new ActionListener (){
        public void actionPerformed(ActionEvent e) {
      
            String text = itembusqueda.getText().toLowerCase();
            DefaultListModel<String> model = new DefaultListModel<>();
            for (String suggestion : Lista) {
                if (suggestion.toLowerCase().contains(text)) {
                model.addElement(suggestion);
                }
            }  
            sugerencias.setModel(model);
            sugerencias.setVisible(!model.isEmpty());
            scrollpaneList.setVisible(!model.isEmpty());
            
        }
        });
        
        //creacion del area productos 
        JPanel productos = new JPanel();
        productos.setBackground(Color.LIGHT_GRAY);
        productos.setBounds(35, 210, 550, 250);
        add(productos);
        
        //cracion de botones de compra
        JButton btnAnadir = new JButton("Añadir al Carrito");
        JButton btnComprar1 = new JButton("Comprar");
        btnAnadir.setBounds(50,507,128,25);
        btnComprar1.setBounds(400,507,128,25);
        add(btnComprar1);
        add(btnAnadir);
               
        //Creación del area carrito
        JPanel carrito= new JPanel();
        JLabel txtCarrito =new JLabel("Carrito");
        txtCarrito.setFont(new Font("Consolas", Font.ITALIC|Font.BOLD,25));
        txtCarrito.setHorizontalAlignment(SwingConstants.CENTER);
        txtCarrito.setVerticalAlignment(SwingConstants.CENTER);
        txtCarrito.setBounds(70,25,100,25);
        carrito.setLayout(null);
        carrito.setBackground(Color.LIGHT_GRAY);
        carrito.setBounds(620, 40, 240, 485);
        carrito.add(txtCarrito);
        
        
        //GRID DEL CARRITO    
        JPanel ContProCa =new JPanel();
        ContProCa.setBounds(10, 60, 219, 338);
        ContProCa.setLayout(new GridLayout());
        ContProCa.setBackground(Color.GRAY);
        carrito.add(ContProCa);
        
        //Botones del Carrito
        JButton btnLimpiar = new JButton("Limpiar el Carrito");
        JButton btnComprar = new JButton("Comprar todo el carrito");
        btnLimpiar.setBounds(55,410,140,25);
        btnComprar.setBounds(40,445,170,25);       
        carrito.add(btnLimpiar);
        carrito.add(btnComprar);
        
        add(carrito);
        
        //Creacion de Botones
        
        
        
    }
    
    public static void main(String[] args) {
        interfaz1 s =new interfaz1("Pedidos Farmacéutica");
    }
}

