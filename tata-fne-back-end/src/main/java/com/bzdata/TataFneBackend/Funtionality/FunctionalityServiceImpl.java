package com.bzdata.TataFneBackend.Funtionality;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.bzdata.TataFneBackend.exception.ResourceNonFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FunctionalityServiceImpl implements FunctionalityService {
    private final FunctionalityRepository repository;
    private final FunctionalityMapper functionalityMapper;
    @Override
    public FunctionalityDTO create(FunctionalityDTO dto) {
        Functionality f = new Functionality();
        f.setCodeFunctionality(dto.getCode());
        f.setNameFunctionality(dto.getNom());
        f.setDescriptionFunctionality(dto.getDescription());
        return functionalityMapper.FunctionalitymapToDTO(repository.save(f));
    }

    @Override
    public FunctionalityDTO update(int id, FunctionalityDTO dto) {
        Functionality f = repository.findById(id)
                .orElseThrow(() -> new ResourceNonFoundException("Functionality not found"));

        f.setCodeFunctionality(dto.getCode());
        f.setNameFunctionality(dto.getNom());
        f.setDescriptionFunctionality(dto.getDescription());

        return functionalityMapper.FunctionalitymapToDTO(repository.save(f));
    }

    @Override
    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new ResourceNonFoundException("Functionality not found");
        }
        repository.deleteById(id);
    }

    @Override
    public FunctionalityDTO getById(int id) {
        Functionality f = repository.findById(id)
                .orElseThrow(() -> new ResourceNonFoundException("Functionality not found"));
        return functionalityMapper.FunctionalitymapToDTO(f);
    }

    @Override
    public List<FunctionalityDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(functionalityMapper::FunctionalitymapToDTO)
                .collect(Collectors.toList());
    }
}
