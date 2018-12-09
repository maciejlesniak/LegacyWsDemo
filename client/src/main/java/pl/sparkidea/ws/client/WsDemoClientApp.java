package pl.sparkidea.ws.client;

import hello.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.sparkidea.ws.client.client.CountryClient;

@SpringBootApplication
public class WsDemoClientApp {
    private static final Logger LOG = LoggerFactory.getLogger(WsDemoClientApp.class);

    public static void main(String[] args) {
        SpringApplication.run(WsDemoClientApp.class, args);
    }

    @Bean
    public CommandLineRunner lookup(final CountryClient countryClient) {
        return args -> {
            String country = "Spain";

            if (args.length > 0) {
                country = args[0];
            }
            GetCountryResponse response = countryClient.getCountry(country);
            LOG.info("Got country [{}] response with currency [{}]",
                    response.getCountry().getName(),
                    response.getCountry().getCurrency());
        };
    }

}
