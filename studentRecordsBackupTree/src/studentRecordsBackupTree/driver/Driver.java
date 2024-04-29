package studentRecordsBackupTree.driver;
import studentRecordsBackupTree.bst.BSTBuilder;
import studentRecordsBackupTree.bst.BST;
import studentRecordsBackupTree.bst.Node;
import studentRecordsBackupTree.bst.Observer;
import studentRecordsBackupTree.bst.Subject;
import studentRecordsBackupTree.bst.Backups;
import studentRecordsBackupTree.bst.Maintree;
import studentRecordsBackupTree.util.FileDisplayInterface;
import studentRecordsBackupTree.util.Results;
import java.lang.Integer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * @author Shreevara Andila
 */
public class Driver {
	public static void main(String[] args) {
	    if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}
/**Main tree and the backup trees are created 
*/
		BST btree = new BST();
		BST backup1 = new BST();
		BST backup2 = new BST(); 
		BSTBuilder.treebuilder(args[0],args[2],btree,backup1,backup2);
		Results display = new Results();

		String mainInorder, b2in, b1in;
		mainInorder = btree.inorder();
		b1in = btree.inorder();
		b2in = btree.inorder();
		int sumValue = btree.sum();
		int sumValue1 = backup1.sum();
		int sumValue2 = backup2.sum();

		String op1 = "Main BST: " + mainInorder + "\n" + "Backup1: " + b1in + "\n" + "Backup2: " + b2in;
		String op2 = "\n\nMain BST Sum: " + sumValue + "\n" + "Backup1 Sum: " + sumValue1 + "\n" + "Backup2 Sum: " + sumValue2;

		System.out.print(op1 + op2);
		display.write_output(op1,args[1]);
		display.write(op2,args[1]);

/**Backup trees are registered to observers list 
*/

		Maintree mt = new Maintree(btree);
		Backups b1 = new Backups(backup1);
		Backups b2 = new Backups(backup2);

		mt.registerTree(b1);
		mt.registerTree(b2);

		b1.backupTree(mt);
		b2.backupTree(mt);

/**Update on main tree is called, backups also gets updated via observer patterns 
*/
		mt.updateTrees(Integer.parseInt(args[4]));

		String op3 = "\n\nAfter Updating:\n";
		int usumValue = btree.sum();
		int usumb1 = b1.backuptrees.sum();
		int usumb2 = b2.backuptrees.sum();
		String umain = btree.inorder();
		String ub1 = b1.backuptrees.inorder();
		String ub2 = b1.backuptrees.inorder();

		String uop1 = op3+ "Main BST: " + umain + "\n" + "Backup1: " + ub1 + "\n" + "Backup2: " + ub2 + "\n";
		String uop2 = "\n" + "Main BST Sum: " + usumValue + "\n" + "Backup1 Sum: " + usumb1 + "\n" + "Backup2 Sum: " + usumb2 + "\n";
		System.out.print(uop1 + uop2);
        display.write(uop1,args[1]);
		display.write(uop2,args[1]);
	}
}