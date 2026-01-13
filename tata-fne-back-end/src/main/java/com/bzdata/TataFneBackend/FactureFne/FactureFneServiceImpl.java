package com.bzdata.TataFneBackend.FactureFne;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bzdata.TataFneBackend.CustomTaxe.CustomTaxDTO;
import com.bzdata.TataFneBackend.CustomTaxe.CustomTaxe;
import com.bzdata.TataFneBackend.LigneFactureFne.LigneFactureDTO;
import com.bzdata.TataFneBackend.LigneFactureFne.LigneFactureFne;
import com.bzdata.TataFneBackend.Property.FneProperties;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class FactureFneServiceImpl implements FactureFneService {
    final WebClient fneWebClient;
    final FneProperties props;
    final FactureFneRepository factureFneRepository;

    @Override
    public InvoiceCertificationResponseDTO certifyInvoice(InvoiceDTO invoiceDTO) throws Exception {
        log.info("Certifying invoice: {}", invoiceDTO);
        if (invoiceDTO == null) {
            throw new IllegalArgumentException("invoiceDTO must not be null");
        }
        FneInvoiceRequest request = toFneRequest(invoiceDTO);
        try {
            return fneWebClient.post()
                    .uri(props.getSignPath())
                    .bodyValue(request)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, resp -> resp.bodyToMono(String.class)
                            .defaultIfEmpty("")
                            .flatMap(body -> Mono
                                    .error(new IllegalArgumentException(
                                            "Failed to certify invoice: " + resp.statusCode() + " " + body))))
                    .onStatus(HttpStatusCode::is5xxServerError, resp -> resp.bodyToMono(String.class)
                            .defaultIfEmpty("")
                            .flatMap(body -> Mono
                                    .error(new Exception("Failed to certify invoice: " + resp.statusCode() + " " + body))))
                    .bodyToMono(InvoiceCertificationResponseDTO.class)
                    .block();
        } catch (IllegalArgumentException e) {
log.error("Client error while certifying invoice: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            throw new Exception("Error certifying invoice: " + e.getMessage(), e);
        }
        // TODO Auto-generated method stub

    }

    @Override
    public List<InvoiceCertificationResponseDTO> certifyEnMasseInvoice(List<InvoiceDTO> invoiceDTOs) throws Exception {
        if (invoiceDTOs == null) {
            throw new IllegalArgumentException("invoiceDTOs must not be null");
        }
        List<InvoiceCertificationResponseDTO> responses = new ArrayList<>();
        for (InvoiceDTO invoiceDTO : invoiceDTOs) {
            responses.add(certifyInvoice(invoiceDTO));
        }
        return responses;
    }

    @Override
    public InvoiceDTO saveInvoiceDTO(InvoiceDTO invoiceDTO) throws Exception {
        if (invoiceDTO == null) {
            throw new IllegalArgumentException("invoiceDTO must not be null");
        }
        FactureNonCertifier facture = mapToEntity(invoiceDTO);
        factureFneRepository.save(facture);
        return invoiceDTO;
    }

    private FneInvoiceRequest toFneRequest(InvoiceDTO invoiceDTO) {
        boolean isRne = Boolean.TRUE.equals(invoiceDTO.isRne());
        String foreignCurrency = invoiceDTO.foreignCurrency();
        double foreignCurrencyRate = invoiceDTO.foreignCurrencyRate();
        if (foreignCurrency == null || foreignCurrency.isBlank()) {
            foreignCurrencyRate = 0;
        }
        List<CustomTaxDTO> customTaxes = invoiceDTO.customTaxes();
        if (customTaxes != null && customTaxes.isEmpty()) {
            customTaxes = null;
        }
        return new FneInvoiceRequest(
                normalizeInvoiceType(invoiceDTO.invoiceType()),
                invoiceDTO.paymentMethod(),
                normalizeTemplate(invoiceDTO.template()),
                invoiceDTO.clientNcc(),
                invoiceDTO.clientCompanyName(),
                invoiceDTO.clientPhone(),
                invoiceDTO.clientEmail(),
                invoiceDTO.clientSellerName(),
                invoiceDTO.pointOfSale(),
                invoiceDTO.establishment(),
                invoiceDTO.commercialMessage(),
                invoiceDTO.footer(),
                foreignCurrency,
                foreignCurrencyRate,
                invoiceDTO.items(),
                customTaxes,
                invoiceDTO.discount(),
                isRne,
                isRne ? invoiceDTO.rne() : null
        );
    }

    private String normalizeInvoiceType(String invoiceType) {
        if (invoiceType == null) {
            return null;
        }
        String normalized = invoiceType.trim().toLowerCase();
        if (normalized.equals("vente")) {
            return "sale";
        }
        if (normalized.equals("bordereau d'achat") || normalized.equals("bordereau d’achat")) {
            return "purchase";
        }
        return normalized;
    }

    private String normalizeTemplate(String template) {
        if (template == null) {
            return null;
        }
        return template.trim().toUpperCase();
    }

    private FactureNonCertifier mapToEntity(InvoiceDTO invoiceDTO) {
        FactureNonCertifier facture = FactureNonCertifier.builder()
                .invoiceType(invoiceDTO.invoiceType())
                .paymentMethod(invoiceDTO.paymentMethod())
                .template(invoiceDTO.template())
                .clientNcc(invoiceDTO.clientNcc())
                .clientCompanyName(invoiceDTO.clientCompanyName())
                .clientPhone(invoiceDTO.clientPhone())
                .clientEmail(invoiceDTO.clientEmail())
                .clientSellerName(invoiceDTO.clientSellerName())
                .pointOfSale(invoiceDTO.pointOfSale())
                .establishment(invoiceDTO.establishment())
                .commercialMessage(invoiceDTO.commercialMessage())
                .footer(invoiceDTO.footer())
                .foreignCurrency(invoiceDTO.foreignCurrency())
                .foreignCurrencyRate(BigDecimal.valueOf(invoiceDTO.foreignCurrencyRate()))
                .discount(BigDecimal.valueOf(invoiceDTO.discount()))
                .isRne(Boolean.TRUE.equals(invoiceDTO.isRne()))
                .rne(invoiceDTO.rne())
                .build();

        if (invoiceDTO.items() == null) {
            return facture;
        }

        for (LigneFactureDTO itemDTO : invoiceDTO.items()) {
            LigneFactureFne item = LigneFactureFne.builder()
                    .reference(itemDTO.reference())
                    .description(itemDTO.description())
                    .quantity(BigDecimal.valueOf(itemDTO.quantity()))
                    .amount(BigDecimal.valueOf(itemDTO.amount()))
                    .discount(BigDecimal.valueOf(itemDTO.discount()))
                    .measurementUnit(itemDTO.measurementUnit())
                    .taxes(itemDTO.taxes() == null ? new ArrayList<>() : new ArrayList<>(itemDTO.taxes()))
                    .build();

            if (itemDTO.customTaxes() != null) {
                for (CustomTaxDTO customTaxDTO : itemDTO.customTaxes()) {
                    CustomTaxe customTaxe = CustomTaxe.builder()
                            .name(customTaxDTO.name())
                            .amount(BigDecimal.valueOf(customTaxDTO.amount()))
                            .build();
                    item.addCustomTax(customTaxe);
                }
            }

            facture.addItem(item);
        }

        return facture;
    }
}
