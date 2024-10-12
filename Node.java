    /*
     * The node class used for the BinarySearchTree
     */
    public class Node<Key extends Comparable<Key>, Value>{
        Value value;
        Key key;
        Node left;
        Node right;

        public Node(Key k, Value v){
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
        public void add(Key key, Value val){
            if (this.key.equals(key)) this.value = val;
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
        public boolean lookup(Key key){
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
        public void printImplicitStack() {
            if(this.left != null) this.left.printImplicitStack();
            System.out.println(this.key + " " + this.value);
            if(this.right != null) this.right.printImplicitStack();
        }
    }
