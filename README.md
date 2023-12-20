# Integer Binary Search Tree

This repository contains the implementation for a Binary Search Tree (BST) that holds integers as its data points. The two classes used to implement this are `Node.java` & `BinarySearchTree.java`. 

The `BinarySearchTree.java` class contains the following unique methods:
- `Node getRoot()` - returns the root of the BST
- `int getNodeCount()` - returns the number of nodes in the BST
- `void insert(Node root, int key)` - inserts a node in the BST
- `void preorderRec(Node root)` - recursive method that prints the preorder traversal of the BST
- `Node kthBiggest(Node root, int k)` - returns the kth biggest element in the BST
- `int sum(Node root)` - returns the sum of all the keys in the BST