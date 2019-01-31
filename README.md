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

The user service providing the current user still need to be called in the middle of any rest endpoint. The endpoint also need to provide the token subject. Perfect solution would be an custom annotation providing the current user on a parameter.

## Problems

- Default AuthenticationManager still displaying random useless password in terminal.
- When the database is down, it still run.
