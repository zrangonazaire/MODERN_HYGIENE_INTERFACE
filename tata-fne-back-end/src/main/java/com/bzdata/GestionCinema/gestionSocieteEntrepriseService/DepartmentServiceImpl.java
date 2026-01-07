package com.bzdata.GestionCinema.gestionSocieteEntrepriseService;

import com.bzdata.GestionCinema.user.User;
import com.bzdata.GestionCinema.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository serviceRepository;
    private final EtablissementRepository etablissementRepository;
    private final UserRepository utilisateurRepository;


    @Override
    @Transactional
    public DepartmentResponseDto create(DepartmentRequestDto service) {
        Etablissement etab = etablissementRepository.findById(service.idEtablissement())
                .orElseThrow(() -> new RuntimeException("Etablissement non trouvé"));

       var existing = DepartmentMapper.toEntity(service,etab);
        return DepartmentMapper.toResponse(serviceRepository.save(existing));
    }


    @Override
    @Transactional
    public DepartmentResponseDto addUsers(Long serviceId, List<Integer> utilisateurIds) {
        Department service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service non trouvé"));
        List<User> users = utilisateurRepository.findAllById(utilisateurIds);
        service.getUtilisateurs().addAll(users);
        return DepartmentMapper.toResponse(serviceRepository.save(service));
    }


    @Override
    @Transactional
    public DepartmentResponseDto removeUser(Long serviceId, int utilisateurId) {
        Department service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service non trouvé"));
        User user = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        service.getUtilisateurs().remove(user);
        return DepartmentMapper.toResponse(serviceRepository.save(service));
    }


    @Override
    public List<DepartmentResponseDto> getServicesByEtablissement(int etablissementId) {

        var ListOfDepartment=serviceRepository.findByEtablissementId(etablissementId).stream()
               .map(DepartmentMapper::toResponse)
               .collect(Collectors.toList());
        return ListOfDepartment;
    }


    @Override
    public List<User> getUtilisateursByService(Long serviceId) {
        Department service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service non trouvé"));
        return service.getUtilisateurs();
    }


    @Override
    @Transactional
    public DepartmentResponseDto updateService(Long id, String nom, String code) {
        Department service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service non trouvé"));
        service.setNom(nom);
        service.setCode(code);
        return DepartmentMapper.toResponse(serviceRepository.save(service));
    }


    @Override
    @Transactional
    public void deleteService(Long id) {
        Department service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service non trouvé"));
        serviceRepository.delete(service);
    }
}
