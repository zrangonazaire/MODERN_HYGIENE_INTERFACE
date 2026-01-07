package com.bzdata.GestionCinema.event;

import java.util.Collection;
import java.util.List;

public interface UserEventService {
    void addUserEvent(int userId, EventType eventType, String device, String ipAddress);
}
