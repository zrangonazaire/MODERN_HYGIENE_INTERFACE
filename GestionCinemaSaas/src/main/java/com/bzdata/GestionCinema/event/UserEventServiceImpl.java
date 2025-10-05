package com.bzdata.GestionCinema.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserEventServiceImpl implements UserEventService {

    private final UserEventRepository eventRepository;
    @Override
    public List<UserEvent> getEventsByUserId(int userId) {
        return eventRepository.getEventsByUserId(userId);
    }

    @Override
    public void addUserEvent(String email, EventType eventType, String device, String ipAddress) {

    }

    @Override
    public void addUserEvent(int userId, EventType eventType, String device, String ipAddress) {

    }
}
