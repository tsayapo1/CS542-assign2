package studentRecordsBackupTree.bst;

public interface Subject {
	public void registerTree(Backups backuptree);
	public void unregisterTree(Backups backuptree);
	public void notifyTrees();
	public void updateTrees(int u_value);
}