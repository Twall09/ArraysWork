package src;

// PROF'S CODE:
public class LinkedListDelete {
//    public Node head;
//    public Node tail;
//    public int size;
//
//    //create a linked list
//    public Node createdLinkedList(int nodeValue) {
//        Node node = new Node();
//        node.next = null;
//        node.value = nodeValue;
//        head = node;
//        tail = node;
//        size = 1;
//        return head;
//    }
//
//    //Insert int linked list
//    //0. if the link doesn't
//    //1. inserting at the beginning
//    //2. inserting at the ending
//    //3. inserting anywhere
//
//    public void insertInLinkedList(int nodeValue, int location) {
//        Node node = new Node();
//        node.value = nodeValue;
//        if (head == null) {
//            createdLinkedList(nodeValue);
//            return;
//        } else if (location == 0) {
//            node.next = head;
//            head = node;
//        } else if (location >= size) {
//            tail.next = node;
//            node.next = null;
//            tail = node;
//        } else {
//            Node tempNode = head;
//            int index = 0;
//            while (index < location - 1) {
//                tempNode = tempNode.next;
//                index++;
//            }
//            Node nextNode = node;
//            node.next = nextNode;
//        }
//        size++;
//    }
//
//    // Traverse a Linked List
//    public void traverseLinkedList() {
//        if (head == null) {
//            System.out.println("SLL does not exist");
//        } else {
//            Node temNode = head;
//            for (int i = 0; i < size; i++) {
//                System.out.print(temNode.value);
//                if (i != size - 1) {
//                    System.out.print(" -> ");
//                }
//                temNode = temNode.next;
//            }
//            System.out.print("\n");
//        }
//    }
//
//
//    // search for a Node
//
//    public boolean searchNode(int nodeValue) {
//        if (head != null) {
//            Node tempNode = head;
//            for (int i = 0; i < size; i++) {
//                if (tempNode.value == nodeValue) {
//                    System.out.println("Found the node: " + tempNode.value + " at location: " + i + "\n");
//                    return true;
//                }
//                tempNode = tempNode.next;
//            }
//        }
//        System.out.println("Node not found");
//        return false;
//    }

    //Deleting a Node from the linked list
    // LinkedList Delete Method that would be added on to prof's code.

    //0. if the link doesn't
    //1. delete at the beginning
    //2. delete at the ending
    //3. delete anywhere

    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The list does not exist");
            return;
        } else if (location == 0) { // Deleting the first node
            head = head.next;
            size--; // move to the next node and reduce size of list
            if (size == 0) { // If list becomes empty, reset tail
                tail = null;
            }
        } else if (location >= size - 1) { // Delete last node
            Node tempNode = head;
            for (int i = 0; i < size - 2; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode.next == tail) {
                tempNode.next = null; // remove the last node
                tail = tempNode; // new node after the last is removed
            }
            size--; // reduce the size again
        } else { // Delete a node anywhere
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }
}
