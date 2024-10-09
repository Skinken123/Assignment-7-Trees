public class BenchmarkTree{
    public static void main(String[] args){
        BinarySearchTree<Integer, String> newTree = new BinarySearchTree<Integer, String>();
        newTree.add(7, "Sju");
        newTree.add(10, "Tio");
        newTree.add(14, "Fjorton");
        newTree.add(3, "Tre");
        newTree.add(8, "Åtta");
        newTree.add(2, "Två");
        newTree.add(1, "Ett");
        newTree.add(9, "Nio");
        newTree.add(5, "Fem");
        newTree.add(4, "Fyra");

        //newTree.printTreeImplicitStack();
        newTree.printExplicitStack();
    }
}