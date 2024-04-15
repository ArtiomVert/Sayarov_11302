package Reflection;

import java.lang.reflect.Field;

public class ClassToJSON {
    public static <T> String toJSON(T o) throws Exception {
        String json = "{";
        for (Field a : o.getClass().getDeclaredFields()) {
            if (a.getType().equals(String.class)) {
                json += "\n\"" + a.getName() + "\":\"" + a.get(o) + "\",";
            } else if (isPrimitive(a.getType()) || a.get(o) == null) {
                json += "\n\"" + a.getName() + "\":" + a.get(o) + ",";
            } else {
                json += "\n\"" + a.getName() + "\":" + toJSON(a.get(o)) + ",";
            }

        }
        json += "\b";
        json += "\n}";
        return json;
    }

    public static boolean isPrimitive(Class clazz) {
        return clazz.isPrimitive() || clazz == Byte.class || clazz == Short.class ||
                clazz == Integer.class || clazz == Long.class || clazz == Float.class ||
                clazz == Double.class || clazz == Character.class || clazz == Boolean.class;
    }
}
