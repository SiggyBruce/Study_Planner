/**
 * Course.java -  FEB-14-2016 - ITEC 220 - 
 * Stores all of the data for a course object.
 * @author Tre Haga
 * @version 1.0
 */
import java.io.*;
public class Course implements Serializable
{
    /**
     * The Course class instance variables.
     */
    private String courseName;
    private String department;
    private String grade;
    private int creditHours;
    private int courseNumber;
    private int semester;
    private String[] prerequisites;
    /**
     * The Course class constructor.
     * Creates a course object.
     * @param _courseName
     * @param _department
     * @param _grade
     * @param _creditHours
     * @param _courseNumber
     * @param _semester
     */
    public Course(String _courseName, String _department, String _grade, int _creditHours, int _courseNumber, int _semester)
    {
        this.courseName = _courseName;
        this.department = _department;
        this.grade = _grade;
        this.creditHours = _creditHours;
        this.courseNumber = _courseNumber;
	this.semester = _semester;
        this.prerequisites = new String[5];
    }
    /**
     * The getCourseName method returns the course name.
     * @return courseName
     */
    public String getCourseName()
    {
        return this.courseName;
    }
    /**
     * The getDepartment method returns the course department.
     * @return department
     */
    public String getDepartment()
    {
        return department;
    }
    /**
     * The getCreditHours method returns the courses credit hours.
     * @return creditHours
     */
    public int getCreditHours()
    {
        return this.creditHours;
    }
    /**
     * The getGrade method returns the course grade.
     * @return grade
     */
    public String getGrade()
    {
        return this.grade;
    }
    /**
     * The getCourseNumber method returns the course number.
     * @return courseNumber
     */
    public int getCourseNumber()
    {
        return this.courseNumber;
    }
    /**
     * The getSemester method returns the course semester.
     * @return semester
     */
    public int getSemester()
    {
        return this.semester;
    }
    /**
     * The getPrerequisites method returns the course prerequisites.
     * @return prerequisites
     */
    public String[] getPrerequisites()
    {
        return this.prerequisites;
    }
    /**
     * The setCourseName method sets the current course name to a new course name.
     * @param newCourseName The new course name.
     */
    public void setCourseName(String newCourseName)
    {
        this.courseName = newCourseName;
    }
    /**
     * The setDepartment method sets the current course department to a new course department.
     * @param newDepartment The new course department.
     */
    public void setDepartment(String newDepartment)
    {
        this.department = newDepartment;
    }
    /**
     * The setGrade method sets the current course grade to a new course grade.
     * @param newGrade The new course grade.
     */
    public void setGrade(String newGrade)
    {
        this.grade = newGrade;
    }
    /**
     * The setCourseHours method sets a current courses credit hours to the new course credit hours.
     * @param newCourseHours The new course credit hours.
     */
    public void setCreditHours(int newCourseHours)
    {
        this.creditHours = newCourseHours;
    }
    /**
     * The setCourseNumber method sets a current course number to a new course number.
     * @param newCourseNumber The new course number.
     */
    public void setCourseNumber(int newCourseNumber)
    {
        this.courseNumber = newCourseNumber;
    }
    /**
     * The setSemester method sets a current semester to a new course semester.
     * @param newSemester The new course semester.
     */
    public void setSemester(int newSemester)
    {
        this.semester = newSemester;
    }
    /**
     * The setPrerequisites method sets a current course prerequisite to a new course prerequisite specified by an index.
     * @param newPrerequisite The new course prerequisite.
     * @param index The variable that stores the position of the prerequisite array.
     */
    public void setPrerequisites(String newPrerequisite, int index)
    {
        this.prerequisites[index] = newPrerequisite;
    }
    /**
     * The toString method lists all of the course data as a string.
     * @return List of course data.
     */
    public String toString()
    {
        String prerequisiteList = "";
        for (int index = 0; index < prerequisites.length; index ++)
        {
            if (prerequisites[index] != null)
            {
                prerequisiteList += prerequisites[index] + " ";
            }
        }
        return "Name: " + this.courseName + 
               "\nDepartment: " + this.department + 
               "\nGrade: " + this.grade +
               "\nCredit Hours: " + this.creditHours + 
               "\nCourse Number: " + this.courseNumber + 
               "\nPrerequisites: " + prerequisiteList +
               "\nSemester: " + (this.semester + 1);
    }
    /**
     * The equals method compares two courses with each other according to a courses number and department.
     * @param otherCourse The course object you are trying to compare to.
     * @return isEqual True or false.
     */
    public boolean equals(Course otherCourse)
    {
        boolean isEqual = false;
        if (this.courseNumber == otherCourse.getCourseNumber())
        {
            if (this.department.equals(otherCourse.getDepartment()))
            {
                isEqual = true;
            }
        }
        return isEqual;
    }
}