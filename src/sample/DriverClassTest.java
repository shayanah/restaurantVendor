package sample;

/**
 * Created by shawn on 9/29/2015.
 */
public class DriverClassTest
{
    DriverClassTest(){}
    DriverClassTest(int a){}
    DriverClassTest(int a, int b){}
    public static void main(String [] args)
    {
        //run GUI
        FoodItemLinkedList<FoodItemClass> a = new FoodItemLinkedList<>();
        FoodItemClass item =  new FoodItemClass("food1", 5.00, 1, "decription1", 10, "specialOrder");
        a.add(item);
        a.add(new FoodItemClass("food2", 4.30, 1, "decription1", 10, "specialOrder"));
        FoodItemLinkedList<FoodItemClass> c = new FoodItemLinkedList<>();
        c.add(item);
        c.add(new FoodItemClass("food2", 4.30, 1, "decription1", 10, "specialOrder"));

        System.out.println(a);
        if( a.search(new FoodItemClass("food1", 5.00, 1, "decription1", 10, "specialOrder")) != null)
            System.out.println("a is right");

        FoodCategoryLinkedList<FoodItemLinkedList<FoodItemClass>> b = new FoodCategoryLinkedList();
        b.add(a,"main");
        System.out.println(b);

        if( b.search(a) != null)
            System.out.println("b is right");
        if( b.search(c) != null)
            System.out.println("b is right lvl2");
        //run
    }
}
