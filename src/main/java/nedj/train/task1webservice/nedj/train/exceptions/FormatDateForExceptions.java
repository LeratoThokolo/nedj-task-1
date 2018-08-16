package nedj.train.task1webservice.nedj.train.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDateForExceptions {

    private FormatDateForExceptions(){

    }

    public static String formatDate(Date date){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMMM-dd HH:MM");

        return simpleDateFormat.format(date);
    }
}
