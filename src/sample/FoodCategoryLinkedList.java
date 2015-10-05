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

    /**
     * chech if empty
     * @return
     */
    private boolean isEmpty()
    {
        if(head == null)
            return true;
        else
            return false;
    }

    /**
     * add element
     * @param element
     */
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

    /**
     * add element in spccific category
     * @param element
     * @param name
     */
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

    /**
     * search into list
     * @param element
     * @return
     */
    public FoodCategoryNode<T> search(T element)
    {
        try
        {
            FoodCategoryNode current = head;
            while(current != null)
            {
                if (current.getData().equals(element))
                    return current;
                current = current.getNext();
            }
        }
        catch (Exception e){}

        return null;
    }

    /**
     * update list at specific element
     * @param element
     * @param rElement
     * @return
     */
    public boolean update(T element, T rElement)
    {
        try
        {
            FoodCategoryNode current = head;
            while(current != null)
            {
                if (current.getData().equals(element))
                {
                    current.setData(rElement);
                    return true;
                }
                current = current.getNext();
            }
        }
        catch (Exception e){}

        return false;
    }

    /**
     * updage specific index
     * @param element
     * @param rElement
     * @param index
     * @return
     */
    public boolean update(FoodCategoryNode<T> element, FoodCategoryNode<T> rElement, int index)
    {
        try
        {
            int i = 0;
            FoodCategoryNode current = head;
            while(current != null)
            {
                if (current.getData().equals(element) && i == index)
                {
                    current.setData(rElement.getData());
                    current.setName(rElement.getName());
                    return true;
                }
                current = current.getNext();
                i++;
            }
        }
        catch (Exception e){}

        return false;
    }

    /**
     * delete element
     * @param element
     */
    public void delete(T element)
    {
        try
        {
            FoodCategoryNode current = head;
            FoodCategoryNode before = head;
            if(head.getData().equals(element))
            {
                head = head.getNext();
                size--;
            }

            while(current != null)
            {
                if(current.getData().equals(element))
                {
                    before.setNext(current.getNext());
                    current = current.getNext();
                    size--;
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

    /**
     * delete item form pariticular element
     * @param element
     * @param index
     * @return
     */
    public boolean delete(T element,int index)
    {
        try
        {
            FoodCategoryNode current = head.getNext();
            FoodCategoryNode before = head;
            int i = 0;
            if(i == index && head.getData().equals(element) )
            {
                head = head.getNext();
                size--;
                return true;
            }
            i++;
            while(current != null)
            {
                if(i == index && current.getData().equals(element) )
                {
                    before.setNext(current.getNext());
                    current = current.getNext();
                    size--;
                    return true;

                }
                else
                {
                    before = current;
                    current = current.getNext();
                }
                i++;
            }

        }

        catch(Exception e){}
        return false;
    }

    /**
     *
     * @return fields
     */
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

    /**
     * copy elements into specific
     * @return
     */
    public ObservableList<FoodCategoryNode<T>> copy()
    {
        ObservableList<FoodCategoryNode<T>> temp = FXCollections.observableArrayList();
        try
        {
            FoodCategoryNode current = head;
            while(current != null)
            {

                temp.add( current);
                current = current.getNext();
            }
        }
        catch(Exception e){}
        return temp;
    }



}
