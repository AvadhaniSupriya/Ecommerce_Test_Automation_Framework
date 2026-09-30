package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.Addresses;

public class FakeAddressUtility {
	
	
	
	
	public static void main(String[] args)
	{
		
		
		getFakeAddress();
		
		
		
		
		
	}
	public static Addresses getFakeAddress()
	{
		
		
		Faker faker= new Faker(Locale.US);
		
		Addresses address= new Addresses(faker.company().name(),faker.address().buildingNumber(),faker.address().streetAddress(),faker.address().cityName(),faker.address().state(),faker.number().digits(5),faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(), "NA", "Residential Address");
		
		return address;
	}

}
