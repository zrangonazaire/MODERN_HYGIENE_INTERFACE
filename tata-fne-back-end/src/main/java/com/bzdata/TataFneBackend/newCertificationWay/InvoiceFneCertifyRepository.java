package com.bzdata.TataFneBackend.newCertificationWay;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InvoiceFneCertifyRepository extends JpaRepository<InvoiceFneCertify, String> {
    long countByNumeroFacture(String numeroFacture);

    List<InvoiceFneCertify> findByNumeroFactureOrderByCreatedAtDesc(String numeroFacture);

    List<InvoiceFneCertify> findAllByOrderByCreatedAtDesc();

    Optional<InvoiceFneCertify> findByNumeroFacture(String numFacture);


    boolean existsByNumeroFacture(String numeroFacture);

}
