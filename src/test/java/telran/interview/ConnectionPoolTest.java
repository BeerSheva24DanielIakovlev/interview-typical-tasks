package telran.interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class ConnectionPoolTest {
    //     //TODO
    //     //should contain the tests reflecting your understanding what should be done
    ConnectionPool pool;
    Connection conn1;
    Connection conn2;

    @BeforeEach
    void setUp() {
        pool = new ConnectionPool(2);
        conn1 = new Connection("1");
        conn2 = new Connection("2");
    }

    @Test
    void addConnectionTest() {
        pool.addConnection(conn1);
        assertThrows(IllegalStateException.class, () -> pool.addConnection(conn1));
    }

    @Test
    void getConnectionTest() {
        pool.addConnection(conn1);
        pool.addConnection(conn2);
        assertEquals(conn1, pool.getConnection("1"));
        assertEquals(conn2, pool.getConnection("2"));
    }

    @Test
    void getNonExistentConnectionTest() {
        pool.addConnection(conn1);
        assertThrows(NoSuchElementException.class, () -> pool.getConnection("3"));
    }

    @Test
    void poolOverflowTest() {
        pool.addConnection(conn1);
        pool.addConnection(conn2);
        Connection conn3 = new Connection("3");
        pool.addConnection(conn3);
        assertDoesNotThrow(() -> pool.getConnection("3"));
    }
}


