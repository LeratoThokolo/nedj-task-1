package nedj.train.task1webservice.nedj.train.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDateForExceptions {

    public static String formatDate(Date date){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-YYYY HH:MM");

        return simpleDateFormat.format(date);
    }
}
