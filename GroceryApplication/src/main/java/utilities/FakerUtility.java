package utilities;

import com.github.javafaker.Currency;
import com.github.javafaker.Faker;

public class FakerUtility {

	Faker faker = new Faker();

	public String generateName() {
		return faker.name().fullName();
	}

	public String generateAddress() {
		return faker.address().fullAddress();
	}

	public String generatePhone() {
		return faker.phoneNumber().phoneNumber();
	}

	public String generateLandlineNo() {
		return faker.phoneNumber().cellPhone();
	}

	public String generateEmail() {
		return faker.internet().emailAddress();
	}

	public String Address() {
		return faker.address().buildingNumber();

	}

	public String generateCity() {
		return faker.address().city();

	}

	public String generateCountry() {
		return faker.address().country();
	}

	public Currency generateCurrency() {

		return faker.currency();
	}

	public String generateRandomDigits(int count) {
		return faker.number().digits(count);
	}
}
