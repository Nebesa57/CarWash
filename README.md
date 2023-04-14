
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```

`POST localhost:8080/api/auth/signup`
```
{
    "username": "admin",
    "numberMobile": "admin@gmail.com",
    "password": "12345678",
    "role": ["admin, moderator"]
}
```


`POST localhost:8080/api/auth/signin`
```
{
    "username": "admin",
    "password": "1234"
}
```
