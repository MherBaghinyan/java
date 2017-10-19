package com.server.log.entity;

import com.server.log.ArgsEnum;
import com.server.log.RequestBean;
import com.server.log.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ServerLogReader {

    @Value(value = "classpath:access.log")
    private Resource accessLog;

    public List<RequestBean> readFromFile(String path, Map<String, String> argsMap) {
        List<RequestBean> logList = new ArrayList<>();
        Map<String, Long> ipCounts = new HashMap<>();

        BufferedReader br = null;

        try {

            Long threshold =  Long.parseLong(argsMap.get(ArgsEnum.THRESHOLD.getVar()));
            InputStream stream = accessLog.getInputStream();

            String currentLine;
            br = new BufferedReader(new InputStreamReader(stream));//file name with path
            boolean thresHoldInValid = (logList.size() >= threshold);
            while ((currentLine = br.readLine()) != null) {
                // when the limit of threshold is reached exit from the loop
                if (thresHoldInValid) {
                    break;
                }

                String[] strArr = currentLine.split("\\|");

                if (Utils.isLogDateValid(strArr[0], argsMap.get(ArgsEnum.START_DATE.getVar()), argsMap.get(ArgsEnum.DURATION.getVar()))) {
                    RequestBean bean = new RequestBean(Utils.getLocalDateTime(strArr[0], Utils.LOG_DATE_FORMATTER),
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

            System.out.println("IP counts are... " + ipCounts.values());
            System.out.println("IP max counts is... " + ipCounts.values().stream().mapToInt(Long::intValue).max());
            System.out.println("IP counts in total... " + ipCounts.values().stream().mapToInt(Long::intValue).sum());

            ipCounts.values().stream().filter(i -> i>= threshold).collect(Collectors.toList());

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

        return logList;
    }

}
