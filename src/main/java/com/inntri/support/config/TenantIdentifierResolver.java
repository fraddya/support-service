package com.inntri.support.config;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TenantIdentifierResolver
    implements CurrentTenantIdentifierResolver, HibernatePropertiesCustomizer {

  private String currentTenant = "unknown";

  private Long companyId;

  public TenantIdentifierResolver() {}

  public TenantIdentifierResolver(String currentTenant) {
    this.currentTenant = currentTenant;
  }

  @Override
  public String resolveCurrentTenantIdentifier() {
    return currentTenant;
  }

  @Override
  public boolean validateExistingCurrentSessions() {
    return false;
  }

  @Override
  public void customize(Map<String, Object> hibernateProperties) {
    hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, this);
  }

  public String getCurrentTenant() {
    return currentTenant;
  }

  public void setCurrentTenant(String tenant) {
    currentTenant = tenant;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }
}
