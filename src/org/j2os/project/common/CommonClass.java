package org.j2os.project.common;

public class CommonClass {
    private CommonClass() {

    }
    private static final CommonClass COMMON_CLASS = new CommonClass() ;

    public static CommonClass getInstance() {
        return COMMON_CLASS;
    }
    //***************************************************************
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
