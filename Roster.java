package assign5;

import java.util.*;

/**
 * Represents a class of students.
 * @author Jill Seaman
 *
 */
public class Roster {
    
    private String courseName;             // Class name
    private String courseNumber;           // Course number, like cs2308
    private ArrayList<Student> students;// list of students in the course
    /**
     * Constructs the roster from its name and number
     * @param name   the course name.
     * @param number the course number.
     */
    public Roster(String name, String number) {
        this.courseName = name;
        this.courseNumber = number;
        students = new ArrayList<Student>();
    }
    
    /**
     * @return the course name.
     */
    public String getCourseName() {
        return courseName;
    }
    
    /**
     * Adds a Student to the list.
     * @param student the Student to add
     */
    private class Dispenser implements AvgDispenser
    {
    	int index;
		@Override
		public double getNextAvg() {
			// TODO Auto-generated method stub
			if(!this.done()){
				Student st = students.get(index++);
	            return (double) st.getAverage();
	         }
	         return 0;
		}

		@Override
		public boolean done() {
			// TODO Auto-generated method stub
			if(index<students.size())
			{
				return false;
			}
			return true;
		}
    	
    }
    public void addStudent (Student student) {
        students.add(student);
    }
    public AvgDispenser getDispenser()
    {
    	return new Dispenser();
    }
    
    
}
