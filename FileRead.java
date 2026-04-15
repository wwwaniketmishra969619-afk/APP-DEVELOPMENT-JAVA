// Import required classes for file handling
import java.io.FileWriter;      // Used to write data into a file
import java.io.IOException;     // Used to handle input-output exceptions
import java.io.FileReader;      // Used to read data from a file
import java.io.BufferedReader;  // Used to read text efficiently

// Student class to store student details
class Student {
    int id;        // Variable to store student ID
    String name;   // Variable to store student name

    // Constructor to initialize values
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// Main class
public class FileRead {
    public static void main(String[] args) {

        // STEP 1: Create a Student object
        Student s1 = new Student(1, "Henry");

        try {
            // STEP 2: Create FileWriter object to write data into file
            // If file doesn't exist, it will be created
            FileWriter fw = new FileWriter("Student.txt");

            // STEP 3: Write student data into file
            fw.write("ID: " + s1.id + "\n");      // Write ID
            fw.write("Name: " + s1.name + "\n");  // Write Name

            // STEP 4: Close FileWriter to save data properly
            fw.close();

            System.out.println("Data Written successfully");

            // STEP 5: Create BufferedReader to read file
            BufferedReader br = new BufferedReader(new FileReader("Student.txt"));

            String line;  // Variable to store each line read from file

            // STEP 6: Read file line by line until end (null)
            while ((line = br.readLine()) != null) {
                System.out.println(line);  // Print each line
            }

            // STEP 7: Close BufferedReader
            br.close();

        } catch (IOException e) {
            // STEP 8: Handle exceptions (if file error occurs)
            System.out.println("Error: " + e.getMessage());
        }
    }
}
