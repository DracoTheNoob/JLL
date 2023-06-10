package fr.dtn.jll;

import java.io.*;
import java.time.LocalDateTime;

/**
 * A class to make better logs
 */
public class Log {
    /**
     * The directory which the logs will be written in
     */
    private static File directory;
    /**
     * Console print stream
     */
    private static final PrintStream console = System.out;
    /**
     * Console exceptions pint stream
     */
    private static final PrintStream trace = System.err;

    /**
     * To set the logs directory folder
     * @param directory The directory where the logs will be written in
     */
    public static void setDirectory(File directory){
        Log.directory = directory;
    }

    public static void setDirectory(String path){ setDirectory(new File(path)); }

    /**
     * To get the current log prefix string
     * @return The prefix string
     */
    static String getPrefix(){
        LocalDateTime time = LocalDateTime.now();

        String thread = Thread.currentThread().getName();
        String caller = new Exception().getStackTrace()[2].getClassName();
        String method = Thread.currentThread().getStackTrace()[3].getMethodName();

        return "[" + time.getHour() + ":" +
                time.getMinute() + ":" +
                time.getSecond() + "][" +
                thread + "][" +
                caller + "#" +
                method + "]: ";
    }

    /**
     * To get the file where the logs will be written in
     * @return The file
     * @throws IOException If the parent directory does not exist and cannot be made
     */
    static File getFile() throws IOException{
        if(directory == null || (!directory.exists() && !directory.mkdir()))
            throw new IOException("Logs directory does not exists and can't be made");

        LocalDateTime time = LocalDateTime.now();
        String path = time.getYear() + "." + time.getMonthValue() + "." + time.getDayOfMonth();
        return new File(directory, path+".log");
    }

    /**
     * To change "System.out" and "System.err" to print streams that write in a log file
     */
    static void setPrint(){
        try{
            System.setOut(new PrintStream(new DoubleOutputStream(getFile(), console)));
            System.setErr(new PrintStream(new DoubleOutputStream(getFile(), trace)));
        }catch(IOException e){ e.printStackTrace(); }
    }

    /**
     * To print a message in both console and log file
     * @param o The object to print
     */
    public static void print(Object o){
        setPrint();
        System.out.println(getPrefix() + o);
    }
}