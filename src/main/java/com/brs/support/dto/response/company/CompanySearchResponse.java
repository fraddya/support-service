package com.brs.support.dto.response.company;

import lombok.Data;

@Data
public class CompanySearchResponse {

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

}
