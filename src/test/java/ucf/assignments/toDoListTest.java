package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class toDoListTest {

    toDoList list = new toDoList();
    item it = new item();



    @Test
    void addItem() {

        it.item("shopping", "go to mall", "11/10/2020");

        list.addItem(it);

        assertEquals("shopping", list.getItem(0).getName());
        assertEquals(1, list.getAmtItems());
    }

    @Test
    void deleteItem() {

        it.item("shopping", "go to mall", "11/10/2020");
        list.addItem(it);

        list.deleteItem(0);
        assertEquals(0, list.getAmtItems());
    }

    @Test
    void getAmtItems() {

        it.item("shopping", "go to mall", "11/10/2020");
        list.addItem(it);

        assertEquals(1, list.getAmtItems());

        it.item("walk", "go to gym", "21/8/2020");
        list.addItem(it);
        assertEquals(2, list.getAmtItems());

        list.deleteItem(1);
        assertEquals(1, list.getAmtItems());

    }

    @Test
    void getItem() {

        it.item("shopping", "go to mall", "11/10/2020");
        list.addItem(it);

        assertEquals("shopping", list.getItem(0).getName());
        assertEquals("go to mall", list.getItem(0).getDescript());
        assertEquals("11/10/2020", list.getItem(0).getDate());
    }

    @Test
    void editTitle() {

        list.editTitle("reminders");
        assertEquals("reminders", list.getTitle());

        list.editTitle("To-do");
        assertEquals("To-do", list.getTitle());
    }
}