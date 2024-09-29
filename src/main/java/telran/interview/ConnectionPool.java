package telran.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ConnectionPool {
    private int maxSize;

    public ConnectionPool(int size) {
        this.maxSize = size;
    }
    private final Map<String, Connection> connections = new LinkedHashMap<>(maxSize, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry<String, Connection> eldest) {
            return size() > maxSize;
        }
    };

    public void addConnection(Connection connection) {
        if (connections.containsKey(connection.connectionId())) {
            throw new IllegalStateException();
        }
        connections.put(connection.connectionId(), connection);
    }

    public Connection getConnection(String connectionId) {
        if (!connections.containsKey(connectionId)) {
            throw new NoSuchElementException();
        }
        return connections.get(connectionId);
    }
}
