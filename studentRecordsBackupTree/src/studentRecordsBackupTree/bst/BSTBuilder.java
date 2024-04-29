package studentRecordsBackupTree.bst;

import studentRecordsBackupTree.util.FileDisplayInterface;
import studentRecordsBackupTree.util.Results;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class BSTBuilder {
    public static void treebuilder(String input_args, String err_args, BST btree, BST backup1, BST backup2)
    {
        Results display = new Results();
        try{
            Scanner s = new Scanner(new File(input_args));
            while (s.hasNextLine()) {
                String line = s.nextLine();
                int id = Integer.parseInt(line);
                btree.insert(id);
                backup1.insert(id);
                backup2.insert(id);
            }
            s.close();
        } 

        catch (FileNotFoundException e) {
            System.err.println("File not found " + e);
            display.write_error(e.toString(),err_args);
            System.exit(0);
        }
        finally{}

    }

}