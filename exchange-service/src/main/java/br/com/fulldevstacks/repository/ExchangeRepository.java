package br.com.fulldevstacks.repository;

import br.com.fulldevstacks.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExchangeRepository extends JpaRepository<Exchange, Long>
{
	Exchange findByFromAndTo(String from, String to);
}
