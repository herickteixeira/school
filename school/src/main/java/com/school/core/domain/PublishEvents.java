package com.school.core.domain;

import com.school.core.domain.student.interfaces.Event;

import java.util.ArrayList;
import java.util.List;

public class PublishEvents {

    private List<Receiver> receivers = new ArrayList<>();

    public void add(Receiver receiver){
        this.receivers.add(receiver);
    }

    public void publish(Event event) {
        this.receivers.forEach(r -> {
            r.process(event);
        });
    }
}
