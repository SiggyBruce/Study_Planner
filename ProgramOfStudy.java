/**
 * ProgramOfStudy.java - FEB-14-2016 - ITEC 220 - 
 * This class contains a 2D array of courses and methods that manipulate the 2D course array and course data.
 * @author Tre Haga
 * @version 1.0
 */
import java.io.*;
import java.util.*;
public class ProgramOfStudy implements Serializable
{
    /**
     * The ProgramOfStudy class instance variables.
     */
    private Course course;
    private Course[][] courses;
    /**
     * The ProgramOfStudy class constructor.
     * Creates the 2D array of courses objects.
     */
    public ProgramOfStudy()
    {
        this.courses = new Course[10][8];
    }
    /**
     * The addCourse method takes in data from the controller class to create a new course object and adds that course to the next available spot in the array specified by the semester.
     * @param courseName The variable that contains the course name data for a course.
     * @param department The variable that contains the course department data for a course.
     * @param creditHours The variable that contains the courses credit hours data for a course.
     * @param courseNumber The variable that contains the course number data for a course.
     * @param semester The variable that contains the course semester data for a course.
     */
    public void addCourse(String courseName, String department, int creditHours, int courseNumber, int semester)
    {
        Course newCourse = new Course(courseName, department, "", creditHours, courseNumber, semester);
        int column = 0;
        boolean isNotDone = true;
        while ((isNotDone) && (column < courses[semester].length))
        {
            if (courses[semester][column] == null)
            {
                this.courses[semester][column] = newCourse;
                System.out.println("\nCourse added!");
                isNotDone = false;
            }
            column++;
        }
    }
    /**
     * The addPrerequiste method takes in data from the Controller class to create a new prerequisite for a course specified by the semester and course index.
     * @param newPrerequisite The variable that contains the course prerequisite data for a course.
     * @param semester The variable that contains the course semester data for a course.
     * @param courseIndex The variable that contains the course index data for a course.
     */
    public void addPrerequisite(String newPrerequisite, int semester, int courseIndex)
    {
        boolean isNotDone = true;
        int index = 0;
        while ((isNotDone) && (index < this.courses[semester][courseIndex].getPrerequisites().length))
        {
            if (this.courses[semester][courseIndex].getPrerequisites()[index] == null)
            {
                this.courses[semester][courseIndex].setPrerequisites(newPrerequisite, index);
                System.out.println("\nPrerequisite added!");
                isNotDone = false;
            }
            index++;
        }
    }
    /**
     * The removeCourse method deletes a course specified by the semester and course index.
     * @param semester The variable that contains the course semester data for a course.
     * @param courseIndex The variable that contains the course index data for a course.
     */
    public void removeCourse(int semester, int courseIndex)
    {
        if (this.courses[semester][courseIndex] != null)
        {
            this.courses[semester][courseIndex] = null;
            System.out.println("\nCourse removed!");
        }
        else
        {
            System.out.println("\nThere is no existing course located here.");
        }
        
    }
    /**
     * The addGrade method adds a grade to a course specified by the semester and course index.
     * @param semester The variable that contains the course semester data for a course.
     * @param courseIndex The variable that contains the course index data for a course.
     * @param grade The variable that contains the course grade data for a course.
     */
    public void addGrade(int semester, int courseIndex, String grade)
    {
        courses[semester][courseIndex].setGrade(grade);
        System.out.println("\nGrade added!");
    }
    /**
     * The loadTemplateFile method loads a template file and populates a 2D array of Course.
     * @param filename The variable that contains the filename.
     */
    public void loadTemplateFile(String filename)
    {
        Scanner input = new Scanner(System.in);
        try
        {
            input = new Scanner(new File(filename));
        }
        catch (Exception exception)
        {
            System.out.println("\nError! Could not load file.");
        }
        while (input.hasNext())
        {
            int semesterIndex = input.nextInt();
            int courseIndex = input.nextInt();
            String department = input.next();
            int courseNumber = input.nextInt();
            int creditHours = input.nextInt();
            String courseName = "\b" + input.nextLine();

            this.course = new Course(courseName, department, "", creditHours, courseNumber, semesterIndex);
            this.courses[semesterIndex][courseIndex] = course;
        }
        input.close();
        System.out.println("\nLoad successful!");
    }
    /**
     * The loadPrimaryFile method loads the user's primary file and populates a 2D array of Course.
     * @param filename The variable that contains the filename.
     */
    public void loadPrimaryFile(String filename)
    {
        try
        {
            FileInputStream fileInput = new FileInputStream(filename);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            this.courses = (Course[][])objectInput.readObject();

            objectInput.close();
            fileInput.close();
			
            System.out.println("\nLoad successful!");
        }
        catch (Exception exception)
        {
            System.out.println("\nError! Could not load file.");
        }
    }
    /**
     * The saveFile method saves all information in the 2D array of Course to a file the user specifies.
     * @param filename The variable that contains the filename.
     */
    public void saveFile(String filename)
    {
        try
        {
            FileOutputStream fileOutput = new FileOutputStream(filename);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(this.courses);

            objectOutput.close();
            fileOutput.close();

            System.out.println("\nSave successful!");
        }
        catch (Exception exception)
        {
            System.out.println("\nError! Could not save file.");
        }
    }
    /**
     * The printCourses method prints all of the courses in the 2D array of courses.
     */
    public void printCourses()
    {
        for (int row = 0; row < courses.length; row++)
        {
            for (int column = 0; column < courses[row].length; column++)
            {
                if (courses[row][column] != null)
                {
                    System.out.println("\n" + courses[row][column]);
                }
                else
                {
                    System.out.println("\nEmpty");
                }
            }
        }
    }
    /**
     * The printSemester method prints all of the courses in a semester.
     * @param semester The variable that contains the course semester data for a course.
     */
    public void printSemester(int semester)
    {
        for (int column = 0; column < courses[semester].length; column++)
        {
            if (courses[semester][column] != null)
            {
                System.out.println("\n" + courses[semester][column]);
            }
            else
            {
                System.out.println("\nEmpty");
            }
        }
    }
    /**
     * The findCourse method finds a course in the 2D array of courses specified by a course department and number.
     * @param department  The variable that contains the course department data for a course.
     * @param courseNumber  The variable that contains the course number data for a course.
     */
    public void findCourse(String department, int courseNumber)
    {
        boolean isFound = false;
        for (int row = 0; row < courses.length; row++)
        {
            for (int column = 0; column < courses[row].length; column++)
            {
                if (courses[row][column] != null)
                {
                    if (courses[row][column].getDepartment().equals(department))
                    {
                        if (courses[row][column].getCourseNumber() == courseNumber)
                        {
                            System.out.println("\nCourse found! The course is found in semester " + (courses[row][column].getSemester() + 1) + ".");
                            isFound = true;
                        }
                    }
                }
            }
        }
        if (!isFound)
        {
            System.out.println("\nCound not find the course you specified.");
        }
    }
    /**
     * The checkPrerequisite method goes through the 2D array of courses and finds a courses that has prerequisites.
     * Once it finds a prerequisite it looks at the previous semester for that course.
     * If that course does not exist then the program will print the course that is missing its prerequisite course.
     */
    public void checkPrerequisite()
    {
        boolean isFound = false;
        for (int row = 0; row < courses.length; row++)
        {
            for (int column = 0; column < courses[row].length; column++)
            {
                if (courses[row][column] != null)
                {
                    for (int index = 0; index < courses[row][column].getPrerequisites().length; index++)
                    {
                        if (courses[row][column].getPrerequisites()[index] != null)
                        {
                            String number = "";
                            int position = 5;
							int newRow = row - 1;
							boolean stopSearch = true;
                            while (position < 8)
                            {
                                number += courses[row][column].getPrerequisites()[index].charAt(position);
                                position++;
                            }
                            if (row > 0)
                            {
                                while ((newRow < courses.length) && (stopSearch))
                                {
                                    if (courses[newRow][column] != null)
                                    {
                                        if (courses[newRow][column].getCourseNumber() == Integer.parseInt(number))
                                        {
                                            stopSearch = false;
                                        }
                                        else if (courses[newRow][column].getCourseNumber() != Integer.parseInt(number)) 
                                        {
                                            System.out.println("\n" + courses[row][column]);
                                            stopSearch = false;
                                            isFound = true;
                                        }
                                    }
                                    newRow++;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!isFound)
        {
            System.out.println("\nNo missing prerequisite courses!");
        }
    }
}