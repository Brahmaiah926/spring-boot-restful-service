package com.ganna.learn.spring_boot_restful_service.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public Person GetFirstVersionOfPerson() {
        return new Person("Ganna Chinna");
    }

    @GetMapping("/v2/person")
    public PersonV2 GetSecondVersionOfPerson() {
        return new PersonV2(new Name("Chinna", "Ganna"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public Person GetFirstVersionOfPersonRequestParam() {
        return new Person("Ganna Chinna");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 GetSecondVersionOfPersonRequestParam() {
        return new PersonV2(new Name("Chinna", "Ganna"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public Person GetFirstVersionOfPersonRequestHeader() {
        return new Person("Ganna Chinna");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 GetSecondVersionOfPersonRequestHeader() {
        return new PersonV2(new Name("Chinna", "Ganna"));
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public Person GetFirstVersionOfPersonAcceptHeader() {
        return new Person("Ganna Chinna");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 GetSecondVersionOfPersonAcceptHeader()
    {
        return new PersonV2(new Name("Chinna", "Ganna"));
    }

}
