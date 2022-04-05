package com.school.core.domain.indication;

import com.school.core.domain.student.Student;

import java.time.LocalDateTime;

public class indication {
    private Student indicated;
    private Student indicator;
    private LocalDateTime dataRecommendation;

    public indication(Student indicated, Student indicator) {
        this.indicated = indicated;
        this.indicator = indicator;
        this.dataRecommendation = LocalDateTime.now();
    }

    public Student getIndicated() {
        return indicated;
    }

    public Student getIndicator() {
        return indicator;
    }

    public LocalDateTime getDataRecommendation() {
        return dataRecommendation;
    }
}
