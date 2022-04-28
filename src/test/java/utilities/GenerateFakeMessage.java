package utilities;

import com.github.javafaker.Faker;

public class GenerateFakeMessage {

    public static String getAccountName(){
        Faker faker = new Faker();
        return  faker.beer().name();
    }

    public static String getPhone() {
        Faker faker = new Faker();
        return faker.phoneNumber().phoneNumber();
    }
}
