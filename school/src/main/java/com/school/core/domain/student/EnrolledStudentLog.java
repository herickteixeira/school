package com.school.core.domain.student;

import com.school.core.domain.Receiver;
import com.school.core.domain.student.interfaces.Event;

import java.time.format.DateTimeFormatter;

public class EnrolledStudentLog extends Receiver {

    public void respond(Event event){
        String dateFormat = event
                .moment()
                .format(DateTimeFormatter
                        .ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println(String.format(
                "Student with CPF %s enrolled in: %s",
                ((EnrolledStudent) event).getCpfStudent(),
                dateFormat));
    }

    @Override
    protected boolean shouldProcess(Event event){
        return event instanceof EnrolledStudent;
    }
}
