# Spring Security Authentication and Authorization Example

##

```
Now we have to implement authentication and authorization

  protected void configure(AuthenticationManagerBuilder auth) -- > Authentication 
  protected void configure(HttpSecurity http) -- > Authorization
```

##

```
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
			.withUser("sahil")
			.password("sahil")
			.roles("USER")
			.and()
			.withUser("rohan")
			.password("rohan")
			.roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("USER","ADMIN")
			.antMatchers("/").permitAll()
			.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}

}

```
  
  

