package com.griesba.kata.bankaccount.infrastructure.mongo;

import com.griesba.kata.bankaccount.events.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Event, String> {
    // user MongoRepository instead
}
