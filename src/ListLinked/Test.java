package src.ListLinked;

public class Test {

    // TEST OUT THE DELETE MTHODS:

    public static void main(String[] args) {
        DeleteLinkedList list = new DeleteLinkedList();

        // Delete first node
        System.out.println("first node");
        list.deleteNode(0);
        list.traverseLinkedList(); // Output: 10 -> 20 -> 30 -> 40

        // Delete last node
        System.out.println("last node");
        list.deleteNode(list.size - 1);
        list.traverseLinkedList(); // Output: 10 -> 20 -> 30

        // Delete node at index 1
        System.out.println("anywhere(ex: index 1)");
        list.deleteNode(1);
        list.traverseLinkedList(); // Output: 10 -> 30
    }
}
