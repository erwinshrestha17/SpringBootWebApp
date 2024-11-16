package erwin.springbootwebapp.Controller.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("/v1/person")
    public Personv1 getFirstVersionPerson(){
        return new Personv1("Erwin");

    }
    @GetMapping("/v2/person")
    public Personv2 getSecondVersionPerson(){
        return  new Personv2("Erwin" ,"Shrestha");
    }
    @GetMapping(path = "/person",params = "version=1")
    public Personv1 getVersion1(){
        return new Personv1("Erwin");
    }

    @GetMapping(path = "/person",params = "version=2")
    public Personv2 getVersion2(){
        return  new Personv2("Erwin" ,"Shrestha");

    }
    @GetMapping(path = "/person/header",headers = "X-API-VERSION=1")
    public Personv2 getVersionHeader(){
        return  new Personv2("Erwin" ,"Shrestha");

    }
}
