# Kovert
A quick inverted index API implemented in Kotlin using Spring Boot.

## Endpoints
First, add documents to be indexed:
```
POST /documents

{
    "content": "Something to read"
}
```

Then, search for them. Results will be ordered by hits (in descending order)
```
GET /documents?q=something+read
```
