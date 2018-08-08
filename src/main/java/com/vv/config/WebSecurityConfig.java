package com.vv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * Created by alexis.vasquez on 15/3/2018.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        /*auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select nombre_usuario,password, enabled from users where nombre_usuario=?")
                .authoritiesByUsernameQuery("select nombre_usuario, role from user_roles where nombre_usuario=?");*/


        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select user_id, password, habilitado"
                        + " from usuario_sistema where user_id=?")
                .authoritiesByUsernameQuery("select user_id, authority "
                        + "from authorities where user_id=?")
                .passwordEncoder(new BCryptPasswordEncoder());

           /* //login con db
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled"
                        + " from users where username=?")
                .authoritiesByUsernameQuery(" select username, authority "
                        + "from authorities where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());*/


         auth.inMemoryAuthentication()
                .withUser("Ajosue24").password("$2a$10$2Bh/CFmuoofz2uPdDsuw4.FgvlDwk10t905WhUZgkD.EFtLrx6gAO").roles("ADMIN")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder());

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*original funcionando
        http.authorizeRequests().antMatchers("/").hasAnyRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                .csrf().disable();
*/
        http.authorizeRequests().
                antMatchers("/admin**").
                hasAnyRole("ADMIN", "USER").
                and().
                formLogin().
                loginPage("/login").
                defaultSuccessUrl("/index").
                failureUrl("/login?error").
                usernameParameter("username").
                passwordParameter("password").
                and().
                logout().
                logoutSuccessUrl("/login?logout").
                deleteCookies("JSESSIONID").
                and().
                sessionManagement().
                maximumSessions(1).
                expiredUrl("/401");


                //JDBC
/*        http.authorizeRequests().antMatchers("/")
                .hasAnyRole("/").and()
                .formLogin()
                .and()
                .logout().
                logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                .csrf().disable();*/
    }


    //coment

}