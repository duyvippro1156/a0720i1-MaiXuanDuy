package DeleteIntoBinarySearchTree;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //create a BST
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.Inorder();
        System.out.println("The number of nodes is: " + tree.getSize());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired element: ");
        String data = scanner.nextLine();
        if(tree.search(tree.root,data) != null){
            System.out.println("Element was existed");
        }else {
            System.out.println("Element was not existed");
        }
        System.out.println("--------------------------------------------");
        System.out.print("Enter the element you want to delete: ");
        String data1 = scanner.nextLine();
        tree.Xoa(tree.root,data1);
        tree.Inorder();

    }
}
