// Import FileWriter class to write data into a file
import java.io.FileWriter;

// Import IOException to handle file-related errors
import java.io.IOException;

// Define a Student class
class Student {
    int id;       // Variable to store student ID
    String name;  // Variable to store student name

    // Constructor to initialize student data
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// Main class
public class FileWriteDemo {
    public static void main(String[] args) {

        // STEP 1: Create a Student object with ID and Name
        Student s1 = new Student(1, "Henry");

        try {
            // STEP 2: Create FileWriter object to open/create file "Student.txt"
            FileWriter fw = new FileWriter("Student.txt");

            // STEP 3: Write student ID into file
            fw.write("ID: " + s1.id + "\n");

            // STEP 4: Write student name into file
            fw.write("Name: " + s1.name + "\n");

            // STEP 5: Close the FileWriter to save data and free resources
            fw.close();

            // STEP 6: Print success message on console
            System.out.println("Data Written successfully");

        } catch (IOException e) {
            // STEP 7: Handle any file-related errors
            System.out.println("Error: " + e.getMessage());
        }
    }
}