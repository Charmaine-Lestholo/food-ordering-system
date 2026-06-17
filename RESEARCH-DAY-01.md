 ***Q1. What does CRUD stand for?***
 
 CRUD stands for Create, Read, Update and Delete. These are the four basic operations performed on data in an application.

 ***Q2 Difference between POST, PUT, PATCH and DELETE***
 
 POST creates a new resource, PUT updates an existing resource by replacing the resource data, PATCH updates only specific fields of a resource and   DELETE removes a resource from the system.

 ***Q3. Give the correct HTTP status code for each:***

 a. New category created = 201 Created

 b. Category deleted successfully = 204 No Content
 
 c. ID does not exist = 404 Not Found

 d. Missing required field = 400 Bad Request

 e. Logged in but not allowed = 403 Forbidden

 ***Q4. Difference between @RequestBody, @RequestParam, @PathVariable - with one tiny example of each.***

 @RequestBody gets data from the request body.

Example:
@PostMapping
public CategoryDto create(@RequestBody CategoryDto dto)

@RequestParam gets data from URL query parameters.

Example:
@GetMapping
public String search(@RequestParam String name)

@PathVariable gets data from the URL path.

Example:
@GetMapping("/{id}")
public CategoryDto get(@PathVariable Long id)

***Q5. What is Jakarta Bean Validation? Explain @Valid, @NotBlank, @Size.***

Jakarta Bean Validation is used to validate incoming data before processing it. @Valid triggers validation, @NotBlank ensures a field is not null, empty or only spaces and @Size checks minimum and maximum length requirements.

***Q6. Why return a DTO and not the entity itself? Give 2 reasons.***

1. DTOs hide sensitive or unnecessary fields.

2. DTOs reduce coupling between the API and database structure.

***Q7. What is Optional<T>? Why does findById return Optional?***

Optional<T> represents a value that may or may not exist.findById returns Optional because the record might not be found in the database.

***Endpoints***

| Method | URL                      | Body       |
|--------|--------------------------|------------|
| POST   | /api/categories          | { "name" } |
| GET    | /api/categories          | -          |
| GET    | /api/categories/{id}     | -          |
| PUT    | /api/categories/{id}     | { "name" } |
| DELETE | /api/categories/{id}     | -          |

***SELF-QUIZ***

***Q1. Why ResponseEntity instead of returning the object?***

ResponseEntity is used because it gives full control over the HTTP response, including status codes, headers, and body. Returning only the object limits control and always defaults to HTTP 200 OK.

***Q2. What status should a successful DELETE return? Why?***

A successful DELETE should return 204 No Content because the resource has been deleted successfully and there is no need to return any data in the response body.

***Q3. Update only one field - PUT or PATCH? Defend your answer.***

PATCH should be used because it allows partial updates of a resource. PUT is meant to replace the entire resource, while PATCH only modifies specific fields.

***Q4. What happens if you forget @Valid on the controller?***

If @Valid is missing, validation annotations like @NotBlank and @Size will not be triggered. This means invalid data can be saved into the database without any errors.

***Q5. Why must update/delete have {id} in the URL but create does not?***

Update and delete require an ID because they operate on an existing resource. Create does not need an ID because the system generates it automatically when a new resource is created.
