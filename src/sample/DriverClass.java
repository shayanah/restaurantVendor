package sample;

/**
 * Created by shawn on 9/29/2015.
 */
public class DriverClass
{
    public DriverClass(String[] args)
    {
        //run GUI
        Main.main(args);
    }
    public DriverClass(String fileName)
    {
        Simulator simulator = new Simulator();
        simulator.binaryFileSimulator(fileName);
    }
    public DriverClass(String food,String category)
    {
        Simulator simulator = new Simulator();
        simulator.binaryFileSimulator(food,category);
    }
    public static void main(String [] args)
    {

        //gui
       // new DriverClass(args);
        //run simulator binary file
        FoodItemLinkedList<FoodItemClass> a = new FoodItemLinkedList<>();
        FoodItemClass item =  new FoodItemClass("food1", 6.00, 1, "decription1", 10, "specialOrder");
        a.add(item);
        a.add(new FoodItemClass("food2", 4.30, 1, "decription1", 10, "specialOrder"));
        FoodCategoryLinkedList<FoodItemLinkedList<FoodItemClass>> b = new FoodCategoryLinkedList();
        b.add(a,"Main Foods");
        Simulator simulator = new Simulator();
        simulator.saveTheInventory(a,"out.bin");
        simulator.saveTheCategory(b,"category.bin");
        new DriverClass("out.bin","category.bin");
        //new DriverClass("out.bin");
       // FoodItemLinkedList<FoodItemClass> b = simulator.readTheInventory("out.bin");
       // b.add(item);
        //b.add(item);
        //simulator.saveTheInventory(b);

        //run simulator excel file
    }

}
