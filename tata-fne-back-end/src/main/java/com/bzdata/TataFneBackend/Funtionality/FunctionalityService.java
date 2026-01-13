package com.bzdata.TataFneBackend.Funtionality;
import java.util.List;
public interface FunctionalityService {

    FunctionalityDTO create(FunctionalityDTO dto);
    FunctionalityDTO update(int id, FunctionalityDTO dto);
    void delete(int id);
    FunctionalityDTO getById(int id);
    List<FunctionalityDTO> getAll();

    }
