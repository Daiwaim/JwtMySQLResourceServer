# JwtMySQLResourceServer

## Database creation

```
mysql> create database spring_mysql_demo;
mysql> create user 'spring_mysql_demo_user' identified by 'thisRandomPassword';
mysql> grant all on spring_mysql_demo.* to 'spring_mysql_demo_user';
```

In `src/main/resources/application.yml` edit database settings ( name / username / password )

## Issuer-uri

Don't forget to edit the issuer-uri
Upon starting, the Resource Server will fetch the issuer public key. This key will allow token validation.

## Test

Once you have a JWT ready, you can test the app in a terminal this way:
```bash
export TOKEN=your_generated_token
curl -H "Authorization: Bearer $TOKEN" localhost:8080/
```
This ResourceServer work well with third party JWT authentication, like Firebase.

## Improvements

When a user make a request, we need to get the corresponding user in the jpa. When there is no corresponding user (a new guy) we need to register him. All this should be done in a function, not in the middle of a rest endpoint.

## Problems

- Default AuthenticationManager still displaying random useless password in terminal.
