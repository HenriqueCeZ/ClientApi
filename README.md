# Spring-Api

API spring utilizando conceitos RESTs



## Installation

Install API with mvn

```bash
  mvn install
  mvn spring-boot:run
```
    
## API Reference

#### Get all clients

```http
  GET /clients/all
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `token` | `string` | **optional**|

#### Get client by id

```http
  GET /clients/id
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `token` | `string` | **optional**|


#### Post new client

```http
  POST /client/new
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`         | `string` | **Required**. > 1 characters|
| `cpf`        | `string` | **Required**.   -> is cpf|


#### Put client

```http
  PUT /clients/update/id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`         | `string` | **Required**. > 1 characters|
| `email`        | `string` | **Required**. -> is cpf|

#### Delete client

```http
  DELETE /clients/id
```





