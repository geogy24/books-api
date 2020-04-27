package wolox.training.factories;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class UserFactory {

    private Faker faker = new Faker();

    public HashMap<String, Object> user() {
        return new HashMap<String, Object>() {{
            put("username", faker.name().username());
            put("name", faker.name().fullName());
            put("birth_date", getBirthDate().toString());
        }};
    }

    private LocalDate getBirthDate() {
        return faker.date().past(faker.random().nextInt(0, 1000), TimeUnit.DAYS)
                   .toInstant()
                   .atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
