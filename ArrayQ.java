public class ArrayQ<T>  {//extends Queue<T>
    T[] queueArray;
    int arrayLenght;
    int indexOfFirst;
    int indexOfNewItem;

    /*
     * Costructor to create instances of the array queue
     * 
     * @param size, determines the start size of the queue
     */
    public ArrayQ(int size){
        this.arrayLenght = size;
        this.queueArray = (T[]) new Object[arrayLenght];
        this.indexOfFirst = 0;
        this.indexOfNewItem = 0;
    }

    /*
     * Adds a new item to the queue
     * If the queue is full it will resort the items into a new queue of double the size
     * 
     * @param item, the item to be added to the queue
     */
    public void enqueue(T item){
        queueArray[(indexOfNewItem % arrayLenght)] = item;
        indexOfNewItem++;

        if ((indexOfFirst % arrayLenght) == (indexOfNewItem % arrayLenght)){
            createArrayCopy();
        }
    }

    /*
     * Removes the frist item in line in the queue
     * If the queue is empty a error msg will show
     */
    public T dequeue(){
        if ((indexOfFirst % arrayLenght) == (indexOfNewItem % arrayLenght)){
            System.out.print("Queue empty cant remove item");
            return null;
        }

        T itemToReturn = queueArray[(indexOfFirst % arrayLenght)];
        queueArray[(indexOfFirst % arrayLenght)] = null;
        indexOfFirst++;
        return itemToReturn;
    }

    /*
     * Creates a new array double the size of the current queue array
     * Copies all elements from the original queue in order into the new array queue
     * Resets the index values to correctly fit the new array queue
     */
    private void createArrayCopy(){
        T[] doubleArray = (T[]) new Object[arrayLenght*2];
        int j = 0;
        for (int i = indexOfFirst; j < arrayLenght; i++){
            doubleArray[j] = queueArray[i % arrayLenght];
            j++;
        }
        queueArray = doubleArray;
        indexOfFirst = 0;
        indexOfNewItem = arrayLenght;
        arrayLenght = arrayLenght * 2;
    }

    /*
     * Prints the entire queue
     */
    public void printQueue(){
        for (T item : queueArray){
            System.out.print(item + "\n");
        }
    }

    /*
     * Checks if the queue is empty or not returning a boolean 
     * Might not work in all situations but will work fine for the BinarySearchTree breadth first implementation
     */
    public boolean isNotEmpty(){
        if ((indexOfFirst % arrayLenght) == (indexOfNewItem % arrayLenght)) return false;
        return true;
    }
}
