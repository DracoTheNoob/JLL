package fr.dtn.jll;

import java.io.*;

/**
 * A class to create OutputStream that write both in a file and in a print stream
 */
public class DoubleOutputStream extends OutputStream {
    /**
     * The file to write in
     */
    private final File file;
    /**
     * The print stream to write in
     */
    private final PrintStream print;

    /**
     * Constructor of the class
     * @param file The file to write in
     * @param print The print stream to write in
     */
    public DoubleOutputStream(File file, PrintStream print){
        this.file = file;
        this.print = print;
    }

    /**
     * Override of the OutputStream class write method
     * @param b   the {@code byte}.
     * @throws IOException if the writing in the file failed for some issue
     */
    @Override public void write(int b) throws IOException {
        FileWriter write = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(write);

        print.write(b);
        writer.write(b);

        writer.close();
        write.close();
    }
}