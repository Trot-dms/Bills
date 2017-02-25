package pl.bills.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.bills.converters.*;

/**
 * Created by trot on 03.02.17.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new PriceStringToDecimalConverter());

        registry.addFormatter(new PriceFormatter());
        registry.addFormatter(new DateFormatter());
        registry.addFormatter(new StatusFormatter());
        registry.addFormatter(new CategoryFormatter());
        registry.addFormatter(new LoanHolderFormatter());
    }
}
