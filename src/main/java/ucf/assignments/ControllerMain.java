package ucf.assignments;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMain implements Initializable{

    @FXML
    private Button exportList;

    @FXML
    private Button importList;

    @FXML
    private Button saveList;

    //////////////////////////////////////////////////////////////////////////////////  List of List     //////////////////////////////////////////////////////////////////////////////////

    private listOfList allList = new listOfList();

    @FXML
    private Button newList;

    @FXML
    private ListView<String> listView;

    /////////////////////// Open the window to create a new list
    @FXML
    void newListWindow(ActionEvent event) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/newList.fxml"));
            Parent root = (Parent) fxmlLoader.load();

            ControllerList cl = fxmlLoader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            addList(cl.newList);
        }
        catch (Exception e){}
    }

    /////////////////////// Adds a list to the list of List
    void addList(toDoList newList){

        listView.getItems().add(newList.getTitle());
        allList.addList(newList);
    }

    //////////////////////////////////////////////////////////////////////////////////  List     //////////////////////////////////////////////////////////////////////////////////

    @FXML
    private Label listNameDisplay;

    @FXML
    private ListView<String> itemView;

    @FXML
    private Button deleteAll;

    /////////////////////// Deletes an item from a list
    @FXML
    void deleteItem(ActionEvent event) {

        try {
            int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());
            int j = allList.getList(i).findItemIndex(itemView.getSelectionModel().getSelectedItem());

            itemView.getItems().remove(j);

            allList.getList(i).deleteItem(j);
        }catch (Exception e){}

        descrptDisplay.setText("");
        dateDisplay.setText("");
        completionDisplay.setText("");
    }

    /////////////////////// Deletes all items from a list
    @FXML
    void clearAll(ActionEvent event) {

        try {
            int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());

            for (int j = 0; j < itemView.getItems().size(); j++) {

                allList.getList(i).deleteItem(0);
            }

            itemView.getItems().clear();

        }catch(Exception e){}

        descrptDisplay.setText("");
        dateDisplay.setText("");
        completionDisplay.setText("");
    }

    /////////////////////// Adds an item to a selected list
    void addItem(item newItem){

        int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());
        allList.getList(i).addItem(newItem);
        itemView.getItems().add(newItem.getName());
    }


    @FXML
    void export(ActionEvent event) {

        try {

            int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());
            FileWriter wr = new FileWriter(allList.getList(i).getTitle() + ".txt");
            wr.write(allList.getList(i).getTitle() + "\n\n");

            for(int j = 0; j < allList.getList(i).getAmtItems(); j++){


                wr.write(allList.getList(i).getItem(j).getName() +
                        ": " + allList.getList(i).getItem(j).getDescript() +
                        "--- To-Do Date:" + allList.getList(i).getItem(j).getDate() +
                        "\n");
            }

            wr.close();
        }

        catch(Exception e){}
    }

    @FXML
    void listImport(ActionEvent event) {



    }

    //////////////////////////////////////////////////////////////////////////////////  Items     //////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Label completionDisplay;

    @FXML
    private Label dateDisplay;

    @FXML
    private Button itemDelete;

    @FXML
    private Button doneButton;

    @FXML
    private Button newItem;

    @FXML
    private Label descrptDisplay;

    @FXML
    private Button editItem;

    /////////////////////Open the newItem window to create an item
    @FXML
    void newItemWindow(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/newItem.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            ControllerItem cI = fxmlLoader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.showAndWait();

           addItem(cI.newItem);
        }
        catch (Exception e){}
    }

    ////////////////////// Set the item as Done/Undone
    @FXML
    void setDone(ActionEvent event) {

        int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());
        int j = allList.getList(i).findItemIndex(itemView.getSelectionModel().getSelectedItem());

        if(allList.getList(i).getItem(j).isDone()){

            allList.getList(i).getItem(j).undo();
            completionDisplay.setText("To Do");
        }

        else{

            allList.getList(i).getItem(j).done();
            completionDisplay.setText("Done!");
        }

    }

    ////////////////////// Open the edit item window and allows user to edit item
    @FXML
    void ItemEdit(ActionEvent event) {

        try {

            int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());
            int j = allList.getList(i).findItemIndex(itemView.getSelectionModel().getSelectedItem());

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/newItem.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            ControllerItem cI = fxmlLoader.getController();

            cI.newItem = allList.getList(i).getItem(j);

            cI.ItemName.setText(cI.newItem.getName());
            cI.description.setText(cI.newItem.getDescript());
            cI.date.setText(cI.newItem.getDate());

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.showAndWait();

            allList.getList(i).deleteItem(j);
            itemView.getItems().remove(j);

            allList.getList(i).addItem(cI.newItem);
            itemView.getItems().add(cI.newItem.getName());

            itemView.refresh();
            listView.refresh();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    ////////////////////////////////////////////////////////////////////////////////   Choice box     //////////////////////////////////////////////////////////////////////////////////

    //////////Set up the Choice box
    @FXML
    private ChoiceBox<String> display;
    ObservableList showDisplay = FXCollections.observableArrayList();

    @FXML
    void loadData(){

        showDisplay.addAll("To-Do", "All", "Completed");
        display.getItems().addAll(showDisplay);
        display.getSelectionModel().select(1);
    }

    ////////////////////////////////////////////////////////////////////////////////   Help     //////////////////////////////////////////////////////////////////////////////////

    @FXML
    private Button Help;

    @FXML
    void openHelp(ActionEvent event) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/help.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.showAndWait();

    }

    ////////////////////////////////////////////////////////////////////////////////  initialize //////////////////////////////////////////////////////////////////////////////////
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadData();

        /////////////////////// Overview the List of list
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());

                if(i > -1) {

                    listNameDisplay.setText(allList.getList(i).getTitle());

                    //////// Enable the use of items
                    newItem.setDisable(false);
                    doneButton.setDisable(false);
                    itemDelete.setDisable(false);
                    editItem.setDisable(false);
                    deleteAll.setDisable(false);

                    itemView.getItems().clear();

                    ////////////// Fills the display list with objects depending on the choice box
                    if(allList.getList(i).getAmtItems() > -1) {

                            for (int j = 0; j < allList.getList(i).getAmtItems(); j++) {

                                if (display.getValue().contentEquals("To-Do"))
                                    if (!allList.getList(i).getItem(j).isDone())
                                        itemView.getItems().add(allList.getList(i).getItem(j).getName());

                                if (display.getValue().contentEquals("Completed"))
                                    if (allList.getList(i).getItem(j).isDone())
                                        itemView.getItems().add(allList.getList(i).getItem(j).getName());

                                if (display.getValue().contentEquals("All"))
                                    itemView.getItems().add(allList.getList(i).getItem(j).getName());
                            }
                    }
                }
            }
        });

        /////////////////////// Overview the item Lis
        itemView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                try{

                    int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());
                    int j = allList.getList(i).findItemIndex(itemView.getSelectionModel().getSelectedItem());

                    if(j > -1) {

                        descrptDisplay.setText(allList.getList(i).getItem(j).getDescript());
                        dateDisplay.setText(allList.getList(i).getItem(j).getDate());

                        if(allList.getList(i).getItem(j).isDone())
                            completionDisplay.setText("Done!");

                        else
                            completionDisplay.setText("To Do");

                    }

                }catch(Exception e){}
            }
        });
    }
}

