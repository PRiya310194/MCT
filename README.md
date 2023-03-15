# MCT
#Requirement

Intellijidea

Severport:8080(use local host:8080)

java version 17

Everything is present in pom.xml(no need to download any library)

#Steps to run the project

Download the source code and import in intelliJIDEA.

Go to localhost:8080

Put specific end point and ru the api

#Dependencies

a) Spring web->Buidl web,including restFul,application using spring mvc.

b) Spring boot DEv tools->

Provides fact application restart, LiveReload and configuration for enhancnced development experience

c)Lombook-> Java annonation libraty which helps to redure boilplate code

d)JSON-> JSON is a light-weight, language independent, data interchnage format.See http://www.JSON.org/.The files in this pachage implement JSON encoders/decoders in java.It also includes the capability to convert between JSON and XML,HTTP HEADERS,cOOKIES AND CDL.

#Working->

User

There are two models in this project .one is user and another is post.User and post many post.
User can be added, modify, delete and update.

Post

Here i am performing the similar operation such as add, delete,update and get post.

#Controller->
usercontroller
postController

#Service

>userservice

>PostService

#Repository

>userRepository

>postRepository

#Endpoint->

Add user-> In add userFunctionality we post user info through postman and get it added to the user.
Endpoint is-> http://localhost:8080/save-user

Get userByUserId-In this we send particular userId and get that user info

ensdpoint is-http://localhost:8080/user?userId=userId

Get all user->
This functionality provided all user 
end dpoint is-http://localhost:8080/user

Updata user->
This functionality updates particulat user info through postman by sending userId in url
end point is->http://localhost:8080/user/userId

@DeleteUser by id-
This functionality deletes particulr user info through postman using the deletemethod by send ing the id in url

end point is- http://localhost:8080/user/{userId}



