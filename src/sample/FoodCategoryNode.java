package sample;

import java.io.Serializable;

/**
 * Created by shawn on 9/29/2015.
 */
public class FoodCategoryNode<T> implements Serializable
{
    private T data;
    private FoodCategoryNode next;
    private String name;

    public FoodCategoryNode(T data)
    {
        this.data = data;
        next = null;
        this.name = "";
    }
    public FoodCategoryNode(T data,String name)
    {
        this.data = data;
        next = null;
        this.name = name;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodCategoryNode getNext() {
        return next;
    }
    public void setNext(FoodCategoryNode next) {
        this.next= next;
    }
}
