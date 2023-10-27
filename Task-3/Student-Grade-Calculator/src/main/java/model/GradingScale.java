package model;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

@Component
public class GradingScale {

	private Map<Double, String> gradeScale;

    public GradingScale() {
        gradeScale = new TreeMap<>();
        gradeScale.put(90.0, "A+");
        gradeScale.put(85.0, "A");
        gradeScale.put(80.0, "A-");
        gradeScale.put(75.0, "B+");
        gradeScale.put(70.0, "B");
        gradeScale.put(65.0, "B-");
        gradeScale.put(60.0, "C+");
        gradeScale.put(55.0, "C");
        gradeScale.put(50.0, "C-");
        gradeScale.put(45.0, "D+");
        gradeScale.put(40.0, "D");
        gradeScale.put(0.0, "F");
    }

    public String getLetterGrade(double score) {
        for (Map.Entry<Double, String> entry : gradeScale.entrySet()) {
            if (score >= entry.getKey()) {
                return entry.getValue();
            }
        }
        return "Invalid";
    }
}
