package com.iec2016018.CCWarmup.Algos.Sorting;

import com.iec2016018.CCWarmup.Algos.Source.*;

public class Tree {

    /*
            T R E E  S O R T  --

            ABOUT       :

        >

            COMPLEXITY  :   O ( n log n )

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    Node root;
    void insert(int key){
        root = insertRec(root, key);
    }
    Node insertRec(Node root, int key){
        if (root == null){
            root = new Node(key);
            return root;
        }
        if (key < root.key){
            root.left = insertRec(root.left, key);
        }else if (key > root.key){
            root.right = insertRec(root.right, key);
        }
        return root;
    }
    void treeins(int[] arr){
        for (int i = 0 ; i < arr.length ; i++){
            insert(arr[i]);
        }
    }

    // inorder traversal recursive
    void inorderPrint(Node root){
        if (root != null){
            inorderPrint(root.left);
            System.out.print(root.key + " ");
            inorderPrint(root.right);
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //-------------------------------------


}
