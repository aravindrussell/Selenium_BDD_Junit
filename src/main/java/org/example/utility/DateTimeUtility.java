package org.example.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtility {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");

    public String getCurrentDateTime(){
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

}
