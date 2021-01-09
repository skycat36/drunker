package com.vsu.drunker.web.config.security;

import com.vsu.drunker.db.model.entity.DefaultRole;
import com.vsu.drunker.db.model.entity.Role;
import com.vsu.drunker.db.model.entity.User;
import com.vsu.drunker.db.model.repository.RoleRepository;
import com.vsu.drunker.db.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private final RoleRepository roleRepository;

    @PostConstruct
    @SneakyThrows
    private void checkBuckets() {
        for (DefaultRole role : DefaultRole.values()) {
            if (!roleRepository.existsByName(role.name())) {
                roleRepository.save(new Role(role.name()));
            }
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated().and()
                .formLogin()
                .loginPage("/api/user/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserRepository userRepository) {
        return map -> {
            String id = String.valueOf(map.get("sub"));

            User user = userRepository.findByOutId(id).orElseGet(() -> {
                User newUser = new User();
                newUser.setOutId(id);
                newUser.setFio((String) map.get("name"));
                newUser.setName((String) map.get("given_name"));
                newUser.setEmail((String) map.get("email"));
                newUser.setRoleId(roleRepository.findByName(DefaultRole.GUEST.name()).getId());
                return newUser;
            });


            return userRepository.save(user);
        };
    }
}
