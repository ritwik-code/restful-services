package com.practice.restwebservices.restfulservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//NOTE

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
