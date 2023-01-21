# Web Service

## Parts of a web service
 * Service provider - Server
 * Service consumer - Client

## Web service Definition/Contract
* A web service definition or service contract consists of the following 4 elements	
  - Request/response format
  - Request structure
  - Response structure
  - Endpoint
	
## Types of web services

  ### SOAP 
  Acronym for Simple Object Access Protocol. Uses _**only XML**_ for request and response.

  * SOAP Structure 
    - SOAP envelope 
      - SOAP Header - has meta data info
      - SOAP Body - request/response content

  * Can be used with Web or MQ

  * Follows WSDL (Web Service Definition Language) for creation of the following 4 components
    - Endpoints
    - All operations
    - Request Structure 
    - Response Structure 
  
  ### REST 
  Acronym for Representational State Transfer, Made by **_Roy Fielding_** creator of HTTP.
    
  * The key unit in rest, post abstraction is called **_Resource_**. All the operations are performed on resources.
  * A resource will have a URI (Uniform Resource Identifier) eg /user/Ranga/Todos
  * Essentially use HTTP to perform operation on resource
  * Rest can use any data format for transfer XML, JSON, HTML etc
  * Definition - No standard, has several WADL/Swagger

  
## Spring

Spring works as a dependency management system. Spring helps with Dependency Injection and Inversion of Controller.
Spring container uses beans and config files to deploy an application. 

![alt text](https://static.javatpoint.com/images/sp/spmodules.jpg)


## Important annotations

### Spring starter
@SpringBootApplication

### Bean Configuration
@Autoconfigure

### Controller
@RestController
@GetMapping
@PathVariable
Locale

### Data validity Checks
@Valid
@JSONIgnore



### Error Management
@ControllerAdvice
@ExceptionHandler

### Filtering
MappingJacksonValue
SimpleBeanPropertyFilter - variations?
FilterProvider - Adds filters
@JSONIgnore
@JSONIgnoreProperty("Value1")
@JsonFilter("SomeBeanFilter")

### Entity JPA
JpaRepository
@Entity
@ManyToOne(fetch = FetchType.LAZY)
@Id
@GeneratedValue - not working?
@ManyToOne(fetch = FetchType.LAZY)
@Past
@OneToMany(mappedBy = "") ??


Important config files - Used by container along with beans

### Important library classes
Error Handling
ResponseEntityExceptionHandler
ResponseEntity
HATEOS
ServletUriComponentsBuilder
Data Repository
JpaRepository
JPA vs Spring JPA vs H2 api

### HATEOS - Hypermedia as the engine of application state
    @GetMapping(path = "/jpa/users/{id}")
    public EntityModel<User> findOne(@PathVariable Integer id) {
        Optional<User> user = repository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id"+id);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).retrieveAllUsers());
        EntityModel<User> userEntityModel = EntityModel.of(user.get());
        userEntityModel.add(linkBuilder.withRel("Fetch all Users"));
        return userEntityModel;
    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        User createdUser = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


### Versioning


    @RestController
    public class VersioningPersonController {
    //URI Versioning
    @GetMapping(path = "/v1/person")
    public PersonV1 getPersonNameV1() {
    return new PersonV1("Bob Sagget");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getPersonNameV2() {
        return new PersonV2("Bob", "Sagget");
    }

    //RequestParams versioning
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getParamsPersonNameV1() {
        return new PersonV1("Bob Sagget");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getParamsPersonNameV2() {
        return new PersonV2("Bob", "Sagget");
    }

    //Header versioning
    @GetMapping(path = "/header/person", headers = "X-API-VERSION=1")
    public PersonV1 getHeaderPersonNameV1() {
        return new PersonV1("Bob Sagget");
    }

    @GetMapping(path = "/header/person", headers = "X-API-VERSION=2")
    public PersonV2 getHeaderPersonNameV2() {
        return new PersonV2("Bob", "Sagget");
    }

    //Content negotiation header versioning
    @GetMapping(path = "/negotiate/person", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getNegotiatePersonNameV1() {
        return new PersonV1("Bob Sagget");
    }

    @GetMapping(path = "/negotiate/person", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getNegotiatePersonNameV2() {
        return new PersonV2("Bob", "Sagget");
    }

}

##
