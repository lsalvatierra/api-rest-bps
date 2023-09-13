package uy.gub.bps.apirestbps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uy.gub.bps.apirestbps.security.FiltroJWTAutorizacion;

@SpringBootApplication
public class ApiRestBpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestBpsApplication.class, args);
	}

	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter{

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			super.configure(http);
			http.csrf().disable()
					.addFilterBefore(new FiltroJWTAutorizacion(),
							UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/api/v1/seguridad/autenticacion")
					.permitAll()
					.anyRequest()
					.authenticated();
		}
	}

}
