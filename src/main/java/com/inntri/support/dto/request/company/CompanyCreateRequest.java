package com.inntri.support.dto.request.company;

import com.inntri.support.enums.BankAccountType;
import com.inntri.support.enums.CurrencyType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CompanyCreateRequest {

  private Long id;

  @NotBlank(message = "Company code is required")
  @Length(max = 10, message = "Company code length exceeds.")
  private String code;

  @NotBlank(message = "Company name is required")
  @Length(max = 100, message = "Company name length exceeds.")
  private String name;

  @NotEmpty(message = "Email is required.")
  @NotNull(message = "Email is required.")
  private String email;

  private String contact;

  private String fax;

  private String web;

  private Boolean initialUser;

  private PreferredLanguageData preferredLanguage;

  //private PreferredCurrencyData preferredCurrency;
  private String preferredCurrency;

  private List<RegisteredModuleData> registeredModules;

  //private CompanyData parentCompany;

  private CompanyCategoryData companyCategory;

  private List<AddressData> addresses;

  private String brNumber;
  private String vatNumber;
  private String sVatNumber;
  private Boolean isPrivateLimited;
  private Boolean isSoleProprietorship;
  private Boolean isPartnership;
  private Boolean isOther;
  private Boolean isVat;
  private Boolean isSvat;
  private Boolean isNonVat;
  private Float taxPercentage;

  private List<AttachmentData> attachments;

  private List<BankDetailData> bankDetails;

  private CountryData country;

  private List<InvoiceTermData> invoiceTerms;

  private String logoPath;

  @Data
  public static class InvoiceTermData {
    private String creditTerm;
    private BigDecimal creditLimit;
    private String checkPrintName;
    private Integer creditPeriod;//number of days
    private String invoicingMethod;
    private BigDecimal perKmRate;
    private BigDecimal fixedRate;
    private BigDecimal oneTimeRate;
    private String invoiceCode;
    private String validFrom;
    private Integer maxKm;
    private String VehicleType;
    private Long fromLocationId;//start location

    private Long toLocationId;//destination

    private Long routeId;
  }

  @Data
  public static class PreferredLanguageData {
    private Long id;
  }

  @Data
  public static class PreferredCurrencyData {
    private Long id;
  }

  @Data
  public static class CountryData {
    private Long id;
  }

  @Data
  public static class AttachmentData  {
    private String type;

    private String attachment;
  }

  @Data
  public static class CompanyCategoryData {
    private Long id;
  }

  @Data
  public static class CompanyData {
    private Long id;
  }

  @Data
  public static class RegisteredModuleData {
    private Long id;
  }

  @Data
  public static class AddressData  {
    private String address;
    private String area;
    private String city;
    private String code;
    private String addressType;
  }

  @Data
  public static class BankDetailData  {

    private Long id;

    private String name;

    private String branch;

    private BankAccountType accountType;

    private String accountName;

    private String accountNumber;

    private CurrencyType currency;

    private String passBookCopy;

    private String address;

    private String swiftCode;

    private String isPrimary;
  }


}
