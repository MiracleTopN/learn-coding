package design.adapter;

import java.io.IOException;

/**
 * 适配后
 * @author xiaohan.wang
 * @since 2023/6/1
 */
public interface FileIO {

    void readFromFile(String fileName) throws IOException, NoSuchFieldException, IllegalAccessException;

    void writeToFile(String fileName) throws IOException, NoSuchFieldException, IllegalAccessException;

    void setValue(String key, String value) throws NoSuchFieldException, IllegalAccessException;

    String getValue(String key) throws NoSuchFieldException, IllegalAccessException;

}
