/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 David La Rosa Giraud
 */
package ucf.assignments;

import java.util.ArrayList;

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
}
