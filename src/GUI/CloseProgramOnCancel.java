import javax.swing.JOptionPane;

public class CloseProgramOnCancel {
    public static void main(String[] args) {
        int option = JOptionPane.showOptionDialog(
            null,
            "¿Estás seguro de que quieres salir?",
            "Salir del Programa",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE,
            null,
            new Object[]{"Sí", "Cancelar"},
            "Cancelar"
        );

        if (option == JOptionPane.YES_OPTION) {
            System.exit(0); // Cierra el programa
        } else {
            // El usuario eligió cancelar, no se hace nada
        }
    }
}
