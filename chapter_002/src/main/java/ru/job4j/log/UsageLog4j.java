package ru.job4j.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte b = 127;
        short s = 32766;
        int i = 2147483646;
        long l = 9223372036854775806L;
        float f = 3;
        double d = 3.3;
        boolean bool = true;
        LOG.debug("info byte : {}, short : {}, int : {}, long : {}, float : {}, double : {}, boolean : {},"
                , b, s, i, l, f, d, bool);
    }

}
