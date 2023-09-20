package uy.gub.bps.apirestbps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import uy.gub.bps.apirestbps.security.FiltroJWTAutorizacion;

@SpringBootApplication
@EnableSwagger2
public class ApiRestBpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestBpsApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configuracionCorsGlobal(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping("/api/v1/**")
						.allowedMethods("GET", "POST", "PUT")
						.allowedOrigins("*");
			}
		};
	}


	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter{

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterBefore(new FiltroJWTAutorizacion(),
							UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					//.antMatchers(HttpMethod.POST, "/api/v1/seguridad/autenticacion")
					.antMatchers("/api/v1/seguridad/**",
							"/v2/api-docs/**",
							"/swagger-ui/**",
							"/swagger-resources/**",
							"/configuration/**")
					.permitAll()
					.anyRequest()
					.authenticated();
		}
	}

}
