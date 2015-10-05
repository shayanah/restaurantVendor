package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.ListView;
import javafx.scene.control.*;
import javafx.stage.WindowEvent;

public class Controller implements Initializable{
    public ListView<FoodItemClass> list;
    public FoodItemLinkedList<FoodItemClass> foods ;
    public FoodCategoryLinkedList<FoodItemLinkedList<FoodItemClass>> category ;
    //public ListView<String> list;
   // public ObservableList<String> items = FXCollections.observableArrayList();
    public ObservableList<FoodItemClass> items = FXCollections.observableArrayList();
    public ObservableList<FoodCategoryNode<FoodItemLinkedList<FoodItemClass>> > cItems = FXCollections.observableArrayList();


    public ListView<FoodCategoryNode<FoodItemLinkedList<FoodItemClass>>> cList;
    public TextField nameTextField;
    public TextField priceTextField;
    public TextField quantityTextField;
    public TextField sizeTextField;
    public TextField descriptionTextField;
    public TextField specialOrderTextField;
    public Label resultLabel;
    public int counter = 0;
    public Simulator simulator = new Simulator();
    public TextField cNameTextField;
    public Button categoryAddBtn;
    private FoodItemLinkedList<FoodItemClass> temp;

    public void showList()
    {


        try {
            foods = simulator.readTheInventory("out.bin");
            items = foods.copy();
            list.setItems(items);

            //category = new FoodCategoryLinkedList<>();
            category = simulator.readTheCategory("category.bin");
           /* if(simulator.readTheCategory("category.bin") != null)
                category = simulator.readTheCategory("category");
            else
                category = new FoodCategoryLinkedList<>();*/
            //category.add(foods,"main foods");
            cItems = category.copy();
            cList.setItems(cItems);
        }
        catch (Exception e) {

        }



        //foods = new FoodItemLinkedList<>();
       // FoodItemClass item =  new FoodItemClass("food1", 5.00, 1, "decription1", 10, "specialOrder");
       // foods.add(item);

        //items.add(item);
        //items.add(new FoodItemClass("food1", 5.00, 1, "decription1", 10, "specialOrder"));
        //items.add("dsf");
        //items.add("dssdff");

        //listBox.(new FoodItemClass("food1", 5.00, 1, "decription1", 10, "specialOrder"));
        
    }

    public void exitApplication(ActionEvent event) {
        Platform.exit();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        showList();
    }

    public void addFunc(ActionEvent actionEvent)
    {
        try {
            if(listMode)
            {
                String name = nameTextField.getText();
                double price = Double.parseDouble(priceTextField.getText());
                int quantity = Integer.parseInt(quantityTextField.getText());
                String description = descriptionTextField.getText();
                String specialOrder = specialOrderTextField.getText();
                int size = Integer.parseInt(sizeTextField.getText());
                FoodItemClass item =  new FoodItemClass(name,price,quantity,description,size,specialOrder);
                items.add(item);
                foods.add(item);
                list.setItems(items);
                counter++;
            }
            else
            {
                String cName = cNameTextField.getText();
                String name = nameTextField.getText();
                double price = Double.parseDouble(priceTextField.getText());
                int quantity = Integer.parseInt(quantityTextField.getText());
                String description = descriptionTextField.getText();
                String specialOrder = specialOrderTextField.getText();
                int size = Integer.parseInt(sizeTextField.getText());
                FoodItemClass item =  new FoodItemClass(name,price,quantity,description,size,specialOrder);
                FoodItemLinkedList<FoodItemClass> temp = new FoodItemLinkedList<>();
                temp.add(item);

                FoodCategoryNode<FoodItemLinkedList<FoodItemClass>> temp2
                        = new FoodCategoryNode<FoodItemLinkedList<FoodItemClass>>(temp);
                temp2.getData().add(item);
                temp2.setName(cName);

                category.add(temp, cName);
                cItems.add(temp2);
                cList.setItems(cItems);

            }

        } catch (NumberFormatException e) {

        }
    }

