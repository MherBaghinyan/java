package com.ef;

import com.ef.entity.ServerLogReader;
import com.ef.repository.BeanConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Parser {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                BeanConfiguration.class);

        ServerLogReader serverLogReader = context
                .getBean(ServerLogReader.class, args);

        Map<String, String> argsMap = parseCommandLineArgs(args);

        serverLogReader.readFromFile(argsMap);
    }

    private static Map<String, String> parseCommandLineArgs(String[] args) {

        SimpleCommandLinePropertySource ps = new SimpleCommandLinePropertySource(args);

        return Arrays.stream(ps.getPropertyNames())
                .collect(Collectors.toMap(p -> p, ps::getProperty));
    }

}
