package studentRecordsBackupTree.bst;

public class Node {
	public int Bnumber;
    public String description;
    public Node left, right;

    public Node() 
    {
        left = null;
        right = null;
    }

    public Node(int Bnumber)
    {
        this(Bnumber,null,null);
    }

    public Node(int BnumberIn, Node lt, Node rt) 
    {
        Bnumber = BnumberIn; 
        left = lt; 
        right = rt;
    }
}