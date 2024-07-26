package mk.iwec.filehandler;

import mk.iwec.model.Student;
import mk.iwec.formatter.Formatter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static List<Student> readFromFile(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines) {
            students.add(Formatter.fixedWidthStringToStudent(line));
        }
        return students;
    }

    public static void writeToFile(List<Student> students, String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Student student : students) {
            lines.add(Formatter.studentToFixedWidthString(student));
        }
        Files.write(Paths.get(filePath), lines);
    }
}
