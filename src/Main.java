// Arboles binarios de busqueda
// Implementar las operaciones de inserción, búsqueda y recorrido en orden (in-order traversal).

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class Tree{
    Node root;

    Tree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}
public class Main {


    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.insert(50);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(30);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal:");
        tree.inorder();

        int keyToSearch = 40;
        if (tree.search(keyToSearch))
            System.out.println("\nKey " + keyToSearch + " found in the tree.");
        else
            System.out.println("\nKey " + keyToSearch + " not found in the tree.");

    }
}