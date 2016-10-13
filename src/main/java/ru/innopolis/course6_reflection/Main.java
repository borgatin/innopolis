package ru.innopolis.course6_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created by innopolis on 10.10.16.
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<TypeForTest> clazz = TypeForTest.class;
        for (Constructor constructor : clazz.getConstructors())
        {
            System.out.println(constructor.getName());
            constructor.setAccessible(false);

        }
        TypeForTest typeForTest = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            field.set(typeForTest, 10);
            System.out.println(field.getName() + " value = " + field.get(typeForTest));
        }

    }
}
