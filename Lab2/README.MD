  # Spring Security In Memory Authentication
  
 ```
    Way to configure authentication is by configuring AuthenticationManager.
 ```
 
 ##
 
 ```
    AuthenticationManager is having a method called authenticate().
    We can use the AuthenticationManager by accessing the AuthenticationManagerBuilder
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
          .roles("USER");
      }

          @Bean
      public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
      }

    }
    
 ```
 
 ##
 ```
  So basically what we are doing over here 
    1.	We created a class named SecurityConfiguration
    2.	We extended the WebSecurityConfigurerAdapter
    3.	Now by overiding the configurer method which takes in argument as the AuthenticationManagerBuilder now using this auh object and chaining method as abover.
    4.	Now adding annotation @EnableWebSecurity to let know the SpringApplication about your security configuration.
    5.	Now passwords are never stored in the plain text form , they have to hashed for the security reasons.
    a.	Spring security is having the password encoding in built.
    b.	Expose an @Bean of type PasswordEncoder.



    @Bean
      public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
      }
    BOOM everything is working.

    Adding multiple users using the and() method.

    auth.inMemoryAuthentication()
          .withUser("sahil")
          .password("sahil")
          .roles("USER")
          .and()
          .withUser("rohan")
          .password("rohan")
          .roles("USER");
      }

 
 ```
