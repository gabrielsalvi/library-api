# Library API

This project is a REST API of a Library. It uses the H2 database, an in-memory database, to store the data. Through the endpoints of the application the client can execute some operations to interact with the data, which are related to 3 entities: Author, Book and Genre. So, each entity has its own operations.

## Author

### POST (http://localhost:8080/api/authors)

It's the operation to create an author.

Body:

    {
        "name": "Machado de Assis",
        "citizenship": "Brazilian",
        "birthdate": "21/06/1839"
    }

Status: 201 Created

### GET (http://localhost:8080/api/authors
Manga Survey Giveaway
Hide Ads
)

It's the operation to get all the authors stored in the database.

Response:

    [
        {
            "id": 1,
            "name": "Machado de Assis",
            "citizenship": "Brazilian",
            "birthdate": "21/06/1839"
        }
    ]

Status: 200 OK

### GET (http://localhost:8080/api/authors/1)

It's the operation to get the author that has the id at the end of the endpoint.

Response:

    {
        "id": 1,
        "name": "Machado de Assis",
        "citizenship": "Brazilian",
        "birthdate": "21/06/1839"
    }

Status: 200 OK

### PUT (http://localhost:8080/api/authors/1)

It's the operation to update the author that has the id at the end of the endpoint.

Body:

    {
        "name": "Joaquim Maria Machado de Assis",
        "citizenship": "Brazilian",
        "birthdate": "21/06/1839"
    }

Status: 200 OK

### DELETE (http://localhost:8080/api/authors/1)

It's the operation to delete the author that has the id at the end of the endpoint.

Status: 204 No Content