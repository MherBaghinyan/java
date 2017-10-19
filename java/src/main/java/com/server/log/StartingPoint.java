package com.server.log;

import com.server.log.entity.ServerLogReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.server.log.repository.BeanConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StartingPoint {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                BeanConfiguration.class);

        ServerLogReader serverLogReader = context
                .getBean(ServerLogReader.class);

        if (args == null || args.length == 0) {
            System.out.println("Empty args...");
            System.exit(0);
        }

        if (args.length == 3) {
            System.out.println(args[0]);
            System.out.println(args[1]);
            System.out.println(args[2]);
        }

        Map<String, String> argsMap = parseCommandLineArgs(args);

        List<RequestBean> filteredItems = serverLogReader.readFromFile("access.log", argsMap);
        System.out.println("Total items count = " + filteredItems.size());
    }

    private static Map<String, String> parseCommandLineArgs(String[] args) {

        Map<String, String> argsMap = new HashMap<>();

        for (String item : args) {
            String[] values = item.split("(--)|\\=");
            argsMap.put(values[1], values[2]);
        }

        return argsMap;
    }

}
