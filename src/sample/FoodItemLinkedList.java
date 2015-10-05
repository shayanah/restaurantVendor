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

    /**
     * check if it is empty
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
     * add item
     * @param element
     */
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

    /**
     * search particular element
     * @param element
     * @return
     */
    public FoodItemNode<T> search(T element)
    {
        FoodItemNode result = null  ;
        try
        {
            FoodItemNode current = head;
            while(current != null)
            {
                if(current.getData().equals(element))
                {
                    result = current;
                    return result;
                }
                current = current.getNext();
            }
        }
        catch(Exception e){}

        return result;
    }

    /**
     * update list with specify element
     * @param element
     * @param rElement
     * @return
     */
    public boolean update(T element, T rElement)
    {

        try
        {
            FoodItemNode current = head;
            while(current != null)
            {
                if(current.getData().equals(element))
                {
                    current.setData(rElement);
                    return true;
                }
                current = current.getNext();
            }
        }
        catch(Exception e){}

        return false;
    }

    /**
     * update list at specify index
     * @param element
     * @param rElement
     * @param index
     * @return
     */
    public boolean update(T element, T rElement,int index)
    {

        try
        {
            FoodItemNode current = head;
            int i = 0;
            while(current != null)
            {
                if(current.getData().equals(element) && i == index)
                {
                    current.setData(rElement);
                    return true;
                }
                current = current.getNext();
                i++;
            }
        }
        catch(Exception e){}

        return false;
    }

    /**
     * delete element from list
     * @param element
     */
    public void delete(T element)
    {
        try
        {
            FoodItemNode current = head.getNext();
            FoodItemNode before = head;
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
        catch(Exception e){}

    }

    /**
     * delete at index
     * @param element
     * @param index
     * @return
     */
    public boolean delete(T element,int index)
    {
        try
        {
            FoodItemNode current = head.getNext();
            FoodItemNode before = head;
            int i = 0;
            if(i == index && head.getData().equals(element) )
            {
                head = head.getNext();
                size--;
                return true;
            }
            i++;
            while(current != null && i <= index)
            {
                if(i == index && current.getData().equals(element) )
                {
                    before.setNext(current.getNext());
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

        while( thisCurrent != null && thatCurrent != null &&  thisCurrent.getData().equals(thatCurrent.getData())  )
        {
            thisCurrent = thisCurrent.getNext();
            thatCurrent = thatCurrent.getNext();
            i++;
        }

        if(i == size + 1) return true;
        else
            return false;

    }

    /**
     * copy list to an observable list
     * @return
     */
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
