package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Misha")
        );
    }

    @Test
    public void whenPairWithComments() {
        String path = "./data/pair_with_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("danon2"),
                is("Test2")
        );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenNoKey() {
        String path = "./data/pair_with_comments.properties";
        Config config = new Config(path);
        config.load();
        config.value("test");
    }



}