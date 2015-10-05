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
    private FoodCategoryLinkedList myCategoryLinkedList = null;
    public FoodItemLinkedList<FoodItemClass> foodAuto = null;
    public FoodCategoryLinkedList<FoodItemLinkedList<FoodItemClass>> categoryAuto = null;
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
        myLinkedList.delete(new FoodItemClass("food2", 4.30, 1, "decription1", 10, "specialOrder"));
        System.out.println("Categories:");
        System.out.println(myCategoryLinkedList);
        autogenerateCategory();

        if(myCategoryLinkedList.search(foodAuto) != null)
            System.out.println("found");
        else
            System.out.println("Not found");
        myCategoryLinkedList.delete(foodAuto);
        System.out.println(myCategoryLinkedList);


    }
    public FoodItemLinkedList<FoodItemClass> autogenerateFoods()
    {
        foodAuto = new FoodItemLinkedList<>();
        FoodItemClass item =  new FoodItemClass("food1", 6.00, 1, "decription1", 10, "specialOrder");
        foodAuto.add(item);
        foodAuto.add(new FoodItemClass("food2", 4.30, 1, "decription1", 10, "specialOrder"));
        foodAuto.add(new FoodItemClass("food3", 5.30, 1, "decription1", 10, "specialOrder"));

        return foodAuto;
    }
    public FoodCategoryLinkedList<FoodItemLinkedList<FoodItemClass>> autogenerateCategory()
    {
        autogenerateFoods();
        categoryAuto = new FoodCategoryLinkedList<>();
        categoryAuto.add(foodAuto,"Main Foods");
        FoodItemLinkedList<FoodItemClass> a = new FoodItemLinkedList<>();
        for(int i =0 ; i < 10 ; i++)
        {
            a.add(new FoodItemClass("Some food", i * 2.3, i + 3, "Some descriptions", i ^ 2 + 5, "yes"));
        }
        categoryAuto.add(a,"Desert");
        return  categoryAuto;
    }
    public void excelSimulator(String fileName)
    {

    }


}
