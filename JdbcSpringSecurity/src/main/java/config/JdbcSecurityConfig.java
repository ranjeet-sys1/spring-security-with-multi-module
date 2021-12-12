package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class JdbcSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/love").hasRole("ranjeet")
                .antMatchers("/wife").hasAnyAuthority("admin","panda")
                .antMatchers("/affair").authenticated()
                .antMatchers("/rich").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        JdbcUserDetailsManager jdbcUserDetailsManager= new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        UserDetails userDetails1 = User.withUsername("ranjeet").password(passwordEncoder().encode("larika")).roles("admin").authorities("admin").build();
        UserDetails userDetails2 = User.withUsername("suman").password(passwordEncoder().encode("satapathy")).roles("admin").authorities("admin").build();
        UserDetails userDetails3 = User.withUsername("Mature").password(passwordEncoder().encode("NaughtyGirlFriend")).roles("ranjeet").build();
        jdbcUserDetailsManager.createUser(userDetails1);
        jdbcUserDetailsManager.createUser(userDetails2);
        jdbcUserDetailsManager.createUser(userDetails3);
        auth.userDetailsService(jdbcUserDetailsManager);



    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
