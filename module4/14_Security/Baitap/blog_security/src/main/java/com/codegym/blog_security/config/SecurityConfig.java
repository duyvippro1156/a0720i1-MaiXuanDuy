package com.codegym.blog_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity()
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user").password("12345").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/create**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/save**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/view**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/delete**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/edit**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/category/list_category**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/category/create**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/category/save**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/category/delete**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/category/edit**").hasRole("USER")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }


}
