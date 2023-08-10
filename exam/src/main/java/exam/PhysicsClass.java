package exam;

import java.util.HashMap;

public class PhysicsClass extends TClass{
    public PhysicsClass(String name, Integer grade) {
        super(name, grade);
    }

    @Override
    public Double averageScore() {
        return getStudents().stream().mapToDouble(student -> {
            HashMap<Subject, Double> scores = student.getScores();
            return (scores.get(Subject.PHYSICS) * 2 + scores.get(Subject.MATHS) +
                    scores.get(Subject.GEOGRAPHY) + scores.get(Subject.HISTORY) +
                    scores.get(Subject.BIOLOGY)) / 6;
        }).average().orElse(0);
    }
}


