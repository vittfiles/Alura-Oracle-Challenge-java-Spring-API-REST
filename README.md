<h1 align="center"> Alura & Oracle Next Education Challenge: Java Spring Boot API Foro Hub </h1>

<div align="center">
   This is a challenge for <a href="https://www.aluracursos.com/" target="_blank">Alura Latam</a> and <a href="https://www.oracle.com/ar/education/oracle-next-education/" target="_blank">Oracle Next Education</a>.
</div>

<!-- TABLE OF CONTENTS -->

## Table of Contents

- [Overview](#Overview)
- [Deploy](#Deploy)
- [How to use](#How-to-use)
- [Developers](#developers)

## Overview

This is a challenge called Foro Hub made with Spring Boot.
You can connect to this API to handle topics.

## Deploy

Create a database using MySQL and add the credentials in the referenced system environment variables
in the application.properties file.

## How to use
- Create an user.
 ```
    url: /usuarios
    method: POST
    body (json): 
    {
      "name": "John",
      "email": "example@email.com",
      "password": "123456"
    }
```
- Get a session.
 ```
    url: /login
    method: POST
    body (json): 
    {
      "email": "example@email.com",
      "password": "123456"
    }
```
- Create a course.
 ```
    url: /cursos
    method: POST
    Authentication: Bearer {token}
    body (json): 
    {
      "name": "javascript",
      "category": "programming"
    }
```
- Update a course.
 ```
    url: /cursos/{id}
    method: PUT
    Authentication: Bearer {token}
    body (json): 
    {
      "name": "html",
      "category": "programming"
    }
```
- List all courses.
 ```
    url: /cursos
    method: GET
    Authentication: Bearer {token}
```
- Get a course by id.
 ```
    url: /cursos/{id}
    method: GET
    Authentication: Bearer {token}
```
- Delete a course.
 ```
    url: /cursos/{id}
    method: DELETE
    Authentication: Bearer {token}
```
- Create a topic.
 ```
    url: /topicos
    method: POST
    Authentication: Bearer {token}
    body (json): 
    {
      "title": "Issue",
      "message": "some message",
      "author": {user id},
      "course": {course id}
    }
```
- Get all the topics.
 ```
    url: /topicos
    method: GET
    Authentication: Bearer {token}
```
- Get a topic by id with author and course data.
 ```
    url: /topicos/{id}
    method: GET
    Authentication: Bearer {token}
```
- Update a topic.
 ```
    url: /topicos/{id}
    method: PUT
    Authentication: Bearer {token}
    body (json): 
    {
      "title": "new issue",
      "message": "new message",
      "author": {user id},
      "course": {course id}
    }
```
- Delete a topic.
 ```
    url: /topicos/{id}
    method: DELETE
    Authentication: Bearer {token}
```

## Developers

- <a href="https://www.linkedin.com/in/matias-m-79b5652a0/" target="_blank">Matias M. (vittfiles).</a>