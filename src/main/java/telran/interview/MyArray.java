package telran.interview;
public class MyArray<T> {
    private T[] array;
    private T defaultValue;
    private int currentVersion;
    private int[] version;

    @SuppressWarnings("unchecked")
	public MyArray(int size) {
        array = (T[]) new Object[size];
        version = new int[size];
        currentVersion = 0;
    }

    public void setAll(T value) {
        defaultValue = value;
        currentVersion++;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = value;
        version[index] = currentVersion;
    }

    public T get(int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return version[index] == currentVersion ? array[index] : defaultValue;
    }
}
