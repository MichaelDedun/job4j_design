package ru.job4j.tdd;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GeneratorTest {

    @Test(expected = Exception.class)
    public void checkTemplateKeys() {
        Gener gener = new Gener();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name","Misha");
        String actual = gener.produce(template,map);
        String expected = "I am a Misha, Who are you? ";
        assertEquals(expected,actual);
    }

    @Test(expected = Exception.class)
    public void checkMapKeys() {
        Gener gener = new Gener();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name","Misha");
        map.put("subject","Who are you");
        map.put("error key","Who are you");
        String actual = gener.produce(template,map);
        String expected = "I am a Misha, Who are you? ";
        assertEquals(expected,actual);
    }



}