package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.Observable;

/**
 * Created by shawn on 9/29/2015.
 */
public class FoodItemLinkedList<T> implements Serializable
{
    private FoodItemNode head, tail;
    private int size;

    public int getSize() {
        return size;
    }

    public FoodItemNode getHead() {
        return head;
    }

    public FoodItemLinkedList()
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
        FoodItemNode node = new FoodItemNode(element);
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
            FoodItemNode current = head;
            while(current != null)
            {
                if(current.getData().equals(element))
                    return true;
                current = current.getNext();
            }
        }
        catch(Exception e){}

        return false;
    }

    public void delete(T element)
    {
        try
        {
            FoodItemNode current = head.getNext();
            FoodItemNode before = head;
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
        catch(Exception e){}

    }

    public String toString() {
        String list = "";
        FoodItemNode current;
        current = head;
        while (current != null) {
            list += current.getData() + "\n";
            current = current.getNext();
        }
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodItemLinkedList)) return false;

        FoodItemLinkedList<?> that = (FoodItemLinkedList<?>) o;
        if (size != that.size) return false;

        FoodItemNode thisCurrent = head;
        FoodItemNode thatCurrent = that.getHead();
        int i = 1;

        while( i <= size &&  thisCurrent.getData().equals(thatCurrent.getData())  )
        {
            thisCurrent = thisCurrent.getNext();
            thatCurrent = thatCurrent.getNext();
            i++;
        }

        if(i == size + 1) return true;
        else
            return false;

    }

    public ObservableList<T> copy()
    {
        ObservableList<T> temp = FXCollections.observableArrayList();
        try
        {
            FoodItemNode current = head;
            while(current != null)
            {
                temp.add((T) current.getData());
                current = current.getNext();
            }
        }
        catch(Exception e){}
        return temp;
    }


}
