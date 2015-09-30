package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.ListView;
import javafx.scene.control.*;

public class Controller implements Initializable{
    public ListView<FoodItemClass> list;
    public FoodItemLinkedList<FoodItemClass> foods = new FoodItemLinkedList<>();
    public FoodCategoryLinkedList<FoodItemLinkedList<FoodItemClass>> category = new FoodCategoryLinkedList<>();
    //public ListView<String> list;
   // public ObservableList<String> items = FXCollections.observableArrayList();
    public ObservableList<FoodItemClass> items = FXCollections.observableArrayList();
    public ObservableList<FoodItemLinkedList<FoodItemClass> > cItems = FXCollections.observableArrayList();
    public TextField addName,addPrice,addQuantity,addDescription,addSpecialOrder,addSize,
            searchName,searchPrice,searchQuantity,searchDescription,searchSize,searchSpecialOrder
            ,deleteName,deletePrice,deleteQuantity,deleteDescription,deleteSize,deleteSpecialOrder
            ,updateName,updatePrice,updateQuantity,updateDescription,updateSize,updateSpecialOrder;

    public Label submitlbl;
    public Button submitAdd,submitSearch, submitDelete, submitUpdate ;
    public TextField cNameText;
    public ListView<FoodItemLinkedList<FoodItemClass>> cList;
    public void showList()
    {
        cNameText.setDisable(true);
        FoodItemClass item =  new FoodItemClass("food1", 5.00, 1, "decription1", 10, "specialOrder");
        foods.add(item);
        foods.add(new FoodItemClass("food1", 5.00, 1, "decription1", 10, "specialOrder"));
        items = foods.copy();
        //items.add(item);
        //items.add(new FoodItemClass("food1", 5.00, 1, "decription1", 10, "specialOrder"));
        //items.add("dsf");
        //items.add("dssdff");
        list.setItems(items);
        //listBox.(new FoodItemClass("food1", 5.00, 1, "decription1", 10, "specialOrder"));

        category.add(foods,"main foods");
        cItems = category.copy();
        cList.setItems(cItems);
    }
    public void disableAll()
    {
        submitAdd.setDisable(true);
        submitSearch.setDisable(true);
        submitDelete.setDisable(true);
        submitUpdate.setDisable(true);
        addName.setDisable(true); addPrice.setDisable(true);addQuantity.setDisable(true);
        addDescription.setDisable(true);addSpecialOrder.setDisable(true);addSize.setDisable(true);

        searchName.setDisable(true);searchPrice.setDisable(true);searchQuantity.setDisable(true);
        searchDescription.setDisable(true);searchSize.setDisable(true);searchSpecialOrder.setDisable(true);

        deleteName.setDisable(true);deletePrice.setDisable(true);deleteQuantity.setDisable(true);
        deleteDescription.setDisable(true);deleteSize.setDisable(true);deleteSpecialOrder.setDisable(true);

        updateName.setDisable(true);updatePrice.setDisable(true);updateQuantity.setDisable(true);
        updateDescription.setDisable(true);
        updateSize.setDisable(true);updateSpecialOrder.setDisable(true);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        showList();
    }

    public void addFunc(ActionEvent actionEvent)
    {
        submitAdd.setDisable(false);
        submitSearch.setDisable(true);
        submitDelete.setDisable(true);
        submitUpdate.setDisable(true);

        addName.setDisable(false); addPrice.setDisable(false);addQuantity.setDisable(false);
        addDescription.setDisable(false);addSpecialOrder.setDisable(false);addSize.setDisable(false);

        searchName.setDisable(true);searchPrice.setDisable(true);searchQuantity.setDisable(true);
        searchDescription.setDisable(true);searchSize.setDisable(true);searchSpecialOrder.setDisable(true);

        deleteName.setDisable(true);deletePrice.setDisable(true);deleteQuantity.setDisable(true);
        deleteDescription.setDisable(true);deleteSize.setDisable(true);deleteSpecialOrder.setDisable(true);

        updateName.setDisable(true);updatePrice.setDisable(true);updateQuantity.setDisable(true);
        updateDescription.setDisable(true);
        updateSize.setDisable(true);updateSpecialOrder.setDisable(true);
    }

