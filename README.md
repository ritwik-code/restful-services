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
  ###SOAP 
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
  
  ###REST 
  Acronym for Representational State Transfer, Made by **_Roy Fielding_** creator of HTTP.
    
  * The key unit in rest, post abstraction is called **_Resource_**. All the operations are performed on resources.
  * A resource will have a URI (Uniform Resource Identifier) eg /user/Ranga/Todos
  * Essentially use HTTP to perform operation on resource
  * Rest can use any data format for transfer XML, JSON, HTML etc
  * Definition - No standard, has several WADL/Swagger

##Spring
Important annotations
@SpringBootApplication
@Autoconfigure
@RestController
@GetMapping
@PathVariable

What's happening in the background? Spring Boot Starters and Autoconfiguration

ResponseEntity
ServletUriComponentsBuilder
