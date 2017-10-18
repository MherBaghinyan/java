import java.util.HashMap;
import java.util.Map;

public class StartingPoint {

    public static void main(String[] args) {

        //        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
//                BeanConfiguration.class);
//        PersonRepository personRepository = context
//                .getBean(PersonRepository.class);

        ServerLogReader.readFromFile("access.log");

        if (args == null || args.length == 0) {
            System.out.println("Empty args...");
            System.exit(0);
        }

        if (args.length == 3) {
            System.out.println(args[0]);
            System.out.println(args[1]);
            System.out.println(args[2]);

            parseCommandLineArgs(args);
        }
    }

    private static Map<String, String> parseCommandLineArgs(String[] args) {

        Map<String, String> argsMap = new HashMap<String, String>();

        for (String item : args) {
            String[] values = item.split("\\--\\=");
            argsMap.put(values[0], values[1]);
        }

        return argsMap;
    }
}
