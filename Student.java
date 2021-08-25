package assign5;

import java.util.ArrayList;

/**
 * Represents a student and their scores in a class.
 * Stores the name, assignment scores and exam scores.
 * @author Abdul Aziz Ibrahim
 *
 */
public class Student {

    private String name;                    // Students full name
    private ArrayList<Double> assignments;  // scores for the assignments
    private ArrayList<Double> exams;        // scores for the exams
    private boolean averageType;
    private GradeTracker gd;
	/**
	 * Constructs the student from their name
	 * @param name  full name of the student.
	 */
	public Student(String name) {
		this.name = name;
        assignments = new ArrayList<Double>();
        exams = new ArrayList<Double>();
        averageType = false;
       gd = new GradeTracker(this);
        
	}

	/**
	 * @return the student's full name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds an assignment score to the collection of assignment scores for the student.
	 * @param as the assignment score to add
	 */
	public void addAssignmentScore (double as) {
		assignments.add(as);
	}
	/**
	 * Adds an exam score to the collection of exam scores for the student.
	 * @param es the exam score to add
	 */
	public void addExamScore (double es) {
		exams.add(es);
	}
	private class AlgorithmA extends Student
	{

		public AlgorithmA() {
			super(name);
			 //getAverage();
			// TODO Auto-generated constructor stub
		}
		public Object getAverage() {
			int lenA = assignments.size(); 
			int lenE = exams.size();
			double scoreA = 0.0;
			double scoreE = 0.0;
			double totalScore = 0.0;
			//algorithm  A
			for(int i=0; i<lenA; i++)
			{
				scoreA += assignments.get(i);
			}
			for(int i=0; i<lenE; i++)
			{
				scoreE += exams.get(i);
			}
			totalScore = (scoreA * 40)/(lenA * 100) + (scoreE * 60)/(lenE * 100);
			gd.calculateGrade(totalScore);
			return totalScore;
		}
		
	}
	public class AlgorithmB extends Student
	{
		public AlgorithmB() {
			super(name);
			// TODO Auto-generated constructor stub
		}
		public Object getAverage()
		{
			int lenA = assignments.size(); 
			int lenE = exams.size();
			double scoreA = 0.0;
			double scoreE = 0.0;
			double totalScore = 0.0;
			double min = assignments.get(0);
			for (int lol =1; lol<lenA; lol++)
			{
				if(min > assignments.get(lol))
				{
					min = assignments.get(lol);
				}
			}
			for(int jazz=0; jazz<lenA; jazz++)
			{
				scoreA += assignments.get(jazz);
			}
			for(int sa=0; sa<lenE; sa++)
			{
				scoreE += exams.get(sa);
			}
			scoreA = scoreA - min;
			totalScore = (scoreA * 40)/((lenA-1) * 100) + (scoreE * 60)/(lenE * 100);
			gd.calculateGrade(totalScore);
			return totalScore;
		}
		
		
	}
	public Object getAverage() {
		// TODO Auto-generated method stub
		
		if(averageType)
		{
			return new AlgorithmB().getAverage();
			
		}
		else 
		{
			return new AlgorithmA().getAverage();
		}
	}

	public void setDropLowestAssign(boolean b) {
		// TODO Auto-generated method stub
		averageType = b;
		
	}


}
