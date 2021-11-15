/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 David La Rosa Giraud
 */
package ucf.assignments;

import java.util.ArrayList;
import java.util.List;

public class listOfList {

    private ArrayList<toDoList> arr = new ArrayList<toDoList>();


    public  void addList(toDoList newToDoList){

        arr.add(newToDoList);
    }

    public  void deleteList(int index) {

        arr.remove(index);
    }

    public  toDoList getList(int index){

        return arr.get(index);
    }

    public  int isEmpty(){

        if(arr.isEmpty())
            return 1;

        else
            return 0;
    }

    public int findListIndex(String title){

        for(int i =0; i < arr.size(); i++){

            if(arr.get(i).getTitle().contentEquals(title))
                return i;
        }

        return -1;
    }
    
    public  int exportOne(){

        /*
       This method will read from a file

       It will get a list from the file

       the list will be added to the listoflist object

       Will return 1 if it completes the task

       else will return 0

       */



        return -1;
    }

    public  int exportAll(){

        /*
       This method will read all the existing list from an external file

       it will combine it with the current listOfList

       Will return 1 if it completes the task

       else will return 0

       */
        return -1;
    }

    public  int importOne(){

        /*
       This method will take an int along with getList() to save the list items to an external file

       Will return 1 if it completes the task

       else will return 0

       */


        return -1;
    }

    public  int importAll(){

        /*
       This method will save all the list items to an external file

       Will return 1 if it completes the task

       else will return 0

       */


        return -1;
    }

}
