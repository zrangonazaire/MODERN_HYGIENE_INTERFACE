package com.bzdata.GestionCinema.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEventRepository extends JpaRepository<UserEvent, Integer> {

    List<UserEvent> getEventsByUserId(int userId);
}
