/**

 * Implement an application that support undo/redo functionality. Use a linked list to maintain a sequence of states.\
 * Each state change is stored as a node in the list, allowing for easy navigation
 * 1<>2<>3<>4<>5
 */

// Boiler code below to help complete the assignment
// completed it using lecture, Jordans Github, and research

package src.UndoRedo;

public class UndoRedo<T> {
    private class Node {
        private T state; // string or integer
        private Node prev; // previous node
        private Node next; // the next node
        private Node (T state) {
            this.state = state;
        }

    }
    private Node currentState;
    private Node head; // first state in the list
    private Node tail; // last state in the list
    //Undo operation

    public T undo(){
        if (currentState == null || currentState.prev == null) {
            return null; // essentially if there is no state to undo
        }
        currentState = currentState.prev; // move to previosu state
        return currentState.state; // returns whatever that value was
        //implement me
    }

    //perform an operation
    public void  addState (T newState) {
        Node newNode = new Node(newState); // adds new state and creates new node with that given state
        if (currentState != null) {
            currentState.next = newNode;
            newNode.prev = currentState;
            currentState = newNode; // makes the current state that new node
        } else {
            head = tail = currentState = newNode; // only initializes these to new node if there is no current state
        }
        //implement me

    }

    //Redo Operation
    public T redo(){
        if (currentState == null || currentState.next == null) {
            // No state to redo
            return null; // again, if current state is null, return null
        }
        currentState = currentState.next;  // Move to next state
        return currentState.state; // returns the new one
        //implement me
    }


    // TEST

    public static void main(String[] args) {
        UndoRedo<String> undoRedo = new UndoRedo<>(); // creates an object
        undoRedo.addState("State 1"); // adds states
        undoRedo.addState("State 2");
        undoRedo.addState("State 3");

        // expected output because the current state is the most recetn one added which is state 3
        // so current state is state 3
        System.out.println("Undo: " + undoRedo.undo());  // Should print "State 2"
        System.out.println("Undo: " + undoRedo.undo());  // Should print "State 1"
        System.out.println("Redo: " + undoRedo.redo());  // Should print "State 2"
        System.out.println("Redo: " + undoRedo.redo());  // Should print "State 3"


    }
}
