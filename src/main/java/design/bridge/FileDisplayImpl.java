package design.bridge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/** 实现层次
 * @author hason
 * @since 2023/6/8 14:44
 */
public class FileDisplayImpl implements DisplayImpl {

    private String fileName;

    private BufferedReader reader;

    public static final int MAX_READHEAD_LIMIT = 4096;

    public FileDisplayImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void rawOpen() {
        try {
            reader = new BufferedReader(new FileReader(fileName));
            reader.mark(MAX_READHEAD_LIMIT);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("=-=-=-=-=-" + fileName + "=-=-=-=-=-");
    }

    @Override
    public void rawPrint() {
        String line;
        try {
            reader.reset();
            while ((line = reader.readLine()) != null) {
                System.out.println(">" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rawClose() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=");
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
