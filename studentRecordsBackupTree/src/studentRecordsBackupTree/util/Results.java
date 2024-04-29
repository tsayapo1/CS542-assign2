package studentRecordsBackupTree.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    public void write_output(String regc, String output_args){
        try {
            FileWriter file = new FileWriter(output_args);
            BufferedWriter output = new BufferedWriter(file);
            output.write(regc);
            output.close();
        }
        catch (IOException e) {
            System.out.println("exception occurred" + e);
        }
        finally{

        }
    }

    public void write(String regc, String output_args){
        File log = new File(output_args);
        try{
            if(!log.exists()){
                log.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(log, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(regc);
            bufferedWriter.close();

        } catch(IOException e) {
            System.out.println("COULD NOT LOG!!");
        }
    }

    public void write_error(String err, String err_args){
        try {
            FileWriter file = new FileWriter(err_args);
            BufferedWriter output = new BufferedWriter(file);
            output.write(err);
            output.close();
        }
        catch (IOException e) {
            System.out.println("exception occurred" + e);
        }
        finally{
            
        }
    }
	
}
