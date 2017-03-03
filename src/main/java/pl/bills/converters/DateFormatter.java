package pl.bills.converters;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by trot on 10.02.17.
 */
@Component
public class DateFormatter implements Formatter<Date> {

    public DateFormatter() {
        super();
    }

    @Override
    public Date parse(final String text, final Locale locale) throws ParseException {
        return createDateFormat(locale).parse(text);
    }

    @Override
    public String print(final Date object, final Locale locale) {
        return createDateFormat(locale).format(object);
    }

    private SimpleDateFormat createDateFormat(final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        return dateFormat;
    }

}