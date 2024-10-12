package design.flyweight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Flyweight 轻量级对象:表示实例会被共享的类
 * @author hason
 * @since 2023/7/5 00:33
 */
public class BigChar {

    private char charname;

    private String fontdata;

    public BigChar(char charname) {
        this.charname = charname;
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("big" + charname + ".txt"));
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontdata = buf.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    public void print() {
        System.out.print(fontdata);
    }

}
