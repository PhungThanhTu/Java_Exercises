package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator {
    private String dateFormat;

    public DateValidator(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    /**
     * Validate a string to check whether it is date
     * @param dateStr the date string to check
     * @return true if it's date, false if not
     */
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
