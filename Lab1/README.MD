# Spring Security Basic Example
  
  1. Create a Spring boot project and add the following dependencies
       a. Starter Web
       b. Spring Security
       
  2. This Spring Security dependencies will take care of the Spring Security in our application. 
    
 ## 
 ```
    Spring Security Default Behavior
      1.	Adds mandatory authentication for all those URL’s.
      2.	Adds login form.
      3.	Handles login error.
      4.	Creates a user and sets a default password.
      
      By default the user id and the password is 
      	User id : User
	      Password will be generated in the console.
        But we can edit this user id and credentials also by editing the application.properties
        Spring.security.user.name= foo
        Spring.security.user.password=foo
```
    
 ##  
   
    Basic servlet functionality called filters which is working underneath the spring security application.
        
