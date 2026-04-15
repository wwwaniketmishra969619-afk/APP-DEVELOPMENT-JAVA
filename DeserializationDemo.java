// Import classes for file handling and object deserialization
import java.io.FileInputStream;     // Used to read file as byte stream
import java.io.IOException;         // Handles input-output exceptions
import java.io.ObjectInputStream;   // Used to read object from file
import java.io.Serializable;        // Marker interface for serialization

// Student class implements Serializable so its object can be saved/loaded
class Student implements Serializable {
    private String name;   // Student name
    private int age;       // Student age

    // Constructor to initialize values
    Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // Method to display student details
    void display() {
        System.out.println("Age " + age);
        System.out.println("Name " + name);
    }
}

// Main class
public class DeserializationDemo {
    public static void main(String[] args) {

        try {
            // STEP 1: Create reference (not required for deserialization, but present here)
            Student s1 = new Student(34, "Danny");

            // STEP 2: Create FileInputStream to read from file
            FileInputStream fis = new FileInputStream("student.ser");

            // STEP 3: Create ObjectInputStream to read object
            ObjectInputStream ois = new ObjectInputStream(fis);

            // STEP 4: Read object from file and typecast to Student
            s1 = (Student) ois.readObject();

            // STEP 5: Close streams to free resources
            ois.close();
            fis.close();

            // STEP 6: Display deserialized object data
            s1.display();

        } catch (IOException e) {
            // Handles file-related errors
            System.out.println("File error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // Handles error if class is not found during deserialization
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}