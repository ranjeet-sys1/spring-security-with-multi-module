package com.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // /notice "/bank"-----not secured
    // "/account","/cards","/loan",----secured


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/notice").permitAll()
                .antMatchers("/bank").permitAll()
                //now secured url below
                .antMatchers("/account").hasAnyAuthority("emp","hr")
                .antMatchers("/cards").hasAuthority("admin")
                .antMatchers("/loan").authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("1234").roles("admin").authorities("admin")
                .and().withUser("emp").password("1234").roles("emp").authorities("emp")
                .and().withUser("hr").password("1234").roles("hr").authorities("hr")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

   /* @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }*/
}
