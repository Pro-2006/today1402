# today1402

This is a tiny Spring Boot example using an H2 in-memory database so you don't need to install MySQL locally.

Run (requires Java 17+ and Maven):

```
mvn spring-boot:run
```

The app starts on port 8080. Sample endpoints (use curl or Postman):

- List all students (pre-seeded):

```
curl http://localhost:8080/main/studentdata/get
```

- Get by id:

```
curl http://localhost:8080/main/studentdata/getbyid/1
```

- Add student:

```
curl -X POST -H "Content-Type: application/json" -d '{"sid":3,"sname":"Kumar"}' http://localhost:8080/main/studentdata/add
```

- Update student (PUT):

```
curl -X PUT -H "Content-Type: application/json" -d '{"sname":"Kumar Updated"}' http://localhost:8080/main/studentdata/update/3
```

- Patch name:

```
curl -X PATCH "http://localhost:8080/main/studentdata/updatename/3?sname=NewName"
```

- Delete student:

```
curl -X DELETE http://localhost:8080/main/studentdata/delete/3
```

H2 console available at: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:klusdb`, user: `sa`, no password)

The app seeds two students via `src/main/resources/data.sql`.
# today1402