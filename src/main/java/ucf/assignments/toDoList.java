/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 David La Rosa Giraud
 */
package ucf.assignments;

import java.util.ArrayList;
import java.util.List;

public class toDoList {

    private ArrayList<item> toDo = new ArrayList<item>();
    private  String listTitle;

    public  void addItem(item it){

        toDo.add(it);
    }

    public  void deleteItem(int index){

        toDo.remove(index);
    }

    public  int getAmtItems(){

        return toDo.size();
    }

    public  item getItem(int index){

        return toDo.get(index);
    }

    public  void editTitle(String name){

        listTitle = name;
    }

    public  String getTitle(){

        return listTitle;
    }

    public int findItemIndex(String title){

        for(int i =0; i < toDo.size(); i++){

            if(toDo.get(i).getName().contentEquals(title))
                return i;
        }

        return -1;
    }

    public  int displayAll(){

        /*
       This method will display all the items from the list using a loop

       Will return 1 if it completes the task

       else will return 0
       */


        return -1;

    }

    public  int displayDone(){

        /*
       This method will display all the completed items from the list using a loop

       Inside the loop it will check if the item is done using isDone() method

       if it is done it will print the item

       else continue

       Will return 1 if it completes the task

       else will return 0
       */

        return -1;
    }

    public  int displayToDo(){

        /*
       This method will display all the to do items from the list using a loop

       Inside the loop it will check if the item is done using isDone() method

       if it is not done it will print the item

       else continue

       Will return 1 if it completes the task

       else will return 0
       */


        return -1;

    }


}
