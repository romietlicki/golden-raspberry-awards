# golden-raspberry-awards

## In order to run this app. we need to simply clone and build: 
-mvn clean install

and:

-run as Spring Boot App Application

## url:
import the following collection to your postman:

{
	"info": {
		"_postman_id": "4467c283-9d63-48db-9b19-071fcdeb2fa5",
		"name": "golden-raspberry-awards",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "localhost:8080/awards/api/awards/intervals",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost:8080/awards/api/awards/intervals",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"awards",
						"api",
						"awards",
						"intervals"
					]
				}
			},
			"response": []
		}
	]
}

  
## Database:
H2 banco em memória
  
H2 Console: http://localhost:8080/awards/h2-console/login.jsp
  
  url: jdbc:h2:mem:testdb
  
  user: sa
  
  password: password
