package choreography.with.idempotency.domain;

import choreography.with.idempotency.domain.*;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="deliveries", path="deliveries")
public interface DeliveryRepository extends PagingAndSortingRepository<Delivery, String>{
    Optional<Delivery> findByOrderId(String Id);
}
