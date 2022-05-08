package com.greatlearning.Ques2;

class Node
{
    int val;
    Node left, right;

    Node(int item)
    {
        val = item;
        left = right = null;
    }
}

public class BinarytoSkewedTree {

	
	public static Node node;
	static Node prevNode = null;
    static Node headNode = null;

	public static void main(String[] args) {
		BinarytoSkewedTree tree = new BinarytoSkewedTree();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left= new Node(55);
		
		flattenBSTtoSkewed(node);
		printSkewedTree(headNode);
	}

   private static void printSkewedTree(Node root) {
		if (root==null) {
			return;
		}
		System.out.println(root.val +" ");
		printSkewedTree(root.right);
	}

    static void flattenBSTtoSkewed(Node root) {
		
	   //return null if tree is empty and root is null
	    if (root==null)
	    {
	    	return;
	    } 
	    
	    flattenBSTtoSkewed(root.left);

	    Node rightNode=root.right;
	    
	    //check if head of skewed tree is defined
	    if (headNode==null) {
	    	headNode=root;
	    	root.left=null;
	    	prevNode=root;	    			
	    } else {
	    	prevNode.right=root;
	    	root.left=null;
	    	prevNode=root;
	    }
	    
	    flattenBSTtoSkewed(rightNode);
		
	}

}
