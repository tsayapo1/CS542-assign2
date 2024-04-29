package studentRecordsBackupTree.util;

public interface FileDisplayInterface {
	void write_output(String regc, String outputfile_args);
    void write(String regc, String outputfile_args);
    void write_error(String err, String err_args);
}