/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 David La Rosa Giraud
 */
package ucf.assignments;

public class item {

    private boolean complete = false;

    private  String name;
    private  String descript;
    private  String date;

    public void item(String itemName, String itemDescript, String itemDate){

        name = itemName;
        descript = itemDescript;
        date = itemDate;
    }

   public  void done(){

       complete = true;
   }

    public  boolean isDone(){

       if(complete)
           return true;

       else
           return false;
    }

    public  String getName(){

     return name;
    }

    public  String getDescript(){

        return descript;
    }

    public  String getDate(){

        return date;
    }

    public  void editName(String newName){

        name = newName;
    }

    public  void editDescrpt(String newDescr){

        descript = newDescr;
    }

    public  void editDate(String newDate){

        date = newDate;
    }
}
