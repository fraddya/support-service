package com.inntri.support.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties("app")
@Configuration
public class AppPropertiesConfig {

  private S3 s3;

  @Data
  public static class S3 {

    private String accessKey;
    private String secretKey;
    private String bucketName;
    private String uploadedFolderName;
  }

}