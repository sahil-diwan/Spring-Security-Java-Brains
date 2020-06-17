# Authentication Example Using User Details Service

```
  For Authentication there are a bunch of out of the box implementations for Spring Security provides.
	Like for JDBC – there is JDBCAuthentication Manager.
	For LDAP – there is LDAP Authentication Manager.
	However for JPA there is no out of the Box authentication mechanisms. 

  	We have authentication manager which talks to authentication provider which talks to user details service. So this user details service has one method which gets the user information based on the user name.
	Now Spring security has a way for you to provide this userdetails service , so we can create a userdetailservice which takes in a username and returns a user object of type UserDetails.
  So you can create a service and hand it over to spring security and say any time you gonna lookup a user call my service and spring security is going to manage the rest . 
  Inorder to validte the service spring security is going to call my userdetails service.
  Now this custom user details service that you have created is going to fetch the userdetails from the database using the JPA .
	So this service which we are creating has nothing to do with the JPA , it can be any source it can be a file or anything.

  First in order to try this we are going to create the user details service which is going to return the hardcoded user.

```
#

```
@Autowired 
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
	}

```

#
```
    package com.sd.security.lab6;

    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.stereotype.Service;

    @Service
    public class MyUserDetailService implements UserDetailsService{

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return new MyUserDetails(username);
      }
    }

```

#

```

Now if we want to authenticate with some logic that has nothing to do with the JPA  that’s all it takes.

Now we are going to create a hard coded userDetailsinstance.For that we are going to create the class MyUserDetails implements UserDetails

```

```
  package com.sd.security.lab6;

import java.util.ArrayList;
import java.util.Collection;

import org.assertj.core.util.Arrays;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{
	
	private String userName;
	
	public MyUserDetails(String userName) {
		this.userName = userName;
	}
	
	public MyUserDetails() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> authority = new ArrayList<>();
		authority.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "pass";
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

```

#

```
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAuto
Configuration

Add the above lines to the application.properties

```
