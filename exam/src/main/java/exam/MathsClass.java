package exam;

import java.util.HashMap;

public class MathsClass extends TClass {


    public MathsClass(String name, Integer grade) {
        super(name, grade);
    }

    @Override
    public Double averageScore() {
//        double sumScore = 0.0;
//        for (Student student : getStudents()) {
//            HashMap<Subject, Double> scores = student.getScores();
//            sumScore += (scores.get(Subject.MATHS) * 2 + scores.get(Subject.PHYSICS) +
//                    scores.get(Subject.GEOGRAPHY) + scores.get(Subject.HISTORY) +
//                    scores.get(Subject.BIOLOGY)) / 6;
//        }
//        return sumScore / getStudents().size();

        return getStudents().stream().mapToDouble(student -> {
            HashMap<Subject, Double> scores = student.getScores();
            return (scores.get(Subject.MATHS) * 2 + scores.get(Subject.PHYSICS) +
                    scores.get(Subject.GEOGRAPHY) + scores.get(Subject.HISTORY) +
                    scores.get(Subject.BIOLOGY)) / 6;
        }).average().orElse(0);
    }

}

