package main.java.week_15;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    /*
    Email Validator
Your team has created a new bank website that requires email addresses to be validated.
The email string must contain an '@' character.
The email string must contain an '.' character.
The '@' must contain at least one character in front of it.
e.g. "a@cydeo.com" is valid while "@cydeo.com" is invalid.
The '.' and '@' must be in the appropriate places.
e.g. "mike.smith@com" is invalid while "mike.smith@cydeo.com" is valid.
For a given string, find a solution that writes true on the console if an email is valid and false if it is invalid.
Examples:
str = "test@cydeo.com" --> true
str = "test@cydeo.co.uk --> true
str = "mike.smith@cydeo.com --> true
str = "mike.smith@com --> false
str = "@cydeo.com" --> false
str = "test@.com" --> false
str = "test@cydeo." --> false
str = "test@@cydeo.com" --> false
 */

    public static void main(String[] args) {
        System.out.println(isEmailValid("test@cydeo.com"));
        System.out.println(isEmailValid("test@cydeo.co.uk"));
        System.out.println(isEmailValid("mike.smith@cydeo.com"));
        System.out.println(isEmailValid("mike.smith@com"));
        System.out.println(isEmailValid("@cydeo.com"));
        System.out.println(isEmailValid("test@.com"));
        System.out.println(isEmailValid("test@cydeo."));
        System.out.println(isEmailValid("test@@cydeo.com"));
    }

    public static boolean isEmailValid(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        if (atIndex < 1 || atIndex != email.lastIndexOf('@')) {
            return false;
        }

        if (dotIndex <= atIndex + 1) {
            return false;
        }

        // Check if '.' is present and has characters after it
        return dotIndex != email.length() - 1;
    }

    public static boolean isEmailValid2(String str) {
        int sign = str.indexOf("@");
        int dot = str.lastIndexOf(".");

        if (sign < 1 || sign >= str.length() - 3 || sign != str.lastIndexOf("@")) {
            return false;
        }

        return dot != str.length() - 1 && sign + 1 < dot;
    }

}

