# spring-oauth2

This project demonstrate Oauth2 implementation in Spring Boot with DB.
In this we have Resource Server and Authorization server.
we have some endpoints which are secured by Oauth.

Now here i have used password and refresh-token grant types. In which to access any protected URL's user has to  get Access-token first using following URL
http://localhost:8088/oauth/token
u also need to pass basic authorization in hader
Basic Y2xpZW50MTpzZWNyZXQ=

Check Test-data folder under resources

Access token is valid for Specific amount of time which can be configured in DB.

While accessing any protected URL we have to pass this access-token in request params

When Access-token is expired we will have to refresh our access-token by using refresh-token which we would have got in initial request of access-token
(see images)

database schema needed for this is present under Resources/Database folder

Thanks
