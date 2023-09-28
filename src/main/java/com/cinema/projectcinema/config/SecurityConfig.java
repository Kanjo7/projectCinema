package com.cinema.projectcinema.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()

                .withUser("tomas")
                .password("user1234")
                .roles("USER")
                .and()
                .withUser("alexander")
                .password("admin1234")
                .roles("USER", "ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/v4/customers").hasRole("ADMIN")
                .antMatchers("/api/v4/add-movie").hasRole("ADMIN")
                .antMatchers("/api/deletemovie/{id}").hasRole("ADMIN")
                .antMatchers("/api/v4/updateroom").hasRole("ADMIN")
                .antMatchers("/api/v4/movies").hasRole("USER")
                .antMatchers("/api/v4/bookroom").hasRole("USER")
                .antMatchers("/api/v4/updatebooking").hasRole("USER")
                .antMatchers("/api/v4/mybookings/{id}").hasRole("USER")
                .and()
                .csrf().disable()
                .httpBasic();
    }
}