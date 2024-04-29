package studentRecordsBackupTree.bst;
import studentRecordsBackupTree.bst.BST;

public class Backups implements Observer {
	
	public BST backuptrees;
	private Maintree maintree = new Maintree(backuptrees);

	public Backups(BST backuptrees){
		super();
		this.backuptrees = backuptrees;
	}
	
	@Override
	public void updateAll(BST update_bst, int i){
		this.backuptrees = update_bst;
    }

	@Override
	public void backupTree(Maintree t){
		maintree = t;
	}
}