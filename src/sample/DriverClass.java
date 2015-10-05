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
        simulator.autogenerateCategory();
        simulator.saveTheInventory(simulator.foodAuto,"out.bin");
        simulator.saveTheCategory(simulator.categoryAuto,"category.bin");
        simulator.readExcel("test.xls");
        simulator.writeExcel("test.xls");
    }
    public static void main(String [] args)
    {

        //gui
       // new DriverClass(args);
        //run simulator binary file

        new DriverClass("out.bin","category.bin");


        //run simulator excel file
    }

}
