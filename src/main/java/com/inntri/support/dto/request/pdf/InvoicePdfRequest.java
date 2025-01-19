package com.inntri.support.dto.request.pdf;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class InvoicePdfRequest {

    private CompanyViewResponseData company;

    private CompanyViewResponseData customer;

    private String invoiceNumber;//Customer wise system generated number - should be auto generated

    private LocalDate invoiceDate;

    private LocalDate dueDate;

    private String s3UploadFolderName;

    //private String htmlTemplateName;

    private String html;


    @Data
    public static class CompanyViewResponseData {
        private String id;
        private String code;
        private String name;
        private String email;
        private String contact;
        private String companyType;
        private String status;
        private LanguageViewResponse.LanguageView preferredLanguage;

        private CurrencyViewResponse.CurrencyView preferredCurrency;

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
        private String sVatNumber;
        private Boolean isPrivateLimited;
        private Boolean isSoleProprietorship;
        private Boolean isPartnership;
        private Boolean isOther;
        private Boolean isVat;
        private Boolean isSvat;
        private Boolean isNonVat;

        //private CountryData country;

        private PaymentData payment;


    }

    @Data
    public static class PaymentData {
        private String id;
        private String creditTerm;
        private BigDecimal creditLimit;
        private String checkPrintName;
        private Integer creditPeriod;//number of days
        private String invoicingMethod;
        private BigDecimal perKmRate;
        private BigDecimal fixedRate;
        private BigDecimal oneTimeRate;
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
        private Long id;
        private String name;

    }

    @Data
    public class LanguageViewResponse {

        private LanguageView content;
        @Data
        public static class LanguageView {
            private Long id;

            private String name;
        }
    }

    @Data
    public class CurrencyViewResponse {

        private CurrencyView content;

        @Data
        public static class CurrencyView {
            private Long id;

            private String name;
        }


    }

    @Data
    public class CountryViewResponse {

        private CountryView content;

        @Data
        public static class CountryView {
            private Long id;

            private String name;
        }

    }
}
