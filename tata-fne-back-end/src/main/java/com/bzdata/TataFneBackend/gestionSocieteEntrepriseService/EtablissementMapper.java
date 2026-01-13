package com.bzdata.TataFneBackend.gestionSocieteEntrepriseService;


public class EtablissementMapper {


        public static Etablissement toEntity(EtablissementRequestDTO dto, Societe societe) {

            if (dto == null || societe == null) return null;
            return Etablissement.builder()
                    .codeEtablissement(dto.getCodeEtablissement())
                    .nom(dto.getNom())
                    .typeEtablissement(dto.getTypeEtablissement())
                    .adresse(dto.getAdresse())
                    .ville(dto.getVille())
                    .telephone(dto.getTelephone())
                    .email(dto.getEmail())
                    .responsable(dto.getResponsable())
                    .dateOuverture(dto.getDateOuverture())
                    .societe(societe)
                    .activitePrincipale(dto.getActivitePrincipale())
                    .build();
        }

        public static EtablissementResponseDTO toResponse(Etablissement entity) {
            if (entity == null) return null;
            Societe societe = entity.getSociete();
            if (societe != null) {
                EtablissementResponseDTO dto = new EtablissementResponseDTO();
                dto.setId(entity.getId());
                dto.setCodeEtablissement(entity.getCodeEtablissement());
                dto.setNom(entity.getNom());
                dto.setTypeEtablissement(entity.getTypeEtablissement());
                dto.setVille(entity.getVille());
                dto.setResponsable(entity.getResponsable());
                dto.setTelephone(entity.getTelephone());
                dto.setEmail(entity.getEmail());
                dto.setIdsociete(societe.getId());
                return dto;
            }
            return null;
        }
    }

