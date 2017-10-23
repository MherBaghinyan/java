package com.ef.entity;

import com.ef.ArgsEnum;
import com.ef.helpers.Utils;
import com.ef.repository.AccessLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServerLogReader {

    @Value(value = "classpath:access.log")
    private Resource accessLog;
    @Autowired
    private AccessLogRepository accessLogRepository;

    public void readFromFile(Map<String, String> argsMap) {
        List<RequestData> logList = new ArrayList<>();

        BufferedReader br = null;

        try {

            Long threshold =  Long.parseLong(argsMap.get(ArgsEnum.THRESHOLD.getVar()));
            InputStream stream = accessLog.getInputStream();

            String currentLine;
            br = new BufferedReader(new InputStreamReader(stream));

            Map<String, Long> ipCounts = new HashMap<>();

            while ((currentLine = br.readLine()) != null) {

                String[] strArr = currentLine.split("\\|");

                if (Utils.isLogDateValid(strArr[0], argsMap.get(ArgsEnum.START_DATE.getVar()), argsMap.get(ArgsEnum.DURATION.getVar()))) {
                    RequestData bean = new RequestData(Utils.getLocalDateTime(strArr[0], Utils.LOG_DATE_FORMATTER),
                            strArr[1], strArr[4]);
                    logList.add(bean);

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

            List<RequestData> filteredLogList = logList.stream()
                    .filter(item -> filteredMap.keySet().contains(item.getIp()))
                    .collect(Collectors.toList());

            // save the filtered data to mysql
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
    }

}
