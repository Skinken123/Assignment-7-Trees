
public class Sequence{
    ArrayQ arrayQueue;

    public Sequence(ArrayQ queue){
        this.arrayQueue = queue;
    }

    /*
     * Method to print the next node from the tree connected to the root node
     * The method prints the first element in he queue and then pushes any children of that node to the queue
     */
    public void nextValue(){
        if (arrayQueue.isNotEmpty()) {
            Node nodeToPrint = (Node)arrayQueue.dequeue();
            System.out.print(nodeToPrint.value + " ");
            if (nodeToPrint.left != null) arrayQueue.enqueue(nodeToPrint.left);
            if (nodeToPrint.right != null) arrayQueue.enqueue(nodeToPrint.right);
        }
    }
    //any changes to the tree connected to the root node made after the tree traversal has started 
    //will show up in the tree traversal as long as the parent node of the new node removed or added has not been dequeued yet.
    //This means that any change made related to a node that has already been processed will not show up 
}