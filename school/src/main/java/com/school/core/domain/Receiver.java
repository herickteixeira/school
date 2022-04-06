package com.school.core.domain;

import com.school.core.domain.student.interfaces.Event;

public abstract class Receiver {

    public void process(Event event){
        if (this.shouldProcess(event)){
            this.respond(event);
        }
    }

    protected abstract boolean shouldProcess(Event event);

    protected abstract void respond(Event event);

}
