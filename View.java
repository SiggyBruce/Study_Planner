/**
 * View.java - FEB-14-2016 - ITEC 220 - 
 * This class contains methods that prompt the user and show visual output. 
 * It sends data to the Controller class to be processed.
 * @author Tre Haga
 * @version 1.0
 */
import java.util.*;
public class View
{
    /**
     * The startMenu method displays the starting menu and prompts the user for input.
     * @return input
     */
    public String startMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Is there an existing Program of Study? (Y or N): ");
        String input = scanner.nextLine();
        return input;
    }
    /**
     * The concentrationMenu method displays the concentration menu and prompts the user for input.
     * @return input
     */
    public String concentrationMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nInformation Systems: (IS)" +
                         "\nWeb Development: (WD)" +
                         "\nComputer Science: (CS)" +
                         "\nDatabase: (DB)" +
                         "\nNetworks: (NW)" +
                         "\nSoftware Engineering: (SE)\n");
        System.out.print("Please enter your concentration: ");
        String input = scanner.nextLine();
        return input;
    }
    /**
     * The mainMenu method displays the main menu for the program and prompts the user for input.
     * @return input
     */
    public String mainMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nFind a course: (FIND)" +
                           "\nAdd a course: (ADD)" +
                           "\nRemove a course: (REMOVE)" +
                           "\nAdd a grade: (GRADE)" +
                           "\nAdd a prerequisite: (PREREQ)" +
                           "\nOutput a semester: (PRINTS)" +
                           "\nOutput your Program of Study: (PRINTPOS)" +
                           "\nCheck prerequisites: (CHECK)" +
                           "\nSave your Program of Study: (SAVE)" +
                           "\nExit the program: (EXIT)");
        System.out.print("What would you like to do? ");
        String input = scanner.nextLine();
        return input;
    }
    /**
     * The loadFileDisplay method prompts the user for a filename.
     * @return input
     */
    public String loadFileDisplay()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter the filename along with the file extention of your existing file: ");
        String input = scanner.nextLine();
        return input;
    }
    /**
     * The saveFilenameDisplay method prompts the user for a filename.
     * @return input
     */
    public String saveFilenameDisplay()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter the filename along with the file extention for the file you wish to save: ");
        String input = scanner.nextLine();
        return input;
    }
    /**
     * The departmentDisplay method prompts the user for a course department.
     * @return input
     */
    public String departmentDisplay()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter the department name: ");
        String input = scanner.nextLine().toUpperCase();
        return input;
    }
    /**
     * The courseNameDisplay method prompts the user for a course name.
     * @return input
     */
    public String courseNameDisplay()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter a name for the course: ");
        String input = scanner.nextLine();
        return input;
    }
    /**
     * The prerequisiteDisplay method prompts the user for a course prerequisite.
     * @return input
     */
    public String prerequisiteDisplay()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter the department and course number for the prerequisite (Ex. ITEC 220): ");
        String input = scanner.nextLine().toUpperCase();
        return input;
    }
    /**
     * The gradeDisplay method prompts the user for a course grade.
     * @return input
     */
    public String gradeDisplay()
    {
        boolean isNotDone = true;
        String input = "";
        while (isNotDone)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nPlease enter the grade for the course: ");
            input = scanner.nextLine().toUpperCase();
            if (input.length() == 1)
            {
                isNotDone = false;
            }
            else
            {
                System.out.println("\nInvalid input. Please try again.");
                isNotDone = true;
            }
        }
        return input;
    }
    /**
     * The courseNumberDisplay prompts the user for a course number.
     * @return input
     */
    public int courseNumberDisplay()
    {
        Scanner scanner = new Scanner(System.in);
        boolean isNotDone = true;
        int input = 0;
        while (isNotDone)
        {
            try
            {
                System.out.print("\nPlease enter the course number: ");
                input = scanner.nextInt();
                isNotDone = false;
            }
            catch (Exception exception)
            {
                System.out.println("\nInvalid input. Please try again.");
                isNotDone = true;
            }
        }
        return input;
    }
    /**
     * The semesterDisplay method prompts the user for a course semester.
     * @return input
     */
    public int semesterDisplay()
    {
        boolean isNotDone = true;
        int input = 0;
        while (isNotDone)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nPlease enter the semester: ");
                input = scanner.nextInt();
                input--;
                if ((input > 9) || (input < 0))
                {
                    System.out.println("\nInvalid input. Please try again.");
                    isNotDone = true;
                }
                else
                {
                    isNotDone = false;
                }
            }
            catch (Exception exception)
            {
                System.out.println("\nInvalid input. Please try again.");
                isNotDone = true;
            }
        }
        return input;
    }
    /**
     * The courseIndexDisplay method prompts the user for a course index.
     * @return input
     */
    public int courseIndexDisplay()
    {
        boolean isNotDone = true;
        int input = 0;
        while (isNotDone)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nPlease enter the position your course is located at in your chosen semester: ");
                input = scanner.nextInt();
                input--;
                if ((input > 7) || (input < 0))
                {
                    System.out.println("\nInvalid input. Please try again.");
                    isNotDone = true;
                }
                else
                {
                    isNotDone = false;
                }
            }
            catch (Exception exception)
            {
                System.out.println("\nInvalid input. Please try again.");
                isNotDone = true;
            }
        }
        return input;
    }
    /**
     * The creditHoursDisplay method prompts the user for a courses credit hours.
     * @return input
     */
    public int creditHoursDisplay()
    {
        boolean isNotDone = true;
        int input = 0;
        while (isNotDone)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nPlease enter the credit hours: ");
                input = scanner.nextInt();
                isNotDone = false;
            }
            catch (Exception exception)
            {
                System.out.println("\nInvalid input. Please try again.");
                isNotDone = true;
            }
        }
        return input;
    }
}