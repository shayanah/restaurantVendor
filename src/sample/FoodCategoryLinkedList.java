package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

/**
 * Created by shawn on 9/29/2015.
 */
public class FoodCategoryLinkedList<T> implements Serializable
{

    private FoodCategoryNode head, tail;
    private int size;

    public FoodCategoryLinkedList()
    {
        head = null;
        tail = null;
        size = 0 ;
    }
    private boolean isEmpty()
    {
        if(head == null)
            return true;
        else
            return false;
    }
    public void add(T element)
    {
        FoodCategoryNode node = new FoodCategoryNode(element);
        if(isEmpty())
            head = node;
        else
            tail.setNext(node);
        tail = node;
        size++;
    }
    public void add(T element,String name)
    {
        FoodCategoryNode node = new FoodCategoryNode(element,name);
        if(isEmpty())
            head = node;
        else
            tail.setNext(node);
        tail = node;
        size++;

    }
    public boolean search(T element)
    {
        try
        {
            FoodCategoryNode current = head;
            while(current != null)
            {
                if (current.getData().equals(element))
                    return true;
                current = current.getNext();
            }
        }
        catch (Exception e){}

        return false;
    }

    public void delete(T element)
    {
        try
        {
            FoodCategoryNode current = head;
            FoodCategoryNode before = head;
            if(head.getData().equals(element))
                head = head.getNext();

            while(current != null)
            {
                if(current.getData().equals(element))
                {
                    before.setNext(current.getNext());
                    current = current.getNext();
                }
                else
                {
                    before = current;
                    current = current.getNext();
                }

            }
        }
        catch (Exception e){}


    }

    public String toString()
    {
        String list = "";
        FoodCategoryNode current;
        current = head;
        while (current != null)
        {
            list += current.getName() + "\n";
            list += current.getData() + " ";
            current = current.getNext();
        }
        return list;
    }

    public ObservableList<T> copy()
    {
        ObservableList<T> temp = FXCollections.observableArrayList();
        try
        {
            FoodCategoryNode current = head;
            while(current != null)
            {

                temp.add((T)current.getData());
                current = current.getNext();
            }
        }
        catch(Exception e){}
        return temp;
    }

}
