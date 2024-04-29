package studentRecordsBackupTree.bst;

import java.util.ArrayList;
import java.util.List;

public class Maintree implements Subject {
	private List<Backups> bstTrees = new ArrayList<>();
	private int update_value;
	private BST main;

	public Maintree(BST maintree){
		this.main = maintree;
	}

	@Override
	public void registerTree(Backups backuptree) {
		bstTrees.add(backuptree);	
	}

	@Override
	public void unregisterTree(Backups backuptree) {
		bstTrees.remove(backuptree);	
	}

	public int i =0 ;
	@Override
	public void notifyTrees() {
		for (Observer trees : bstTrees) {
			i+=1;
			trees.updateAll(main, i);
		}
	}

	@Override
	public void updateTrees(int value){
		this.update_value=value;
		main.update(value);
		notifyTrees();
	}
}