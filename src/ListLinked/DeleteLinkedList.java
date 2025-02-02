package src.ListLinked;

class Node {
    int value;
    Node next;
}

// PROF'S CODE:

public class DeleteLinkedList {
    public Node head;
    public Node tail;
    public int size;

    // Create a linked list
    public Node createdLinkedList(int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // Insert into linked list
    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createdLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            tail.next = node;
            node.next = null;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;
    }

    // Traverse a linked list
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
            System.out.print("\n");
        }
    }

    // Search for a node
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node: " + tempNode.value + " at location: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    // METHOD I ADDED FOR ASSIGNMENT

    // Delete a node
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The linked list does not exist");
            return;
        } else if (location == 0) { // Delete first node
            head = head.next; // move to the next node and reduce size of the list
            size--;
            if (size == 0) { // If list becomes empty, reset tail
                tail = null;
            }
        } else if (location >= size - 1) { // Delete last node
            Node tempNode = head;
            for (int i = 0; i < size - 2; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode.next == tail) {
                tempNode.next = null;
                tail = tempNode;
            }
            size--;
        } else { // Delete a node anywhere
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }


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

