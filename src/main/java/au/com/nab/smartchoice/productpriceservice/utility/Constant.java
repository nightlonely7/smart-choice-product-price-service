package au.com.nab.smartchoice.productpriceservice.utility;

import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class Constant {

    public static final String DATE_TIME_FORMAT = "uuuu-MM-dd HH:mm:ss";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    public static final String OBTAINED_RESPONSE_CODE = "OBTAINED";
    public static final String NOT_FOUND_RESPONSE_CODE = "NOT_FOUND";
    public static Supplier<IllegalArgumentException> notFoundException(String field, String value) {
        return () -> new IllegalArgumentException(field + " '" + value + "' not found.");
    }
}
