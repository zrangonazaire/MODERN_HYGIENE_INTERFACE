package com.bzdata.GestionCinema.gestionSocieteEntrepriseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class EtablissementServiceImpl implements EtablissementService{

    private final  EtablissementRepository etablissementRepository;
    private final SocieteRepository societeRepository;

    @Override
    public EtablissementResponseDTO create(EtablissementRequestDTO etablissement) {
        Societe societe=getSocieteById(etablissement.getIdSociete());

        Etablissement entity = EtablissementMapper.toEntity(etablissement, societe);
        Etablissement saved = etablissementRepository.save(entity);
        return EtablissementMapper.toResponse(saved);
    }
    public Societe getSocieteById(int idSociete) {
        return societeRepository.findById(idSociete)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Aucune société trouvée avec l'identifiant %d", idSociete)
                ));
    }
    @Override
    public EtablissementResponseDTO update(int id, EtablissementRequestDTO dto) {
        Etablissement existing = etablissementRepository.findById(id).orElseThrow(() -> new RuntimeException("we are not findout the society"));
        log.info("Ancien enregistrement : {}", existing);

        if (dto.getAdresse() != null && !dto.getAdresse().isBlank())
            existing.setAdresse(dto.getAdresse());

        if (dto.getEmail() != null && !dto.getEmail().isBlank())
            existing.setEmail(dto.getEmail());

        if (dto.getTypeEtablissement() != null && !dto.getTypeEtablissement().isBlank())
            existing.setTypeEtablissement(dto.getTypeEtablissement());

        if (dto.getTelephone() != null && !dto.getTelephone().isBlank())
            existing.setTelephone(dto.getTelephone());

        if (dto.getVille() != null && !dto.getVille().isBlank())
            existing.setVille(dto.getVille());

        if (dto.getCodeEtablissement() != null && !dto.getCodeEtablissement().isBlank())
            existing.setCodeEtablissement(dto.getCodeEtablissement());

        if (dto.getNom() != null && !dto.getNom().isBlank())
            existing.setNom(dto.getNom());

        if (dto.getResponsable() != null && !dto.getResponsable().isBlank())
            existing.setResponsable(dto.getResponsable());

        if (dto.getDateOuverture() != null && !dto.getDateOuverture().isBlank())
            existing.setDateOuverture(dto.getDateOuverture());

        if (dto.getActivitePrincipale() != null && !dto.getActivitePrincipale().isBlank())
            existing.setActivitePrincipale(dto.getActivitePrincipale());

        if (dto.getIdSociete() > 0) {
            Societe societe = getSocieteById(dto.getIdSociete());
            existing.setSociete(societe);
        }

        log.info("Enregistrement après mise à jour partielle : {}", existing);
        log.info("this is the existing regord after affecting values or the etablissement {}", existing);
        var updateExisting=etablissementRepository.save(existing);
        return EtablissementMapper.toResponse(updateExisting);
    }

    @Override
    public EtablissementResponseDTO getById(int id) {
        var etab=etablissementRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("we are not findout the etbalissement"));
        return EtablissementMapper.toResponse(etab);
    }

    @Override
    public List<EtablissementResponseDTO> getAll() {
        return etablissementRepository.findAll()
                .stream()
                .map(EtablissementMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EtablissementResponseDTO> getAllEtablissementByIdSociete(int IdSociete) {
        var existing=societeRepository.findById(IdSociete).orElseThrow(()-> new RuntimeException("we are not findout the society"));
        return etablissementRepository.findAll()
                .stream()
                .filter(etablissement -> etablissement.getSociete().equals(existing))
                .map(EtablissementMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
    if(!etablissementRepository.existsById(id)){
        throw new RuntimeException("We are not findout the etbalisment");
    }
    //todo verifions que il ya pas utilisateur qui ont pour etablissement cette etablissement
    etablissementRepository.deleteById(id);
    }
}
