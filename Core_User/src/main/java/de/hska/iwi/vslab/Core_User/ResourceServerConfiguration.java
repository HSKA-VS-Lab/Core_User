package de.hska.iwi.vslab.Core_User;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;


@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("*").authorizeRequests()
            .antMatchers("/user").hasAuthority("ADMIN")
            .antMatchers("/user/**").hasAuthority("USER")
            .anyRequest().fullyAuthenticated();
        // user/** funzt 
        //http.antMatcher("/user").authorizeRequests()
          //  .antMatchers("/user").hasAuthority("ADMIN")
            //.antMatchers("/user/**").hasAuthority("ADMIN")
            //.anyRequest().fullyAuthenticated();


        //.authorizeRequests().antMatchers("/user").hasAuthority("ROLE_ADMIN")
        //.and().authorizeRequests().antMatchers("/user/*").fullyAuthenticated().anyRequest().permitAll();//.anyRequest().permitAll(); // this is not allowed
          
        //.and().authorizeRequests().antMatchers("/user/*").permitAll(); // this works
        //http.authorizeRequests().antMatchers("/whoami").permitAll();
                //.antMatchers("/user").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN", "#oauth2.hasScope('meassage:read')").anyRequest().authenticated();//.authenticated();
                //.antMatchers("/user").authenticated()
                //.and()
                //.authorizeRequests().antMatchers("/whoami").authenticated();
                //.antMatchers("/user").hasAuthority("ROLE_ADMIN").anyRequest().authenticated();
                //.antMatchers("/user").hasRole("ROLE_ADMIN").anyRequest().authenticated();
               // ("ROLE_USER");
        //http.authorizeRequests()
        //        .antMatchers("/user").permitAll()a
        //        .anyRequest().authenticated();
        //http.authorizeRequests().antMatchers("/").authenticated()
        //http.authorizeRequests().antMatchers("/user").anonymous()
        //        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());

        //http.authorizeRequests()
            //.antMatchers(GET,"/search").permitAll()
          //  .antMatchers("/user").hasAuthority("ROLE_USER")
            //.anyRequest().denyAll();

    }


}