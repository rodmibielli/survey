
# Survey Project

This project creates and manages dynamics surveys and link them with a pool of questions also created dynamically and it also has hability to capture responses. 

Each survey is bound to a contact.

This model is based from https://www.youtube.com/watch?v=SjRuAC5rLsk
##  The Model

```mermaid

classDiagram
 
 class Contact {
   -String name
   -String email
 }
 
 class Survey {
    -UUID id
    -String title
 }

 class Question {
    -UUID id
    -String text
    -ResponseType responseType
 }

 class ResponseType {
    <<Enumeration>>
    TEXT
    DATE
    INTEGER
    REAL 
    BOOLEAN 
 }
 
 class SurveyQuestion {
   -Integer sequence 
 }
 

 class SurveyResponse {
   -Date datetime
   
 }

 class ResponseSet {

 }

 class ResponseValue {
    
 }

 class SurveyResponseQuestion {
    -String responseText
    -Date responseDate
    -Long responseInteger
    -Double responseReal
    -Boolean responseBoolean
    +Object getResponse()
 }
 
 Contact "1"--"*" SurveyResponse
 SurveyResponseQuestion "*"--"1" SurveyResponse
 SurveyResponseQuestion "*" -- "1" Question
 
 Survey "1"--"*" SurveyQuestion
 SurveyQuestion "*"--"1" Question
 SurveyResponse "*"--"1" Survey
 ResponseSet "1"--"*" ResponseValue

 ResponseSet "1"--"*" Question
 Question..>ResponseType
  
```

## Autores

- [@rodmibielli](https://www.github.com/rodmibielli)


## Stack utilizada

**Front-end:** RESTful web services, Swagger UI

**Back-end:** Java 17+, Maven 3, Spring Boot 3, JPA with Hibernate, H2 for dev db, MySQL for prod db.


## References

 - [Data Architecture: Survey Data Model Explained, Simple to Complex](https://www.youtube.com/watch?v=SjRuAC5rLsk)

