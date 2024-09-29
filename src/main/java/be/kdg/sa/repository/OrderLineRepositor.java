package be.kdg.sa.repository;

import be.kdg.sa.domain.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepositor extends JpaRepository<OrderLine, Integer>  {
}
