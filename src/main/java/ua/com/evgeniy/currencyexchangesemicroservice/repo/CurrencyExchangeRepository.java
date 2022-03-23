package ua.com.evgeniy.currencyexchangesemicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.evgeniy.currencyexchangesemicroservice.beans.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByFromAndTo (String from, String to);

}
