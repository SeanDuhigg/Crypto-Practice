package binarytree;


class Node{
    
    int key;
    String str;
    Node leftchild, rightchild;
        public Node(int keyval){
            key = keyval;
            leftchild = null;
            rightchild = null;
        }
        public Node(String keyval){
            str = keyval;
            leftchild = null;
            rightchild = null;
        }
}

public class BinaryTree {
    
    Node root;
    
    public BinaryTree(int key){
        root = new Node(key);
    }
    
    public BinaryTree(String str){
        root = new Node(str);
    }
    
    public BinaryTree(){
        root = null;
    }
    
    public static void main(String[] args) {
        
        BinaryTree myBT = new BinaryTree(5);
        
        myBT.root.leftchild = new Node(3);
        myBT.root.rightchild = new Node(7);
        myBT.root.leftchild.leftchild = new Node(1);
    }
    
}
