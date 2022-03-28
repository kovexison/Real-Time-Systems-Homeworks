package laborator3.exemplu2;

import java.io.*;
import java.util.Date;

public class FileService {
    String fileName;
    BufferedReader in;
    PrintWriter out;

    public FileService(String fileName) {
        this.fileName = fileName;
        try {
            out = new PrintWriter(new FileWriter(fileName, true));
            in = new BufferedReader(new FileReader(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void write(String msg) {
        Date date = new Date(System.currentTimeMillis());
        out.println("Date: " + date);
        out.println("Message: " + msg);
        out.flush();
    }

    public synchronized String read() throws IOException{
        String iterator, last = "no message to read";
        while ((iterator = in.readLine()) != null) {
            last = new Date(System.currentTimeMillis()) + " - " + iterator;
        }
        return last;
    }
}
