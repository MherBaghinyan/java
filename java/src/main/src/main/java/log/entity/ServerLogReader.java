package log.entity;

import log.ArgsEnum;
import log.RequestBean;
import log.Utils;
import log.repository.AccessLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServerLogReader {

    @Value(value = "classpath:access.log")
    private Resource accessLog;
    @Autowired
    private AccessLogRepository accessLogRepository;

    public List<AccessLog> readFromFile(Map<String, String> argsMap) {
        List<AccessLog> logList = new ArrayList<>();
        List<AccessLog> filteredLogList = new ArrayList<>();

        BufferedReader br = null;

        try {

            Long threshold =  Long.parseLong(argsMap.get(ArgsEnum.THRESHOLD.getVar()));
            InputStream stream = accessLog.getInputStream();

            String currentLine;
            br = new BufferedReader(new InputStreamReader(stream));//file name with path
            boolean thresHoldInValid = (logList.size() >= threshold);

            Map<String, Long> ipCounts = new HashMap<>();

            while ((currentLine = br.readLine()) != null) {
                // when the limit of threshold is reached exit from the loop
                if (thresHoldInValid) {
                    break;
                }

                String[] strArr = currentLine.split("\\|");

                if (Utils.isLogDateValid(strArr[0], argsMap.get(ArgsEnum.START_DATE.getVar()), argsMap.get(ArgsEnum.DURATION.getVar()))) {
                    AccessLog bean = new AccessLog(Utils.getLocalDateTime(strArr[0], Utils.LOG_DATE_FORMATTER),
                            strArr[1]);
                    logList.add(bean);
                    System.out.println(strArr[0] + " | " + strArr[1]);

                    if (ipCounts.get(strArr[1]) != null) {
                        ipCounts.put(strArr[1], ipCounts.get(strArr[1]) + 1);
                    } else {
                        ipCounts.put(strArr[1], 1L);
                    }

                }
            }

            Map<String, Long> filteredMap = ipCounts.entrySet()
                    .stream()
                    .filter(k -> k.getValue() >= threshold)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            System.out.println("Filtered IPs " + Arrays.toString(filteredMap.keySet().toArray()));
            System.out.println("Filtered IPs frequency " + Arrays.toString(filteredMap.values().toArray()));

            filteredLogList = logList.stream()
                    .filter(item -> filteredMap.keySet().contains(item.getIp()))
                    .collect(Collectors.toList());

            accessLogRepository.save(filteredLogList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return filteredLogList;
    }

}
