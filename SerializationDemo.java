// Import required classes for serialization
import java.io.Serializable;          // Marker interface
import java.io.FileOutputStream;     // Used to write file as byte stream
import java.io.IOException;          // Handles IO exceptions
import java.io.ObjectOutputStream;   // Used to write object into file

// Student class must implement Serializable to allow object serialization
class Student implements Serializable {
    private String name;   // Student name
    private int age;       // Student age

    // Constructor to initialize values
    Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

// Main class
public class SerializationDemo {
    public static void main(String[] args) {

        // STEP 1: Create Student object (not used later, just example)
        Student student = new Student(20, "John Doe");

        try {
            // STEP 2: Create another object to serialize
            Student student1 = new Student(22, "Jane Doe");

            // STEP 3: Create FileOutputStream to write into file
            // File "student.ser" will be created if it doesn't exist
            FileOutputStream fileOut = new FileOutputStream("student.ser");

            // STEP 4: Create ObjectOutputStream to write object
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // STEP 5: Write object into file (Serialization happens here)
            out.writeObject(student1);

            // STEP 6: Close streams to save data properly
            out.close();
            fileOut.close();

            System.out.println("Object serialized successfully");

        } catch (IOException e) {
            // STEP 7: Handle exceptions
            e.printStackTrace();
        }
    }
}