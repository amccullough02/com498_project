public final class ArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private boolean initialised = false;
    private static final int MAX_CAPACITY = 10000;

    private void checkIntialisation() {
        if (!initialised) {
            throw new SecurityException("" +
                    "ArrayBag object is not initialised properly");
        }
    }

    private boolean isArrayFull() {
        return (bag.length == numberOfEntries);
    }

    private T removeElementAt(int index) {
        T result = null;
        if (!isEmpty() && index >= 0 && index < numberOfEntries) {
            result = bag[index];
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }

    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int capacity) {
        if (capacity <= MAX_CAPACITY) {
            T[] tempBag = (T[]) new Object[capacity];
            bag = tempBag;
            numberOfEntries = 0;
            initialised = true;
        } else throw new IllegalStateException("" +
                "Attempt to create a bag where the capacity" +
                "exceeds the maximum");
    }

    public int getCurrentSize() {

        return numberOfEntries;

    }

    public boolean isEmpty() {

        return numberOfEntries == 0;

    }

    public boolean addNewEntry(T newEntry) {

        checkIntialisation();

        if (isArrayFull()) return false;
        else {
            bag[numberOfEntries++] = newEntry;
            return true;
        }

    }

    public boolean setEntryAt(int index, T anEntry) {
        checkIntialisation();

        if (anEntry.equals(bag[index])) return false;
        else {
            bag[index] = anEntry;
            return true;
        }

    }

    public T remove() {

        checkIntialisation();
        return removeElementAt(numberOfEntries - 1);

    }

    public T remove(int index) {

        checkIntialisation();
        return removeElementAt(index);

    }

    public boolean remove(T anEntry) {

        boolean found = false;
        int index = 0;
        while (!found && index < numberOfEntries) {
            if (bag[index].equals(anEntry)) found = true;
            else index++;
        }

        if (found) removeElementAt(index);
        return found;

    }

    public void clear() {

        while(!isEmpty()) remove();

    }

    public int getFrequencyOf(T anEntry) {

        int count = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) count++;

        }

        return count;

    }

    public boolean contains(T anEntry) {

        boolean found = false;
        int index = 0;
        while (!found && index < numberOfEntries)
            if (bag[index++].equals(anEntry)) found = true;
        return found;

    }

    public T[] toArray() {

        T[] resultArray = (T[]) new Object[numberOfEntries];
        System.arraycopy(bag, 0, resultArray, 0, numberOfEntries);
        return resultArray;

    }

    public String toString() {
        String strResult = "Bag[";
        for (int i = 0; i < numberOfEntries; i++) {
            strResult += bag[i] + " ";
        }
        strResult += "]";
        return strResult;
    }

    public T returnElement(int index) {

        T[] resultArray = (T[]) new Object[numberOfEntries];
        System.arraycopy(bag, 0, resultArray, 0, numberOfEntries);
        return resultArray[index];

    }

}
