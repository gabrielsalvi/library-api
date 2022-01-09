# Library API

This project is a REST API of a Library. It uses the H2 database, an in-memory database, to store the data. Through the endpoints of the application the client can execute some operations to interact with the data, which are related to 2 entities: Author and Book. So, each entity has its own operations.

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

### GET (http://localhost:8080/api/authors)

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

It's the operation to get the author by the id that is at the end of the path.

Response:

    {
        "id": 1,
        "name": "Machado de Assis",
        "citizenship": "Brazilian",
        "birthdate": "21/06/1839"
    }

Status: 200 OK

### PUT (http://localhost:8080/api/authors/1)

It's the operation to update the author by the id that is at the end of the path.

Body:

    {
        "name": "Joaquim Maria Machado de Assis",
        "citizenship": "Brazilian",
        "birthdate": "21/06/1839"
    }

Status: 200 OK

### DELETE (http://localhost:8080/api/authors/1)

It's the operation to delete the author by the id that is at the end of the path.

Status: 204 No Content

## Book

### POST (http://localhost:8080/api/books)

It's the operation to create a book.

Body:

    {
        "title": "Dom Casmurro",
        "authors": [
            {
                "id": 1
            }
        ],
        "genres": [
            "Romance", 
            "Fiction"
        ],
        "pages": 210
    }

Status: 201 Created

### GET (http://localhost:8080/api/books)

It's the operation to get all the books stored in the database.

Response:

    [
        {
            "id": 1,
            "title": "Dom Casmurro",
            "authors": [
                {
                    "id": 1,
                    "name": "Machado de Assis",
                    "citizenship": "Brazilian",
                    "birthdate": "21/06/1839"
                }
            ],
            "genres": [
                "Romance",
                "Fiction"
            ],
            "pages": 210
        }
    ]

Status: 200 OK

### GET (http://localhost:8080/api/books/1)

It's the operation to get the book by the id that is at the end of the path.

Response:

    {
        "id": 1,
        "title": "Dom Casmurro",
        "authors": [
            {
                "id": 1,
                "name": "Machado de Assis",
                "citizenship": "Brazilian",
                "birthdate": "21/06/1839"
            }
        ],
        "genres": [
            "Romance",
            "Fiction"
        ],
        "pages": 210
    }

Status: 200 OK

### PUT (http://localhost:8080/api/books/1)

It's the operation to update the book by the id that is at the end of the path.

Body:

    {
        "id": 1,
        "title": "Dom Casmurro",
        "authors": [
            {
                "id": 1,
                "name": "Machado de Assis",
                "citizenship": "Brazilian",
                "birthdate": "21/06/1839"
            }
        ],
        "genres": [
            "Romance",
            "Fiction"
        ],
        "pages": 300
    }

Status: 200 OK

### DELETE (http://localhost:8080/api/books/1)

It's the operation to delete the book by the id that is at the end of the path.

Status: 204 No Content