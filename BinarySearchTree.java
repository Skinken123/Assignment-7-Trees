/*
 * BinarySearchTree class 
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value>{
    /*
     * The node class used for the BinarySearchTree
     */
    private class Node{
        Value value;
        Key key;
        Node left;
        Node right;

        private Node(Key k, Value v){
            this.value = v;
            this.key = k;
            this.right = null;
            this.left = null;
        }

        /*
         * Recursive add method on a node 
         * Recursivly class the add method one either right or left child of the root node until the correct location for the new node is found
         * If the node to be added has the same Key key as another node already in the tree the value at that node is replaced with the value of the new node
         * 
         * @param key, the key of the new node, needs to be a comparable datatype
         * @param val, the value stored in the new node, could be any form of data such as a object or a simple string
         */
        private void add(Key key, Value val){
            if (this.key.equals(key)){
                this.value = val;
                return;
            }
            else if(this.key.compareTo(key) > 0){
                if (this.left != null) this.left.add(key, val);
                else this.left = new Node(key, val); 
            }
            else{
                if (this.right != null) this.right.add(key, val);
                else this.right = new Node(key, val); 
            }
        }

        /*
         * Recursive search method which looks through the tree and returns true or false
         * depending on wether the serached for key is present in the tree.
         * Since this is a BinarySearchTree the nodes of the tree are orderd by size from left to right
         * we use this to serach left or right depending on the size of the key.
         * 
         * @param key, the key of the node we are trying to find in the tree
         */
        private boolean lookup(Key key){
            if (this.key.equals(key)) return true;
            else if(this.key.compareTo(key) > 0){
                if (this.left != null) return this.left.lookup(key);
                else return false;
            }
            else{
                if (this.right != null) return this.right.lookup(key);
                else return false;
            }
        }

        /*
         * Print method using the programming language implicit stack to recusivly move through the tree and print out its values in order
         */
        private void printImplicitStack() {
            if(this.left != null) this.left.printImplicitStack();
            System.out.println(this.key + " " + this.value);
            if(this.right != null) this.right.printImplicitStack();
        }
    }
/*
 * The beginning of the BinarySearchTree class
 */
    private Node root;

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
        // done
        return;
    }
        
}