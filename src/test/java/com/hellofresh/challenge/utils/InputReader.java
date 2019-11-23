package com.hellofresh.challenge.utils;

import com.hellofresh.challenge.configuration.StringConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rinat on 20.11.2019.
 */
public class InputReader {

    private static Logger logger = LoggerFactory.getLogger(InputReader.class);

    public static Map<String, String> fillMapFromFile(String pathToFile){
        File file = new File(System.getProperty("user.dir") +"\\"+ pathToFile);
        logger.debug("" + file.exists());
        logger.debug("" +file.canRead());
        file.setReadable(true);
        logger.debug("" + file.exists());
        logger.debug("" +file.canRead());
        int c;
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        String buffer = "";
        String key = "";
        String value = "";
        Map<String, String> outputMap = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(reader = new FileReader(file));
            while((c = bufferedReader.read())!=-1){
                char temp = (char)c;
                if(temp == StringConstants.FILE_KEY_DELIMETER.charAt(0)) {
                    key = buffer;
                    buffer = "";
                    logger.debug("key: " + key);
                }
                else if(temp == StringConstants.FILE_LINE_DELIMETER.charAt(0) && !key.equals("")) {
                    value = buffer;
                    logger.debug("value: " + value);
                    outputMap.put(key.trim(),value.trim());
                    logger.debug("outputMap: " + outputMap);
                    key="";
                    value="";
                    buffer="";
                }else {
                    buffer = buffer + temp + "";
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
                if (reader != null) {
                    reader.close();
                }
                logger.debug("Read string = "  + buffer);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        logger.info("Final value of outputMap: " + outputMap);
        return outputMap;
    }
}
