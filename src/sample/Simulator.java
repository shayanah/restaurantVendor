package sample;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by shawn on 9/29/2015.
 */
public class Simulator
{
    private FoodItemLinkedList myLinkedList = null;
    private FoodCategoryLinkedList myCategoryLinkedList;
    public static void saveTheInventory(FoodItemLinkedList myLinkList,String fileName)
    {

        try
        {
            FileOutputStream fileOs = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOs);

            os.writeObject(myLinkList);
            os.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void saveTheCategory(FoodCategoryLinkedList myLinkList,String fileName)
    {

        try
        {
            FileOutputStream fileOs = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOs);

            os.writeObject(myLinkList);
            os.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static FoodCategoryLinkedList readTheCategory(String fileName)
    {
        FoodCategoryLinkedList myLinkedList = null;

        try
        {
            FileInputStream fileIs = new FileInputStream(fileName);
            ObjectInputStream is = new ObjectInputStream(fileIs);

            myLinkedList = (FoodCategoryLinkedList) is.readObject();
            is.close();
        }
        catch(Exception e){}

        return myLinkedList;
    }
    public static FoodItemLinkedList readTheInventory(String fileName)
    {
        FoodItemLinkedList myLinkedList = null;

        try
        {
            FileInputStream fileIs = new FileInputStream(fileName);
            ObjectInputStream is = new ObjectInputStream(fileIs);

            myLinkedList = (FoodItemLinkedList) is.readObject();
            is.close();
        }
        catch(Exception e){}

        return myLinkedList;
    }
    //run in code for the first time
    public Simulator(){}
    public void binaryFileSimulator(String foodFile)
    {
        myLinkedList = readTheInventory(foodFile);
        System.out.println(myLinkedList);
    }
    public void binaryFileSimulator(String foodFile, String categoryFile)
    {
        myLinkedList = readTheInventory(foodFile);
        myCategoryLinkedList = readTheCategory(categoryFile);
        System.out.println(myLinkedList);
        System.out.println("Categories:");
        System.out.println(myCategoryLinkedList);
    }
    public void excelSimulator(String fileName)
    {

    }


}
