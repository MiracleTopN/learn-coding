package design.adapter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** 
 * 适配器
 * @author hason
 * @since 2023/6/1 
 */
public class FileIOProperties extends Properties implements FileIO {

    @Override
    public void readFromFile(String fileName) throws IOException, IllegalAccessException {
        load(new FileInputStream(fileName));
    }

    @Override
    public void writeToFile(String fileName) throws IOException, IllegalAccessException {
        store(new FileOutputStream(fileName), "written by FileIOProperties");
    }

    @Override
    public void setValue(String key, String value) throws IllegalAccessException {
        setProperties(key, value);
    }

    @Override
    public String getValue(String key) throws IllegalAccessException {
        return getProperties(key);
    }

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        FileIO p = new FileIOProperties();
        p.readFromFile("/Users/hason/Documents/file1.txt");
        System.out.println("property is " + p);
        p.setValue("year", "2004");
        p.setValue("month", "4");
        p.setValue("day", "21");
        p.writeToFile("/Users/hason/Documents/file2.txt");
        System.out.println("property is " + p);
    }

}
