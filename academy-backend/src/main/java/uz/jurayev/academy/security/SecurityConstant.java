package uz.jurayev.academy.security;

import lombok.Data;

@Data
public class SecurityConstant {

    public static final String GENERATE_TOKEN_URL = "http://ministry.hemis.uz/app/rest/v2/oauth/token";
    public static final String AUTHORIZATION = "Basic Y2xpZW50OnNlY3JldA==";
    public static final String GRANT_TYPE = "password";
    public static final String USERNAME = "railway";
    public static final String PASSWORD = "5pk2zzM5F7c6dHW";
    public static final String TOKEN = "4f556921-01b0-4075-93fe-da00a1af579b";
}
