/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 David La Rosa Giraud
 */
package ucf.assignments;

import java.util.ArrayList;

public class listOfList {

    private ArrayList<toDoList> arr = new ArrayList<toDoList>();

    public  void addList(toDoList newToDoList){

        arr.add(newToDoList);
    }

    public  toDoList getList(int index){

        return arr.get(index);
    }

    public int findListIndex(String title){

        for(int i =0; i < arr.size(); i++){

            if(arr.get(i).getTitle().contentEquals(title))
                return i;
        }

        return -1;
    }
}
