package com.xavient.user.management;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "user.rest")
@Data
public class UserProperties {
 
    private String databaseurl;
    
    private String username;
    
    private String password;
 
    // other fields with standard getters and setters
}	