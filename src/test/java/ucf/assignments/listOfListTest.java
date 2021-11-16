package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class listOfListTest {

    listOfList allList = new listOfList();
    toDoList list = new toDoList();


    @Test
    void addList() {

        list.editTitle("To-Do");
        allList.addList(list);

        assertEquals("To-Do", allList.getList(0).getTitle());
    }

    @Test
    void getList() {

        allList.addList(list);
        assertEquals(list, allList.getList(0));
    }

    @Test
    void findListIndex() {

        list.editTitle("to-Do");
        allList.addList(list);

        assertEquals(0, allList.findListIndex("to-Do"));
    }
}