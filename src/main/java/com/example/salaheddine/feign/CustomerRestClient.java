package com.example.salaheddine.feign;


import enset.glsid.billingservice.models.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "CLIENT-SERVICE")
public interface CustomerRestClient {

    @GetMapping(path = "/clients/{id}")
    Client getClientById(@PathVariable(name = "id") Long id);
}
