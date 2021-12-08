package com.griesba.kata.bankaccount.infrastructure;

import com.griesba.kata.bankaccount.events.Event;
import com.griesba.kata.bankaccount.infrastructure.mongo.EventsRepository;
import org.springframework.stereotype.Component;

@Component
public class EventStore {
    private final EventsRepository eventRepository;
    private final EntityReducer entityReducer;

    public EventStore(EventsRepository eventRepository, EntityReducer entityReducer) {
        this.eventRepository = eventRepository;
        this.entityReducer = entityReducer;
    }

    public void append(Event event) throws UnknownEventException {
        eventRepository.save(event);
        entityReducer.reduce(event);
    }
}
