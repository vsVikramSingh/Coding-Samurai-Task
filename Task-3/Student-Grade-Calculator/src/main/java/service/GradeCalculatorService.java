package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.GradingScale;
import model.Student;

@Service
public class GradeCalculatorService {

	@Autowired
    private GradingScale gradingScale;

    public double calculateFinalGrade(Student student) {
        double assignments = student.getAssignments();
        double quizzes = student.getQuizzes();
        double midtermExam = student.getMidtermExam();
        double finalExam = student.getFinalExam();

        double assignmentsWeight = 0.2;
        double quizzesWeight = 0.2;
        double midtermExamWeight = 0.3;
        double finalExamWeight = 0.3;

        double weightedAssignments = assignments * assignmentsWeight;
        double weightedQuizzes = quizzes * quizzesWeight;
        double weightedMidtermExam = midtermExam * midtermExamWeight;
        double weightedFinalExam = finalExam * finalExamWeight;

        double finalGrade = weightedAssignments + weightedQuizzes + weightedMidtermExam + weightedFinalExam;

        return finalGrade;
    }

    public String getLetterGrade(double score) {
        return gradingScale.getLetterGrade(score);
    }
}
