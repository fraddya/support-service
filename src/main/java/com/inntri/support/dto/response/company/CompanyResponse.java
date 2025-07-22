package com.inntri.support.dto.response.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CompanyResponse {

    private Long id;
    private String code;
    private String name;
    private String email;
    private String contact;
    private String fax;
    private String web;
    private String companyType;
    private String status;

    private LanguageViewResponse.LanguageView preferredLanguage;

    //private CurrencyViewResponse.CurrencyView preferredCurrency;
    private String preferredCurrency;

    private CountryViewResponse.CountryView country;

    private Boolean initialUser;

    private boolean companyOnboarded;

    private boolean usersOnboarded;

    private List<RegisteredModuleData> registeredModules;

    private CompanyCategoryData companyCategory;

    private String logoPath;
    private CompanyData parentCompany;
    private List<AddressData> addresses;

    private String brNumber;
    private String vatNumber;

    @JsonProperty("sVatNumber")
    private String sVatNumber;

    private Boolean isPrivateLimited;
    private Boolean isSoleProprietorship;
    private Boolean isPartnership;
    private Boolean isOther;
    private Boolean isVat;
    private Boolean isSvat;
    private Boolean isNonVat;
    private Float taxPercentage;

    //private CountryData country;

    private List<InvoiceTermData> invoiceTerms;
    private List<BankDetailData> bankDetails;

    @Data
    public static class BankDetailData  {
        private String id;

        private String name;

        private String branch;

        private String accountType;

        private String accountName;

        private String accountNumber;

        private String currency;

        private String passBookCopy;

        private String address;

        private String swiftCode;

        private Boolean isPrimary;
    }

    @Data
    public static class InvoiceTermData {
        private String id;
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

        private String vehicleType;
        private AddressData fromLocation;//start location
        private AddressData toLocation;//destination
        //private RouteTemplate route;
    }

    @Data
    public static class CountryData {
        private String id;
    }

    private List<AttachmentData> attachments;

    @Data
    public static class AttachmentData  {
        private String id;
        private String type;

        private String attachment;
    }

    @Data
    public static class AddressData  {
        private String id;
        private String address;
        private String area;
        private String city;
        private String code;
        private String addressType;
    }

    @Data
    public static class CompanyData {
        private String id;
        private String extId;

        private String code;

        private String name;

        private String email;

        private String contact;
        private String companyType;
    }

    @Data
    public static class CompanyCategoryData {
        private String id;
        private String name;

    }

    @Data
    public static class RegisteredModuleData {
        private String id;
        private String name;

    }

    @Data
    public class LanguageViewResponse {
        private LanguageView content;
        @Data
        public static class LanguageView {
            private String id;
            private String name;
        }
    }

    @Data
    public class CurrencyViewResponse {
        private CurrencyView content;
        @Data
        public static class CurrencyView {
            private String id;
            private String name;
        }
    }

    @Data
    public class CountryViewResponse {
        private CountryView content;
        @Data
        public static class CountryView {
            private String id;
            private String name;
        }
    }

}
