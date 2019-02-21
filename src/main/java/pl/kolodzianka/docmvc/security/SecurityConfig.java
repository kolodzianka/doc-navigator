package pl.kolodzianka.docmvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/home", "/document/**").hasAnyRole("ROLE_USER", "ROLE_MODERATOR", "ROLE_ADMIN")
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("adduser")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(((httpServletRequest, httpServletResponse, authentication) -> {
                    for (GrantedAuthority authority : authentication.getAuthorities()){
                        System.out.println(authority.getAuthority());

                    }
                    System.out.println(authentication.getName());
                    httpServletResponse.sendRedirect("/home");
                }))
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    String errorMsg;
                    if(e.getClass().isAssignableFrom(BadCredentialsException.class)){
                        errorMsg = "Invalid email or password.";
                    }
                    else {
                        errorMsg = "Unknow error - " + e.getMessage();
                    }
                    httpServletRequest.getSession().setAttribute("message", errorMsg);
                    httpServletResponse.sendRedirect("/login");
                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/logOut")
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletRequest.getSession().setAttribute("message", "Succesfull log out.");
                    httpServletResponse.sendRedirect("/login");
                })
                .permitAll()
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().disable();





    }



    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean(name = "userDetailService")
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }


}
