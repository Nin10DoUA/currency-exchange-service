package ua.com.evgeniy.currencyexchangesemicroservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.com.evgeniy.currencyexchangesemicroservice.beans.CurrencyExchange;
import ua.com.evgeniy.currencyexchangesemicroservice.repo.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        //CurrencyExchange currencyExchange = new CurrencyExchange(1000L, "USD", "UAH", BigDecimal.valueOf(29));
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}