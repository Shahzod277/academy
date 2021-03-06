package uz.jurayev.academy.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class SecurityConstant {

    //Api HEMIS
    public static final String GENERATE_TOKEN_URL = "http://ministry.hemis.uz/app/rest/v2/oauth/token";
    public static final String GET_STUDENT_URL = "http://ministry.hemis.uz/app/rest/v2/services/student/get?pinfl=";
    public static final String AUTHORIZATION = "Authorization";
    public static final String AUTHORIZATION_VALUE = "Basic Y2xpZW50OnNlY3JldA==";
    public static final String GRANT_TYPE = "password";
    public static final String USERNAME = "railway";
    public static final String PASSWORD = "5pk2zzM5F7c6dHW";


    //Custom token


    public static String SECRET_KEY = "TutorAcademyTutorAcademyTutorAcademyTutorAcademyTutorAcademyTutorAcademyTutorAcademy";
    public static Long ADMIN_EXPIRE_AT = 1_800_000L;
    public static Long TUTOR_EXPIRE_AT = 3_600_000L;
}
