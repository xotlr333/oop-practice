package org.example;

import java.util.List;

public class GradeCalculator {

    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculateGrade() {

        //(학점수 * 교과목) 평점 의 합계
        double multipliedCreditAdnCourseGrade = 0;
        for (Course course : courses) {
            multipliedCreditAdnCourseGrade += course.getCredit() * course.getGradeToNumber();
        }

        //수강신청 총학점 수
        int totalCompleteCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return multipliedCreditAdnCourseGrade / totalCompleteCredit;
    }
}
