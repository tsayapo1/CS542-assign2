package studentRecordsBackupTree.bst;

public interface Observer {
	public void updateAll(BST value, int i);
	public void backupTree(Maintree t);
}