package Models;

public class Item{
    
    private Medicamento medicamento;
    private int cantidad;
    private int subtotal;

    public Item(Medicamento medicamento, int cantidad){
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        subtotal = (medicamento.getPrecio()*cantidad);
    }

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getSubtotal() {
		return subtotal;
	}

}
