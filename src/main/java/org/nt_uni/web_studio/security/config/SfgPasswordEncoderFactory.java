package org.nt_uni.web_studio.security.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;

import java.util.HashMap;
import java.util.Map;

public class SfgPasswordEncoderFactory {
    public static PasswordEncoder  createDelegatingPasswordEncoder() {
        String encodingId = "bcrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(encodingId, new BCryptPasswordEncoder(10));
        encoders.put("bcrypt15", new BCryptPasswordEncoder(15));
        return new DelegatingPasswordEncoder(encodingId, encoders);
    }

//    don't initiate class
    private SfgPasswordEncoderFactory(){

    }
}
