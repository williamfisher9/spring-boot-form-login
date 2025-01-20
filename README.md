# Form Login Using Spring Security
With form login, spring security displays a default login form to the user to use unless a different login page is specified in the security configurations.

The username and password are validated against spring security default credentials or the username and password specified in application.properties

```application.properties
spring.security.user.name=user
spring.security.user.password=password
```

Upon successful authentication, spring security redirects the user to the default success URL specified in spring config bean.

- Create a spring boot project using spring initializer and add Spring Security and Web as dependencies.
- Create a security config class with the below configurations:
    ```SecurityConfig.java
    package com.apps.auth;
    
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.web.SecurityFilterChain;
    
    @Configuration
    @EnableWebSecurity
    @EnableMethodSecurity
    public class SecurityConfig {
    
        @Bean
        public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
            http.csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                    .formLogin(form -> form.defaultSuccessUrl("/home", true));
    
            return http.build();
        }
    }
    ```

- Add the below Controller class:
    ```AppController.java
    package com.apps.auth;
    
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @RestController
        public class AppController {
            @GetMapping("/home")
            public String getHome(){
            return "home page";
        }
    }
    ```