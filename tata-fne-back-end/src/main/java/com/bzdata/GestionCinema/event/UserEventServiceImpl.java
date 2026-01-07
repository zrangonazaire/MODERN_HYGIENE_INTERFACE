package com.bzdata.GestionCinema.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserEventServiceImpl implements UserEventService {

     @Override
    public void addUserEvent(int userId, EventType eventType, String device, String ipAddress) {

    }
}
