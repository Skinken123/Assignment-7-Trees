/*
 * BinarySearchTree class 
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value>{
    /*
    * The beginning of the BinarySearchTree class
    */
    private Node root;

    /*
     * Constructor creating new instances of the binary search tree datastructure
     */
    public BinarySearchTree(){
        this.root = null;
    }

    /*
     * Add operation to add a new node to the tree
     * Creates a new root if the tree is empty otherwise we call the add method in the the node class on the root
     * 
     * @param key, the key of the new node
     * @param val, the value stored in the new node
     */
    public void add(Key key, Value val){
        if (root == null) root = new Node(key, val);
        else root.add(key, val);
    }

    /*
     * A search method to find out wether a node with a certain key is present in the tree
     * 
     * @param key, the key we are searching for
     */
    public boolean lookup(Key key){
        if (root == null) return false;
        else return root.lookup(key);
    }

    /*
     * A add operation without using recursion to move through the tree
     * In this implementation we instead keep track of where we are in the tree when finding the correct place for the new node
     * Uses the BinarySearchTree orderd structure to at every node go down left or right until a fitting empty spot is located
     * 
     * @param key, the key of the new node
     * @param val, the value stored in the new node
     */
    public void addWithoutRecursion(Key key, Value val){
        if (root == null) {
            root = new Node(key, val);
            return;
        }
        Node current = root;
        while(current != null){
            if (current.key.equals(key)){
                current.value = val;
                return;
            }
            else if(current.key.compareTo(key) > 0){
                if (current.left != null) current = current.left;
                else{
                    current.left = new Node(key, val);
                    return;
                } 
            }
            else{
                if (current.right != null) current = current.right;
                else{
                    current.right = new Node(key, val);
                    return;
                }
            }
        }
    }

    /*
     * Prints the entire tree connected to the root node in order
     */
    public void printTreeImplicitStack(){
        root.printImplicitStack();
    }

    /*
     * Prints the entire tree connected to the root node in order 
     * This method uses a self implemented explicit stack instead of using recursion on the implicit programming stack
     * 
     */
    public void printExplicitStack() {
        Dynamic<Node> nodeStack = new Dynamic<Node>();
        Node current = this.root;
        // move to the leftmost node pushing nodes on the stack
        //we push these nodes in order to be able to go back up the tree
        while(current.left != null){
            nodeStack.push(current);
            current = current.left;
        }
        while(current != null) {
            // print value of node
            System.out.println(current.key + " " + current.value);

            if(current.right != null) {
                // move to the leftmost node, push nodes as you go
                current = current.right;
                while (current.left != null){
                    nodeStack.push(current);
                    current = current.left;
                }
            } 
            else{
                //While at the leftmost node we print that node and pop the stack
                //This means that we set current to the first element on the stack enabling us to move back up the tree
                current = nodeStack.pop();
            }
        }
    }

    /*
     * Print method that prints every layer of the tree at a time from left to rigth using a queue
     */
    public void breadthFirstPrint(){
        ArrayQ<Node> nodeQueue = new ArrayQ<Node>(10);
        nodeQueue.enqueue(root);

        while (nodeQueue.isNotEmpty()) {
            Node nodeToPrint = nodeQueue.dequeue();
            System.out.print(nodeToPrint.value + " ");
            if (nodeToPrint.left != null) nodeQueue.enqueue(nodeToPrint.left);
            if (nodeToPrint.right != null) nodeQueue.enqueue(nodeToPrint.right);
        }
    }  
    
    public Sequence sequence(){
        ArrayQ<Node> nodeQueue = new ArrayQ<Node>(10);
        nodeQueue.enqueue(root);
        Sequence treePrintSequence = new Sequence(nodeQueue);
        return treePrintSequence;
    }
}