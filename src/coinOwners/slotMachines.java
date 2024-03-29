package coinOwners;

import java.util.ArrayList;
import java.util.List;

public class slotMachines {
    public int coinAmount;
    public static slotMachines Red = new slotMachines(4);
    public static slotMachines Green = new slotMachines(4);
    public static slotMachines Blue = new slotMachines(4);
    public static slotMachines Black = new slotMachines(4);
    public static slotMachines White = new slotMachines(4);
    public static slotMachines Bank = new slotMachines(5);

    public static ArrayList<slotMachines> slotMachinesList= new ArrayList<>(List.of(Red,Green,Blue,Black,White,Bank));
    public slotMachines(int coinAmount){
        this.coinAmount = coinAmount;
        }

    }

