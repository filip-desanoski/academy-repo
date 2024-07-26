package mk.iwec.formatter;

import mk.iwec.model.Student;

public class Formatter {

    private static final int FIRST_NAME_LENGTH = 5;
    private static final int LAST_NAME_LENGTH = 10;
    private static final int GENDER_LENGTH = 1;
    private static final int DATE_OF_BIRTH_LENGTH = 8;

    public static String formatString(String str, int length) {
        if (str.length() > length) {
            return str.substring(0, length);
        } else {
            return String.format("%-" + length + "s", str);
        }
    }

    public static String studentToFixedWidthString(Student student) {
        String firstName = formatString(student.getFirstName(), FIRST_NAME_LENGTH);
        String lastName = formatString(student.getLastName(), LAST_NAME_LENGTH);
        String gender = String.valueOf(student.getGender());
        String dateOfBirth = student.getDateOfBirth();
        return firstName + lastName + gender + dateOfBirth;
    }

    public static Student fixedWidthStringToStudent(String str) {
        String firstName = str.substring(0, FIRST_NAME_LENGTH).trim();
        String lastName = str.substring(FIRST_NAME_LENGTH, FIRST_NAME_LENGTH + LAST_NAME_LENGTH).trim();
        int gender = Integer.parseInt(str.substring(FIRST_NAME_LENGTH + LAST_NAME_LENGTH, FIRST_NAME_LENGTH + LAST_NAME_LENGTH + GENDER_LENGTH));
        String dateOfBirth = str.substring(FIRST_NAME_LENGTH + LAST_NAME_LENGTH + GENDER_LENGTH, FIRST_NAME_LENGTH + LAST_NAME_LENGTH + GENDER_LENGTH + DATE_OF_BIRTH_LENGTH);
        return new Student(firstName, lastName, gender, dateOfBirth);
    }
}

