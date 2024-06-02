package com.eric.hello_cash.utils;

import java.time.Year;
import java.util.Random;

public class AccountNumberGenerator {

    private static final int ACCOUNT_NUMBER_LENGTH = 10;

    // Generate a random numeric account number starting with the last two digits of the current year followed by 8 random digits
    public static String generateAccountNumber() {
        String currentYearLastTwoDigits = String.valueOf(Year.now().getValue()).substring(2);
        StringBuilder accountNumber = new StringBuilder(currentYearLastTwoDigits);

        Random random = new Random();
        // Generate random digits until the account number reaches the desired length
        while (accountNumber.length() < ACCOUNT_NUMBER_LENGTH) {
            // Append a random digit (0-9)
            accountNumber.append(random.nextInt(10));
        }

        return accountNumber.toString();
    }
}
