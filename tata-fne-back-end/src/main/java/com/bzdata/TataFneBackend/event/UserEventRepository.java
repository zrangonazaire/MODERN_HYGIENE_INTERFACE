package com.bzdata.TataFneBackend.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEventRepository extends JpaRepository<UserEvent, Integer> {

}
