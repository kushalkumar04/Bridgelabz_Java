package objectorientedprogramming.inheritance.multilevelinheritence;
/*
 * Educational Course Hierarchy
 *
 * Demonstrates multilevel inheritance.
 * Course is the base class.
 * OnlineCourse extends Course.
 * PaidOnlineCourse extends OnlineCourse.
 *
 * Each level adds more attributes and specialization.
 */

class Course {

    // Common course attributes
    String courseName;
    int duration; // duration in hours

    // Constructor
    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Method to display course details
    void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

/*
 * OnlineCourse class
 *
 * Extends Course and adds online-specific details.
 */
class OnlineCourse extends Course {

    String platform;
    boolean isRecorded;

    // Constructor using super keyword
    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Overridden method
    @Override
    void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
    }
}

/*
 * PaidOnlineCourse class
 *
 * Extends OnlineCourse and adds payment-related details.
 */
class PaidOnlineCourse extends OnlineCourse {

    double fee;
    double discount;

    // Constructor using super keyword
    PaidOnlineCourse(String courseName, int duration, String platform,
                     boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    // Overridden method
    @Override
    void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Course Fee: " + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: " + (fee - (fee * discount / 100)));
    }
}

public class EducationalCourseHierarchy {

    public static void main(String[] args) {

        Course course1 = new Course("Java Basics", 40);
        Course course2 = new OnlineCourse("Advanced Java", 60, "Coursera", true);
        Course course3 = new PaidOnlineCourse(
                "Spring Boot Masterclass",
                80,
                "Udemy",
                true,
                5000,
                20
        );

        // Polymorphism across multiple inheritance levels
        course1.displayCourseDetails();
        System.out.println();

        course2.displayCourseDetails();
        System.out.println();

        course3.displayCourseDetails();
    }
}