/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 David La Rosa Giraud
 */
package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start (Stage st) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainPage.fxml"));
        Scene scene = new Scene(root, 1638, 1010);

        st.setTitle("To-do List");
        st.setScene(scene);
        st.show();
    }

    public static void main(String[] args){

        launch(args);
    }





}
