package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import model.Student;
import service.GradeCalculatorService;

@Controller
public class StudentGradeController {

	@Autowired
    private GradeCalculatorService gradeCalculatorService;

    @GetMapping("/")
    public String showGradeForm(Model model) {
        model.addAttribute("student", new Student());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateGrade(Student student, Model model) {
        if (student == null) {
            student = new Student(); // Initialize student object if null
        }

        double finalGrade = gradeCalculatorService.calculateFinalGrade(student);
        String letterGrade = gradeCalculatorService.getLetterGrade(finalGrade);

        student.setFinalGrade(finalGrade);
        student.setLetterGrade(letterGrade);

        model.addAttribute("student", student);
        return "index";
    }
}
