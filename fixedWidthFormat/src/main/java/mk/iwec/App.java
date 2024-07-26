package mk.iwec;

import mk.iwec.filehandler.FileHandler;
import mk.iwec.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            List<Student> students = new ArrayList<>();
            students.add(new Student("Pero", "Perov", 0, "20030203"));
            students.add(new Student("Alexandra", "Vladimirovska", 1, "20001010"));

            String filePath = "students.txt";
            FileHandler.writeToFile(students, filePath);

            List<Student> readStudents = FileHandler.readFromFile(filePath);
            for (Student student : readStudents) {
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " +
                        student.getGender() + " " + student.getDateOfBirth());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

