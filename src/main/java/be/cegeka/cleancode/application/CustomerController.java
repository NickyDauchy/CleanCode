package be.cegeka.cleancode.application;

import be.cegeka.cleancode.domain.customers.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

import javax.inject.Inject;

@RestController
@RequestMapping(path = "/customer")
@Transactional
public class CustomerController {
    @Inject
    private CustomerService customerService;

    @PostMapping
    public void addCustomer(@RequestParam(value = "name", required = true) String name) {
        customerService.addCustomer(name);
    }

}
