package studentRecordsBackupTree.bst;
import java.lang.Integer; 
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/** Represents Nodes in accordance with the BST rules applied to the B-Number of each Node.
*/

public class BST{
	public Node root = null;
    public BST(){
    }

    public void clear(){
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

/** Inserts a node with specified Bnumber.
 * @param Bnumber indicating node values.
*/

    public void insert(int Bnumber) {
        Node p = root, prev = null;
        while (p != null) {
            prev = p;
            if ((Integer.compare(p.Bnumber,Bnumber)) < 0)
                p = p.right;
            else p = p.left;
        }
        if (root == null)
            root = new Node(Bnumber);
        else if ((Integer.compare(prev.Bnumber,Bnumber)) < 0)
            prev.right = new Node(Bnumber);
        else prev.left  = new Node(Bnumber);
    }   

    public String inorder(){
        String c =  inorder(root);
        in="";
        return c;
    }

    public int sum(){
        int s = sum(root);
        return s;
    }

    public void update(int update_value){
        update(root,update_value);
    }

/** return inorder Traversal of the binary search tree.
 * @param p Node p.
 * @return A string representing the inorder Traversal.
*/
    String in="";
    private String inorder(Node p) {
        if (p != null) 
        {
            inorder(p.left);
            in += p.Bnumber + " ";
            inorder(p.right);
        }
        return in;
    }

    private int sum(Node p) {
        int sumValue, sumLeft, sumRight;  
        sumValue = sumRight = sumLeft = 0; 
        if(p != null) {  
            if(p.left != null)  
                sumLeft = sum(p.left);  

            if(p.right != null)  
                sumRight = sum(p.right);  
              
            sumValue = p.Bnumber + sumLeft + sumRight;
        }
        return sumValue;
    }

    public void update(Node p, int update_value){
        if (p != null) 
        {
            p.Bnumber= p.Bnumber + update_value;
            update(p.left, update_value);
            update(p.right, update_value);
        }
    }
}
