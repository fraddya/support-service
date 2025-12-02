package com.brs.support.dto.response.company;

import lombok.Data;

import java.util.List;

@Data
public class CompanyViewResponse {

    private String id;
    private String code;
    private String name;
    private String companyType;
    private String status;
    private Long preferredLanguageId;

    private Long preferredCurrencyId;

    private Long countryId;

    private boolean companyOnboarded;

    private boolean usersOnboarded;

    private List<AddressData> addresses;

    @Data
    public static class AddressData  {

        private Long id;

        private String address;

        private String code;

        private String area;

        private String city;

        private String addressType;
    }
}
