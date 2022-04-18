package com.anjukt.data;

import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.Random;
import com.anjukt.model.TestData;
import com.anjukt.model.TestDataBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.anjukt.config.ConfigurationManager.configuration;

public class DataFactory {

    private final Faker faker;
    private static final Logger logger = LogManager.getLogger(DataFactory.class);

    public DataFactory() {
        faker = new Faker(new Locale(configuration().faker()));
    }

    public TestData createBookingData() {
        TestData fakeData = new TestDataBuilder().
            email(faker.internet().emailAddress()).
                password(faker.internet().password(8,16,true,false,true)).
                build();

        logger.info(fakeData);
        return fakeData;
    }

    private String returnRandomCountry() {
        return returnRandomItemOnArray(new String[]{"Belgium", "Brazil", "Netherlands"});
    }

    private String returnDailyBudget() {
        return returnRandomItemOnArray(new String[]{"$100", "$100 - $499", "$499 - $999", "$999+"});
    }

    private String returnRandomItemOnArray(String[] array) {
        return array[(new Random().nextInt(array.length))];
    }
}
