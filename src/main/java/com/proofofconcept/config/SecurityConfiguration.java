package com.proofofconcept.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        User.UserBuilder user = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(user.username("admin").password("admin").roles("ADMIN"))
                .withUser(user.username("user").password("user").roles("USER"));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2-console/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/employees/**","/requests/**","/departments/**").hasAnyRole("ADMIN")
                .antMatchers("/requests/**").hasRole("USER")
                .anyRequest().authenticated()
                .and().httpBasic().and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();


    }
}
