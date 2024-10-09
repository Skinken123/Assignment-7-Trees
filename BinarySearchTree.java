public class BinarySearchTree<Key extends Comparable<Key>, Value>{
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

        private void printImplicitStack() {
            if(this.left != null) this.left.printImplicitStack();
            System.out.println(this.key + " " + this.value);
            if(this.right != null) this.right.printImplicitStack();
        }
    }

    private Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void add(Key key, Value val){
        if (root == null) root = new Node(key, val);
        else root.add(key, val);
    }

    public boolean lookup(Key key){
        if (root == null) return false;
        else return root.lookup(key);
    }

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

    public void printTreeImplicitStack(){
        root.printImplicitStack();
    }

    public void printExplicitStack() {
        Dynamic<Node> nodeStack = new Dynamic<Node>();
        Node current = this.root;
        // move to the leftmost node
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
                current = nodeStack.pop();
            }
        }
        // done
        return;
    }
        
}