    /**
     *
     * @param actionEvent
     */
    public void searchFunc(ActionEvent actionEvent)
    {
        if(listMode)
        {
            String name = nameTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            int quantity = Integer.parseInt(quantityTextField.getText());
            String description = descriptionTextField.getText();
            String specialOrder = specialOrderTextField.getText();
            int size = Integer.parseInt(sizeTextField.getText());
            FoodItemClass item =  new FoodItemClass(name,price,quantity,description,size,specialOrder);

            if(foods.search(item) != null)
                resultLabel.setText("Found");
            else
                resultLabel.setText(" Not Found");
        }
        else
        {
            String name = nameTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            int quantity = Integer.parseInt(quantityTextField.getText());
            String description = descriptionTextField.getText();
            String specialOrder = specialOrderTextField.getText();
            int size = Integer.parseInt(sizeTextField.getText());
            FoodItemClass item =  new FoodItemClass(name,price,quantity,description,size,specialOrder);
            FoodItemLinkedList<FoodItemClass> temp = new FoodItemLinkedList<>();
            temp.add(item);
            if(category.search(temp) != null)
                resultLabel.setText("Found");
            else
                resultLabel.setText(" Not Found");
        }

    }
    public void deleteAllFunc(ActionEvent actionEvent)
    {
        try
        {
            if(listMode)
            {
                String name = nameTextField.getText();
                double price = Double.parseDouble(priceTextField.getText());
                int quantity = Integer.parseInt(quantityTextField.getText());
                String description = descriptionTextField.getText();
                String specialOrder = specialOrderTextField.getText();
                int size = Integer.parseInt(sizeTextField.getText());
                FoodItemClass item =  new FoodItemClass(name,price,quantity,description,size,specialOrder);
                foods.delete(item);
                items = FXCollections.observableArrayList();
                items = foods.copy();
                list.setItems(items);
            }
            else
            {
                String name = nameTextField.getText();
                double price = Double.parseDouble(priceTextField.getText());
                int quantity = Integer.parseInt(quantityTextField.getText());
                String description = descriptionTextField.getText();
                String specialOrder = specialOrderTextField.getText();
                int size = Integer.parseInt(sizeTextField.getText());
                FoodItemClass item =  new FoodItemClass(name,price,quantity,description,size,specialOrder);
                FoodItemLinkedList<FoodItemClass> temp = new FoodItemLinkedList<>();
                temp.add(item);
                category.delete(temp);
                cItems = FXCollections.observableArrayList();
                cItems = category.copy();
                cList.setItems(cItems);
            }

        }
        catch (Exception e){}


    }
    public void deleteFunc(ActionEvent actionEvent)
    {
        try
        {
            if(listMode)
            {
                Integer i = list.getSelectionModel().getSelectedIndex();
                resultLabel.setText(i.toString());
                foods.delete(list.getSelectionModel().getSelectedItem(),list.getSelectionModel().getSelectedIndex());
                items = FXCollections.observableArrayList();
                items = foods.copy();
                list.setItems(items);
            }
            else
            {
                Integer i = list.getSelectionModel().getSelectedIndex();
                resultLabel.setText(i.toString());
                FoodItemLinkedList<FoodItemClass> temp = new FoodItemLinkedList<>();
                temp.delete(list.getSelectionModel().getSelectedItem(),list.getSelectionModel().getSelectedIndex());
                category.delete(temp);
                cItems = FXCollections.observableArrayList();
                cItems = category.copy();
                cList.setItems(cItems);
            }

        }
        catch (Exception e){}


    }
    public void updateFunc(ActionEvent actionEvent)
    {
        if(listMode)
        {
            String name = nameTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            int quantity = Integer.parseInt(quantityTextField.getText());
            String description = descriptionTextField.getText();
            String specialOrder = specialOrderTextField.getText();
            int size = Integer.parseInt(sizeTextField.getText());
            FoodItemClass item =  new FoodItemClass(name,price,quantity,description,size,specialOrder);
            // foods.delete(list.getSelectionModel().getSelectedItem());
            // foods.add(item);
            foods.update(list.getSelectionModel().getSelectedItem(),item,list.getSelectionModel().getSelectedIndex());
            items = FXCollections.observableArrayList();
            items = foods.copy();
            list.setItems(items);
        }
        else
        {
            String name = nameTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            int quantity = Integer.parseInt(quantityTextField.getText());
            String description = descriptionTextField.getText();
            String specialOrder = specialOrderTextField.getText();
            int size = Integer.parseInt(sizeTextField.getText());
            FoodItemClass item =  new FoodItemClass(name,price,quantity,description,size,specialOrder);
            // foods.delete(list.getSelectionModel().getSelectedItem());
            // foods.add(item);
            FoodItemLinkedList<FoodItemClass> temp = new FoodItemLinkedList<>();
            temp.add(item);
            FoodCategoryNode<FoodItemLinkedList<FoodItemClass>> temp2 = new FoodCategoryNode<FoodItemLinkedList<FoodItemClass>>(temp);

            category.update(cList.getSelectionModel().getSelectedItem(), temp2, cList.getSelectionModel().getSelectedIndex());
            cItems = FXCollections.observableArrayList();
            cItems = category.copy();
            cList.setItems(cItems);

        }

    }
    private boolean listMode = true;
    public Button bMode;
    public void changeMode(ActionEvent actionEvent)
    {
        if(listMode)
        {
            listMode = false;
            bMode.setText("List Mode");
            categoryAddBtn.setDisable(false);
            cNameTextField.setDisable(false);
            //list.setDisable(true);
            cList.setDisable(false);
        }
        else
        {
            listMode = true;
            bMode.setText("Category Mode");
            categoryAddBtn.setDisable(true);
            cNameTextField.setDisable(true);
            //list.setDisable(false);
            cList.setDisable(true);
        }
    }

    public void saveState()
    {
        simulator.saveTheInventory(foods,"out.bin");
        simulator.saveTheCategory(category,"category.bin");
    }

    public void createCategoryFunc(ActionEvent actionEvent)
    {
        temp = new FoodItemLinkedList<FoodItemClass>();
    }
}
