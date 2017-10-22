package com.ef;

import com.ef.entity.RequestData;
import com.ef.entity.ServerLogReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.ef.repository.BeanConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                BeanConfiguration.class);

        ServerLogReader serverLogReader = context
                .getBean(ServerLogReader.class);


        Map<String, String> argsMap = parseCommandLineArgs(args);

        List<RequestData> filteredItems = serverLogReader.readFromFile(argsMap);
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
