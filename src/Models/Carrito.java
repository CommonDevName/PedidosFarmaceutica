package Models;

import java.io.Serializable;
import java.util.ArrayList;

import Models.Item;

public class Carrito implements Serializable{
    
    private static ArrayList<Item> items = new ArrayList<>();
    private short cantidadItems = 0;
    private int total = 0;
    
    public Carrito(){     
    } 

    public void agregar(Item item){
        items.addLast(item);
        cantidadItems++;
        total = 0;
        short i = 0;
        while(i <= cantidadItems){
            total = total + items.get(i).getSubtotal();
        }
    }

    public Item[] getItems(){
        return ((Item[])items.toArray());
    }

    public short getCantidadItems(){
        return cantidadItems;
    }

    public int getTotal(){
        return total;
    }
}
