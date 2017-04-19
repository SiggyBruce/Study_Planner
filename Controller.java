/**
 * Controller.java - FEB-14-2016 - ITEC 220 - 
 * This class contains the logic and controls the data flow from the view to the model of the program. 
 * It exchanges data from the view to the model and vise versa.
 * @author Tre Haga
 * @version 1.0
 */
public final class Controller
{
    /**
     * The Controller class instance variables.
     */
    private View view = new View();
    private ProgramOfStudy pos = new ProgramOfStudy();
    private boolean stopProgram = false;
    /**
     * The run method that initiates the beginning of the program.
     * Calls for the display from the View class.
     */
    public void run()
    {
        startMenuControl(view.startMenu());
        
        while(!stopProgram)
        {
            mainMenuControl(view.mainMenu());
        }
    }
    /**
     * The startMenuControl method contains the decision based logic for the start menu.
     * Calls methods from the View class and interprets the input accordingly.
     * @param input The variable that contains the input from the user to be checked.
     */
    public void startMenuControl(String input)
    {
        boolean isNotDone = true;
        while (isNotDone)
        {
            switch (input.toUpperCase())
            {
                case "Y":
                    loadFileMenuControl(view.loadFileDisplay());
                    isNotDone = false;
                    break;
                case "N":
                    concentrationMenuControl(view.concentrationMenu());
                    isNotDone = false;
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again.\n");
                    input = view.startMenu();
            }
        }
    }
    /**
     * The concentrationMenuControl method contains the decision based logic for the concentration menu.
     * Calls methods from the ProgramOfStudy class and interprets the input accordingly.
     * @param input The variable that contains the input from the user to be checked.
     */
    public void concentrationMenuControl(String input)
    {
        boolean isNotDone = true;
        while (isNotDone)
        {
            switch(input.toUpperCase())
            {
                case "IS":
                    pos.loadTemplateFile("InformationSystems.dat");
                    isNotDone = false;
                    break;
                case "WD":
                    pos.loadTemplateFile("WebDevelopment.dat");
                    isNotDone = false;
                    break;
                case "CS":
                    pos.loadTemplateFile("ComputerScience.dat");
                    isNotDone = false;
                    break;
                case "DB":
                    pos.loadTemplateFile("Database.dat");
                    isNotDone = false;
                    break;
                case "NW":
                    pos.loadTemplateFile("Networks.dat");
                    isNotDone = false;
                    break;
                case "SE":
                    pos.loadTemplateFile("SoftwareEngineering.dat");
                    isNotDone = false;
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again.");
                    input = view.concentrationMenu();
            }
        }
    }
    /**
     * The mainMenuControl method contains the decision based logic for the main menu.
     * Calls methods from the View and ProgramOfStudy classes and interprets the input accordingly.
     * @param input The variable that contains the input from the user to be checked.
     */
    public void mainMenuControl(String input)
    {
        boolean isNotDone = true;
        while (isNotDone)
        {
            switch(input.toUpperCase())
            {
                case "FIND":
                    findCourseControl(view.departmentDisplay(),view.courseNumberDisplay());
                    isNotDone = false;
                    break;
                case "ADD":
                    addCourseControl(view.courseNameDisplay(), view.departmentDisplay(), view.creditHoursDisplay(), view.courseNumberDisplay(), view.semesterDisplay());
                    isNotDone = false;
                    break;
                case "REMOVE":
                    removeCourseControl(view.semesterDisplay(), view.courseIndexDisplay());
                    isNotDone = false;
                    break;
                case "GRADE":
                    gradeControl(view.semesterDisplay(), view.courseIndexDisplay(), view.gradeDisplay());
                    isNotDone = false;
                    break;
                case "PREREQ":
                    prerequisiteControl(view.prerequisiteDisplay(), view.semesterDisplay(), view.courseIndexDisplay());
                    isNotDone = false;
                    break;
                case "PRINTS":
                    semesterControl(view.semesterDisplay());
                    isNotDone = false;
                    break;
                case "PRINTPOS":
                    pos.printCourses();
                    isNotDone = false;
                    break;
                case "CHECK":
                    pos.checkPrerequisite();
                    isNotDone = false;
                    break;
                case "SAVE":
                    pos.saveFile(view.saveFilenameDisplay());
                    isNotDone = false;
                    break;
                case "EXIT":
                    stopProgram = true;
                    isNotDone = false;
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again.");
                    input = view.mainMenu();
            }
        } 
    }
    /**
     * The loadFileMenuControl method calls a method from the ProgramOfStudy class and sends it a filename.
     * @param filename The variable that contains the filename from the user.
     */
    public void loadFileMenuControl(String filename)
    {
        pos.loadPrimaryFile(filename);
    }
    /**
     * The findCourseControl method calls a method from the ProgramOfStudy class and sends it a course department and number.
     * @param department The variable that contains the department data for a course.
     * @param courseNumber The variable that contains the course number data for a course.
     */
    public void findCourseControl(String department, int courseNumber)
    {
        pos.findCourse(department, courseNumber);
    }
    /**
     * The gradeControl method calls a method from the ProgramOfStudy class and sends it a course semester, index, and grade.
     * @param semester The variable that contains the semester data for a course.
     * @param courseIndex The variable that contains the course index data for a course.
     * @param grade The variable that contains the grade data for a course.
     */
    public void gradeControl(int semester, int courseIndex, String grade)
    {
        pos.addGrade(semester, courseIndex, grade);
    }
    /**
     * The removeCourseControl method calls a method from the ProgramOfStudy class and sends it a course semester and index.
     * @param semester The variable that contains the semester data for a course.
     * @param courseIndex The variable that contains the course index data for a course.
     */
    public void removeCourseControl(int semester, int courseIndex)
    {
        pos.removeCourse(semester, courseIndex);
    }
    /**
     * The addCourseControl method calls a method from the ProgramOfStudy class and sends it a course name, department, credit hours, number, and semester.
     * @param courseName The variable that contains the name for a course.
     * @param department The variable that contains the department data for a course.
     * @param creditHours The variable that contains the credit hour data for a course.
     * @param courseNumber The variable that contains the course number data for a course.
     * @param semester The variable that contains the semester data for a course.
     */
    public void addCourseControl(String courseName, String department, int creditHours, int courseNumber, int semester)
    {
        pos.addCourse(courseName, department, creditHours, courseNumber, semester);
    }
    /**
     * The semesterControl method calls a method from the ProgramOfStudy class and sends it a course semester.
     * @param semester The variable that contains the semester data for a course.
     */
    public void semesterControl(int semester)
    {
        pos.printSemester(semester);
    }
    /**
     * The prerequisiteControl method calls a method from the ProgramOfStudy class and sends it a course prerequisite, semester, and index.
     * @param prerequisite The variable that contains the prerequisite for a course.
     * @param semester The variable that contains the semester data for a course.
     * @param courseIndex The variable that contains the course index data for a course.
     */
    public void prerequisiteControl(String prerequisite, int semester, int courseIndex)
    {
        pos.addPrerequisite(prerequisite, semester, courseIndex);
    }
}