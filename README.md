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
  GET /clients
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
  POST /clients
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`         | `string` | **Required**. > 1 characters|
| `cpf`        | `string` | **Required**.   -> is cpf|


#### Put client

```http
  PUT /clients/id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`         | `string` | **Required**. > 1 characters|
| `email`        | `string` | **Required**. -> is cpf|

#### Delete client

```http
  DELETE /clients/id
```


#### Post services

```http
  POST /services
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`       | `LocalDate` | **Required**. > dd-MM-yyyy|
| `valor`        | `bigdecimal` | **Required**.   -> bigdecimal|
| `description`       | `string` | **Required**. > 150 characters|
| `client`        | `Client` | **Required**.   -> is client|


#### Get services by client name and month 

```http
  GET /services
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `mes` | `integer` | **optional**|
| `nome` | `string` | **optional**|







