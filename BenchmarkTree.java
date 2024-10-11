import java.util.*;

public class BenchmarkTree{
    public static void main(String[] args){
        /* 
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
        */
        //benchmarkAdd();
        benchmarkLookup();
    }

    public static BinarySearchTree<Integer, Integer> generateTree(int size){
        Random random = new Random();
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
        bst.add(5000, 5000);

        // Insert `size` random elements into the tree
        for (int i = 0; i < size - 1; i++) {
            int key = random.nextInt(10000);  // Generate random key
            bst.add(key, key);                // Insert key into the tree
        }
        return bst;
    }

    public static int[] randomNumbers(){
        Random random = new Random();
        int[] numbers = new int[10];
        for(int i = 0; i<10;i++){
            numbers[i] = random.nextInt(10000);
        }
        return numbers;
    }

    public static void benchmarkAdd(){
        int[] sizes = {100, 200, 400, 800, 1600, 3200};
        int k = 5000;
        for (int s : sizes){
            long min = Long.MAX_VALUE;
            long total = 0;
            for (int i = 0; i < k; i++){
                long temp = runAdd(s);
                if (temp < min) min = temp;
                total += temp;
            }
            System.out.print(s + " " + min + " " + total/k + "\n");
        }
    }

    public static long runAdd(int size){
        BinarySearchTree<Integer, Integer> testTree = generateTree(size);
        int[] numbers = randomNumbers();
        long n1 = System.nanoTime();
        for(int n : numbers){
            testTree.add(n, n);
        }
        long n2 = System.nanoTime();
        return (n2-n1)/10;
    }

    public static void benchmarkLookup(){
        int[] sizes = {100, 200, 400, 800, 1600, 3200};
        int k = 5000;
        for (int s : sizes){
            long min = Long.MAX_VALUE;
            long total = 0;
            for (int i = 0; i < k; i++){
                long temp = runLookup(s);
                if (temp < min) min = temp;
                total += temp;
            }
            System.out.print(s + " " + min + " " + total/k + "\n");
        }
    }

    public static long runLookup(int size){
        BinarySearchTree<Integer, Integer> testTree = generateTree(size);
        int[] numbers = randomNumbers();
        long n1 = System.nanoTime();
        for(int n : numbers){
            testTree.lookup(n);
        }
        long n2 = System.nanoTime();
        return (n2-n1)/10;
    }
}