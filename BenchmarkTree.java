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
        newTree.add(19,"Nitton");
        newTree.add(17, "Sjutton");

        //newTree.printTreeImplicitStack();
        newTree.printExplicitStack();

        newTree.breadthFirstPrint();

        System.out.println("\n");

        Sequence newTreeSequence = newTree.sequence();
        newTreeSequence.nextValue();
        newTreeSequence.nextValue();
        newTreeSequence.nextValue();
        newTreeSequence.nextValue();
        newTree.add(6, "Sex");
        newTree.add(12, "Tolv");
        newTreeSequence.nextValue();
        newTreeSequence.nextValue();
        newTreeSequence.nextValue();
        newTreeSequence.nextValue();
        newTreeSequence.nextValue();
        newTreeSequence.nextValue();
        newTreeSequence.nextValue();
        newTreeSequence.nextValue();
        newTreeSequence.nextValue();
        newTreeSequence.nextValue();
    }
}