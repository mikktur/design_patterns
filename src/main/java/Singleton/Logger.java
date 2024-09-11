package Singleton;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private String filename;
    private FileWriter writer;

    private Logger() {
        this.filename = "log.txt";

      /*  try {
            this.writer = new FileWriter(this.filename, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Poistettu kun en ollut varma et pitikö filu avata heti kun logger luodaan vai vasta kun setFileName kutsutaan. tai kirjoitetaan jotain.
        */
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void initWriter() {
        try {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
            this.writer = new FileWriter(this.filename, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public synchronized void setFileName(String filename) {
        this.filename = filename;
        initWriter();
    }

    public synchronized void close() {
        try {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //en oo ihan varma onko tarpeen.
        instance = null;
    }

    public synchronized void write(String message) {
        try {
            if(writer == null) {
                initWriter();
            }
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
