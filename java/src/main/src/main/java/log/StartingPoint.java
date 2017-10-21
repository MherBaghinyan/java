package log;

import log.entity.AccessLog;
import log.entity.ServerLogReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import log.repository.BeanConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StartingPoint {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                BeanConfiguration.class);

        ServerLogReader serverLogReader = context
                .getBean(ServerLogReader.class);


        Map<String, String> argsMap = parseCommandLineArgs(args);

        List<AccessLog> filteredItems = serverLogReader.readFromFile(argsMap);
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
