package com.bzdata.GestionCinema.event;

import java.util.Collection;
import java.util.List;

public interface UserEventService {
    List<UserEvent> getEventsByUserId(int userId);
    void addUserEvent(String email, EventType eventType, String device, String ipAddress);
    void addUserEvent(int userId, EventType eventType, String device, String ipAddress);
}
