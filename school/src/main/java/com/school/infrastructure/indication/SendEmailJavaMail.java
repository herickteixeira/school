package com.school.infrastructure.indication;

import com.school.application.SendEmailIndication;
import com.school.core.domain.student.Student;

public class SendEmailJavaMail implements SendEmailIndication {
    @Override
    public void send(Student student) {
        //Java Mail
    }
}
