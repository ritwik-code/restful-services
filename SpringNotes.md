

# Spring microservices with cloud

## Parts of a web service
 * Service provider - Server
 * Service consumer - Client

## Web service Definition/Contract
	- Request/response format
	- Request structure
	- Response structure
	- Endpoint
	
Transport - HTTP/MQ


## Types of web services
* SOAP 
  * Simple Object Access Protocol
  * Uses XML for request and response
		
  SOAP Structure 
  - SOAP envelope - [SOAP Header - has meta data info; SOAP body - request/response content]
  - Can be used with web and MQ

  Folows WSDL (Web Service Definition Language)
  - Endpoints
  - All operations
  - Request Structure 
  - Response Structure 
		
* REST 
  * Representational State Transfer 
  * Made by Roy Fielding - creator of HTTP
  * Key abstration : Resource
    * Resource will have a URI (Uniform Resource Identifier)
      * eg- /user/Ranga/Todos
    * Can use anything XML, JSON, HTML etc
    * Essentially use HTTP to perform operation on resource
    * Definition - No standard, has several WADL/Swagger

?? Write difference




Spring
