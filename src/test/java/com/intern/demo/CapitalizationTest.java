package com.intern.demo;


import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;

public class CapitalizationTest {

    @Test
    public void convertToMapTest() {
        ImportedBook importedBook1 = new ImportedBook("joHN dOE", "IMPORTED book 1", "joHN dOE");
        ImportedBook importedBook2 = new ImportedBook("joHN dOE", "IMPORTED book 2", "joHN dOE");
        ImportedBook importedBook3 = new ImportedBook("joHN dOE", "IMPORTED book 3", "joHN dOE");
        ImportedBook importedBook4 = new ImportedBook("joHN dOE", "IMPORTED book 4", "joHN dOE");

        LocalBook localBook1 = new LocalBook("jaNE stARk", "loCal bOok 1", "gramEDia");
        LocalBook localBook2 = new LocalBook("jaNE stARk", "loCal bOok 2", "gramEDia");
        LocalBook localBook3 = new LocalBook("jaNE stARk", "loCal bOok 3", "gramEDia");
        LocalBook localBook4 = new LocalBook("jaNE stARk", "loCal bOok 4", "gramEDia");

        List<Book> inputs = Arrays.asList(
                importedBook1, importedBook2, importedBook3, importedBook4,
                localBook1, localBook2, localBook3, localBook4
        );

        Map<String, List<String>> bookSet = Capitalization.convertToMap(inputs);

        System.out.println(bookSet);

        String expectedResult = "{Jane Stark=[Local Book 1, Local Book 2, Local Book 3, Local Book 4], John Doe=[Imported Book 1, Imported Book 2, Imported Book 3, Imported Book 4]}";

        Assert.assertEquals(expectedResult, bookSet.toString());
    }

    @Test
    public void testCapitalization() {
        String testCase = "I want to lEARN JAVA";
        String expected = "I Want To Learn Java";
        try {
            String output = testCapitalize(testCase);
            System.out.printf("Input: '%s' | Output: '%s' | Expected: '%s'\n", testCase, output, expected);
            Assert.assertEquals(expected, output);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            fail();
        }
    }

    private String testCapitalize(String input) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = Capitalization.class.getDeclaredMethod("capitalize", String.class);
        m.setAccessible(true);
        return m.invoke(null, input).toString();
    }
}
