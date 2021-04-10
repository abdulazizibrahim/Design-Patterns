package assign5;
import java.util.*; 
public class GradeTracker {
	private Student st;
	private  String Grade;
	public GradeTracker(Student student)
	{
		st = student;
		Grade = null;
	}
	public void updateGrade(String grade)
	{
		//System.out.println("grade updated"+ grade);
		this.Grade = grade;
	}
	public double getMarks()
	{
		return (double) st.getAverage();
	}
	public void calculateGrade(double marks)
	{
		String grade = null;
		if(marks >= 90.0)
		{
			grade = "A";
		}
		if(marks >= 80.0 && marks < 90)
		{
			grade = "B";
		}
		if(marks >= 70.0 && marks < 80)
		{
			grade = "C";
		}
		if(marks >= 60.0 && marks < 70)
		{
			grade = "D";
		}
		if(marks < 60.0)
		{
			grade = "F";
		}
		updateGrade(grade);
		 
	}
	public String  getLetterGrade()
	{
		calculateGrade(getMarks());
		return Grade;
	}
}
