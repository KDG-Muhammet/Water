package be.kdg.sa.repository;

import be.kdg.sa.domain.ShippingOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ShippingOrderRepository extends JpaRepository<ShippingOrder, UUID>  {

    ShippingOrder findShippingOrderByPoNumber(String poNumber);
}
