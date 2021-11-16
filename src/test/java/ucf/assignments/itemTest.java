package ucf.assignments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class itemTest {

    item it = new item();

    @Test
    void item() {

        it.item("shopping", "Go to the superMarket", "2021/12/02");

        assertAll(() -> assertEquals("shopping", it.getName()),
                ()-> assertEquals("Go to the superMarket", it.getDescript()),
                 ()-> assertEquals("2021/12/02", it.getDate())
        );
    }

    @Test
    void done() {

        assertFalse(it.isDone());

        it.done();

        assert(it.isDone());
    }

    @Test
    void undo() {

        it.done();

        assert(it.isDone());

        it.undo();

        assertFalse(it.isDone());
    }

    @Test
    void isDone() {

        it.done();

        assert (it.isDone());
    }

    @Test
    void getName() {

        it.editName("dog");

        assertEquals("dog", it.getName());
    }

    @Test
    void getDescript() {

        it.editDescrpt("boxer");

        assertEquals("boxer", it.getDescript());
    }

    @Test
    void getDate() {

        it.editDate("2005/05/12");

        assertEquals("2005/05/12", it.getDate());
    }

    @Test
    void editName() {

        it.editName("dog");
        assertEquals("dog", it.getName());

        it.editName("cat");
        assertEquals("cat", it.getName());

        it.editName("fish");
        it.editName("horse");
        it.editName("shark");

        assertEquals("shark", it.getName());
    }

    @Test
    void editDescrpt() {

        it.editDescrpt("dog");
        assertEquals("dog", it.getDescript());

        it.editDescrpt("cat");
        assertEquals("cat", it.getDescript());

        it.editDescrpt("fish");
        it.editDescrpt("horse");
        it.editDescrpt("shark");

        assertEquals("shark", it.getDescript());
    }

    @Test
    void editDate() {

        it.editDate("10/85/84");
        assertEquals("10/85/84", it.getDate());

        it.editDate("1/850/8");
        assertEquals("1/850/8", it.getDate());

        it.editDate("1/850/2323");
        it.editDate("1/31/32/3");
        it.editDate("1/8/85");

        assertEquals("1/8/85", it.getDate());
    }
}