package choreography.with.idempotency.domain;

import choreography.with.idempotency.domain.*;
import choreography.with.idempotency.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderCreated extends AbstractEvent {

    private Long id;
    private String customerId;
    private String customerName;
    private String productId;
    private String productName;
    private Integer qty;
    private String address;
    private String status;
}


