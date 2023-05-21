package org.j2os.project.common;

import org.j2os.project.exception.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

public class EXCEPTION {
    private static final Logger LOGGER = Logger.getLogger(EXCEPTION.class);
    public static Map<String, String> getError(Exception e) {
        e.printStackTrace();
        Map<String, String> map = new HashMap<>();
        if (e instanceof IOException) {
            map.put("code", "1001");
            map.put("msg", "IO Error");
            LOGGER.error(e.getClass() + " : " + e.getMessage());
        } else if (e instanceof SQLException) {
            map.put("code", "1002");
            map.put("msg", "Database Error");
            LOGGER.error(e.getClass() + " : " + e.getMessage());
        } else if (e instanceof NumberFormatException) {
            map.put("code", "1003");
            map.put("msg", "incorrect format number error");
            LOGGER.error(e.getClass() + " : " + e.getMessage());
        }else if (e instanceof NullPointerException) {
            map.put("code", "1004");
            map.put("msg", "Null Pointer Error");
            LOGGER.error(e.getClass() + " : " + e.getMessage());
        } else if (e instanceof RecordDoesNotExistException) {
            map.put("code", "1005");
            map.put("msg", "Record Does not Exists");
            LOGGER.error(e.getClass() + " : " + e.getMessage());
        } else if (e instanceof RecordIsRepeatedException) {
            map.put("code", "1006");
            map.put("msg", "Record is repeated data");
            LOGGER.error(e.getClass() + " : " + e.getMessage());
        }else if (e instanceof ImpossibleRemoveRecordException) {
            map.put("code", "1007");
            map.put("msg", "It is impossible to remove record");
            LOGGER.error(e.getClass() + " : " + e.getMessage());
        }else if (e instanceof InCorrectDataException) {
            map.put("code", "1008");
            map.put("msg", "It is an in correct record");
            LOGGER.error(e.getClass() + " : " + e.getMessage());
        }else if (e instanceof OverFlowReservetionException) {
            map.put("code", "1009");
            map.put("msg", "بلیط تمام شده است");
            LOGGER.error(e.getClass() + " : " + e.getMessage());
        }else{
            map.put("code", "2000");
            map.put("msg", "Please call support team.");
            LOGGER.error(e.getClass() + " : " + e.getMessage());
        }
        return map;

    }
}
