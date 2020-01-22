package com.iec2016018.CCWarmup.DSTree;

import java.util.LinkedList;

public class Node {

    public int data;
    public Node left, right, parent;

    public int depth=0;
    public int level=0;
    public int drawPos=0;

    public Node(int key, Node parent)
    {
        data = key;
        left = right = null;
        this.parent = parent;
    }

    public static Node getNewNode(int data, Node parent){
        return new Node(data, parent);
    }









    public static void drawTree(Node root)
    {

        System.out.println("\n\n-------------------------------------------------\n\n");
        int depth = depth(root);
        setLevels (root, 0);

        int depthChildCount[] = new int [depth+1];


        LinkedList<Node> q = new  LinkedList<Node> ();
        q.add(root.left);
        q.add(root.right);

        // draw root first
        root.drawPos = (int)Math.pow(2, depth-1)*H_SPREAD;
        currDrawLevel = root.level;
        currSpaceCount = root.drawPos;
        System.out.print(getSpace(root.drawPos) + root.data);

        while (!q.isEmpty())
        {
            Node ele = q.pollFirst();
            drawElement (ele, depthChildCount, depth, q);
            if (ele == null)
                continue;
            q.add(ele.left);
            q.add(ele.right);
        }
        System.out.println();
        System.out.println("\n\n-------------------------------------------------\n\n");
    }

    static int currDrawLevel  = -1;
    static int currSpaceCount = -1;
    static final int H_SPREAD = 3;
    static void drawElement(Node ele, int depthChildCount[], int depth, LinkedList<Node> q)
    {
        if (ele == null)
            return;

        if (ele.level != currDrawLevel)
        {
            currDrawLevel = ele.level;
            currSpaceCount = 0;
            System.out.println();
            for (int i=0; i<(depth-ele.level+1); i++)
            {
                int drawn = 0;
                if (ele.parent.left != null)
                {
                    drawn = ele.parent.drawPos - 2*i - 2;
                    System.out.print(getSpace(drawn) + "/");
                }
                if (ele.parent.right != null)
                {
                    int drawn2 = ele.parent.drawPos + 2*i + 2;
                    System.out.print(getSpace(drawn2 - drawn) + "\\");
                    drawn = drawn2;
                }

                Node doneParent = ele.parent;
                for (Node sibling: q)
                {
                    if (sibling == null)
                        continue;
                    if (sibling.parent == doneParent)
                        continue;
                    doneParent = sibling.parent;
                    if (sibling.parent.left != null)
                    {
                        int drawn2 = sibling.parent.drawPos - 2*i - 2;
                        System.out.print(getSpace(drawn2-drawn-1) + "/");
                        drawn = drawn2;
                    }

                    if (sibling.parent.right != null)
                    {
                        int drawn2 = sibling.parent.drawPos + 2*i + 2;
                        System.out.print(getSpace(drawn2-drawn-1) + "\\");
                        drawn = drawn2;
                    }
                }
                System.out.println();
            }
        }
        int offset=0;
        int numDigits = (int)Math.ceil(Math.log10(ele.data));
        if (ele.parent.left == ele)
        {
            ele.drawPos = ele.parent.drawPos - H_SPREAD*(depth-currDrawLevel+1);
            //offset = 2;
            offset += numDigits/2;
        }
        else
        {
            ele.drawPos = ele.parent.drawPos + H_SPREAD*(depth-currDrawLevel+1);
            //offset = -2;
            offset -= numDigits;
        }

        System.out.print (getSpace(ele.drawPos - currSpaceCount + offset) + ele.data);
        currSpaceCount = ele.drawPos + numDigits/2;
    }



    public static int depth (Node n)
    {
        if (n == null)
            return 0;
        n.depth = 1 + Math.max(depth(n.left), depth(n.right));
        return n.depth;
    }


    public static int countNodes (Node n)
    {
        if (n == null)
            return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    static void setLevels (Node r, int level)
    {
        if (r == null)
            return;
        r.level = level;
        setLevels (r.left, level+1);
        setLevels (r.right, level+1);
    }

    static String getSpace (int i)
    {
        String s = "";
        while (i-- > 0)
            s += " ";
        return s;
    }

}
