package com.bzdata.TataFneBackend.FactureFne;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bzdata.TataFneBackend.LigneFactureFne.LigneFactureFne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class FactureNonCertifier {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String invoiceNumber;
    private LocalDate invoiceDate;

    private String invoiceType;
    private String paymentMethod;
    private String template;

    private String clientNcc;
    private String clientCompanyName;
    private String clientPhone;
    private String clientEmail;
    private String clientSellerName;

    private String pointOfSale;
    private String establishment;
    private String commercialMessage;
    private String footer;

    private String foreignCurrency;

    @Builder.Default
    private BigDecimal foreignCurrencyRate = BigDecimal.ZERO;

    // Remise globale facture (si ton JSON l’envoie au niveau facture)
    @Builder.Default
    private BigDecimal discount = BigDecimal.ZERO;

    @Builder.Default
    private boolean isRne = false;

    private String rne;

    // ✅ Invoice -> Items
    @OneToMany(mappedBy = "invoice")
    @Builder.Default
    private List<LigneFactureFne> items = new ArrayList<>();

    // Helpers relationnels
    public void addItem(LigneFactureFne item) {
        items.add(item);
        item.setInvoice(this);
    }

    public void removeItem(LigneFactureFne item) {
        items.remove(item);
        item.setInvoice(null);
    }
}