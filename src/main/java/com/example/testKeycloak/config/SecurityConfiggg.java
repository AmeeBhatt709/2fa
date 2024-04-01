//package com.example.testKeycloak.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfiggg {
//
//    private final JwtAuthConverter jwtAuthConverter;
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth ->
//                        auth.requestMatchers("/api/v1/demo/users","/swagger-ui/**","/v3/api-docs/**").permitAll()
//
//                                .anyRequest().authenticated());
//        http
//                .oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer ->
//                        httpSecurityOAuth2ResourceServerConfigurer.jwt(jwtConfigurer ->
//                                jwtConfigurer.jwtAuthenticationConverter(jwtAuthConverter)));
//        http
//                .sessionManagement(httpSecuritySessionManagementConfigurer ->
//                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        return http.build();
//    }
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
////
////        httpSecurity.csrf(AbstractHttpConfigurer::disable);
////        httpSecurity.addFilterAfter(createPolicyEnforcerFilter(), BearerTokenAuthenticationFilter.class);
////        httpSecurity.sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
////        return httpSecurity.build();
////
////    }
//
//
//
////    private ServletPolicyEnforcerFilter createPolicyEnforcerFilter(){
////        return new ServletPolicyEnforcerFilter(new ConfigurationResolver() {
////            @Override
////            public PolicyEnforcerConfig resolve(HttpRequest httpRequest) {
////                try {
////                    return JsonSerialization.readValue(getClass().getResourceAsStream("/policy-enforcer.json"), PolicyEnforcerConfig.class);
////                } catch (IOException e) {
////                        throw new RuntimeException(e);
////                }
////            }
////        });
////    }
//}
