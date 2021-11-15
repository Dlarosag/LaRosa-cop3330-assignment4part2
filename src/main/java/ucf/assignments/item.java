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

    public  void undo(){

        complete = false;
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

        if(newDescr.length() > 256 || newDescr.length() < 1)
            return;

        descript = newDescr;
    }

    public  void editDate(String newDate){

        if(newDate.length() > 11) {
            date = "Invalid date";
            return;
        }
        date = newDate;
    }

    public  void replace(item it) {

        item(it.getName(), it.getDescript(), it.getDate());
    }
}
