package sample;

import java.io.Serializable;

/**
 * Created by shawn on 9/29/2015.
 */
public class FoodItemNode<T> implements Serializable
{
    private T data;
    private FoodItemNode next;

    public FoodItemNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public FoodItemNode getNext() {
        return next;
    }

    public void setNext(FoodItemNode next) {
        this.next = next;
    }
}