    public void searchFunc(ActionEvent actionEvent)
    {
        submitAdd.setDisable(true);
        submitSearch.setDisable(false);
        submitDelete.setDisable(true);
        submitUpdate.setDisable(true);

        addName.setDisable(true); addPrice.setDisable(true);addQuantity.setDisable(true);
        addDescription.setDisable(true);addSpecialOrder.setDisable(true);addSize.setDisable(true);

        searchName.setDisable(false);searchPrice.setDisable(false);searchQuantity.setDisable(false);
        searchDescription.setDisable(false);searchSize.setDisable(false);searchSpecialOrder.setDisable(false);

        deleteName.setDisable(true);deletePrice.setDisable(true);deleteQuantity.setDisable(true);
        deleteDescription.setDisable(true);deleteSize.setDisable(true);deleteSpecialOrder.setDisable(true);

        updateName.setDisable(true);updatePrice.setDisable(true);updateQuantity.setDisable(true);
        updateDescription.setDisable(true);
        updateSize.setDisable(true);updateSpecialOrder.setDisable(true);
    }
    public void deleteFunc(ActionEvent actionEvent)
    {
        submitAdd.setDisable(true);
        submitSearch.setDisable(true);
        submitDelete.setDisable(false);
        submitUpdate.setDisable(true);

        addName.setDisable(true); addPrice.setDisable(true);addQuantity.setDisable(true);
        addDescription.setDisable(true);addSpecialOrder.setDisable(true);addSize.setDisable(true);

        searchName.setDisable(true);searchPrice.setDisable(true);searchQuantity.setDisable(true);
        searchDescription.setDisable(true);searchSize.setDisable(true);searchSpecialOrder.setDisable(true);

        deleteName.setDisable(false);deletePrice.setDisable(false);deleteQuantity.setDisable(false);
        deleteDescription.setDisable(false);deleteSize.setDisable(false);deleteSpecialOrder.setDisable(false);

        updateName.setDisable(true);updatePrice.setDisable(true);updateQuantity.setDisable(true);
        updateDescription.setDisable(true);
        updateSize.setDisable(true);updateSpecialOrder.setDisable(true);
    }
    public void updateFunc(ActionEvent actionEvent)
    {
        submitAdd.setDisable(true);
        submitSearch.setDisable(true);
        submitDelete.setDisable(true);
        submitUpdate.setDisable(false);

        addName.setDisable(true); addPrice.setDisable(true);addQuantity.setDisable(true);
        addDescription.setDisable(true);addSpecialOrder.setDisable(true);addSize.setDisable(true);

        searchName.setDisable(true);searchPrice.setDisable(true);searchQuantity.setDisable(true);
        searchDescription.setDisable(true);searchSize.setDisable(true);searchSpecialOrder.setDisable(true);

        deleteName.setDisable(true);deletePrice.setDisable(true);deleteQuantity.setDisable(true);
        deleteDescription.setDisable(true);deleteSize.setDisable(true);deleteSpecialOrder.setDisable(true);

        updateName.setDisable(false);updatePrice.setDisable(false);updateQuantity.setDisable(false);
        updateDescription.setDisable(false);
        updateSize.setDisable(false);updateSpecialOrder.setDisable(false);
    }
    public void submitFuncAdd(ActionEvent actionEvent)
    {
        String name = addName.getText();
        double price = Double.parseDouble(addPrice.getText());
        int quantity = Integer.parseInt(addQuantity.getText());
        String description = addDescription.getText();
        String specialOrder = addSpecialOrder.getText();
        int size = Integer.parseInt(addSize.getText());
        FoodItemClass item =  new FoodItemClass(name,price,quantity,description,size,specialOrder);
        items.add(item);
        foods.add(item);
        list.setItems(items);
        disableAll();

    }
    public void submitFuncSearch(ActionEvent actionEvent)
    {
        String name = searchName.getText();
        double price = Double.parseDouble(searchPrice.getText());
        int quantity = Integer.parseInt(searchQuantity.getText());
        String description = searchDescription.getText();
        String specialOrder = searchSpecialOrder.getText();
        int size = Integer.parseInt(searchSize.getText());
        FoodItemClass item =  new FoodItemClass(name,price,quantity,description,size,specialOrder);
        if(foods.search(item))
            submitlbl.setText("Found");
        else
            submitlbl.setText(" Not Found");

        disableAll();
    }
    public void submitFuncDelete(ActionEvent actionEvent)
    {
        String name = deleteName.getText();
        double price = Double.parseDouble(deletePrice.getText());
        int quantity = Integer.parseInt(deleteQuantity.getText());
        String description = deleteDescription.getText();
        String specialOrder = deleteSpecialOrder.getText();
        int size = Integer.parseInt(deleteSize.getText());
        FoodItemClass item =  new FoodItemClass(name,price,quantity,description,size,specialOrder);
        foods.delete(item);
        items = foods.copy();
        list.setItems(items);

        disableAll();
    }
    public void submitFuncUpdate(ActionEvent actionEvent)
    {
        String name = updateName.getText();
        double price = Double.parseDouble(updatePrice.getText());
        int quantity = Integer.parseInt(updateQuantity.getText());
        String description = updateDescription.getText();
        String specialOrder = updateSpecialOrder.getText();
        int size = Integer.parseInt(updateSize.getText());
        FoodItemClass item =  new FoodItemClass(name,price,quantity,description,size,specialOrder);
        foods.delete(list.getSelectionModel().getSelectedItem());
        foods.add(item);
        items = foods.copy();
        list.setItems(items);

        disableAll();
        disableAll();
    }
    private boolean mode = true;
    public Button bMode;
    public void changeMode(ActionEvent actionEvent)
    {
        if(mode)
        {
            mode = false;
            bMode.setText("List Mode");
            cNameText.setDisable(false);
            list.setDisable(true);
            cList.setDisable(false);
        }
       else
        {
            mode = true;
            bMode.setText("Category Mode");
            cNameText.setDisable(true);
            list.setDisable(false);
            cList.setDisable(true);
        }
    }
}
