package design.adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;

/**
 * 被适配
 * @author hason
 * @since 2023/6/1
 */
public class Properties {
    private int year;
    private int month;
    private int day;

    public void load(InputStream in) throws IOException, IllegalAccessException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineContent = line.split("=");
                if (lineContent.length > 1) {
                    String key = lineContent[0];
                    String value = lineContent[1];
                    setProperties(key, value);
                }
            }
        }
    }

    public void store(OutputStream out, String header) throws IllegalAccessException {
        try (PrintWriter writer = new PrintWriter(out)) {
            writer.println(header);
            Field[] fields = getFields(this.getClass());
            if (null != fields) {
                for (int i = 0; i < fields.length; i++) {
                    Field f = fields[i];
                    writer.println(f.getName() + "=" + getProperties(f.getName()));
                }
            }
        }
    }

    public void setProperties(String key, String value) throws IllegalAccessException {
        Field field = getField(this.getClass(), key);
        if (field == null) {
            return;
        }
        field.setAccessible(true);
        Class<?> fieldType = field.getType();
        if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
            field.set(this, Integer.parseInt(value));
        }
    }

    public String getProperties(String key) throws IllegalAccessException {
        Field field = getField(this.getClass(), key);
        if (field != null) {
            field.setAccessible(true);
        }
        if (field == null) {
            return StringUtils.EMPTY;
        }
        return String.valueOf(field.get(this));
    }

    public static Field getField(Class<?> startClass, String fieldName) {
        Class<?> currentClass = startClass;
        while (currentClass != null) {
            try {
                return currentClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                currentClass = currentClass.getSuperclass();
            }
        }
        return null;
    }

    public static Field[] getFields(Class<?> startClass) {
        Class<?> currentClass = startClass;
        while (currentClass != null) {
            Field[] declaredFields = currentClass.getDeclaredFields();
            if (declaredFields.length > 0) {
                return declaredFields;
            }
            currentClass = currentClass.getSuperclass();
        }
        return null;
    }

    @Override
    public String toString() {
        return "design.adapter.Properties{" + "year=" + year + ", month=" + month + ", day=" + day + '}';
    }
}
