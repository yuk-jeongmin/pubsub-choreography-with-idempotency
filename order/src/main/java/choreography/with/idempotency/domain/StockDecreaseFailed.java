package choreography.with.idempotency.domain;

import choreography.with.idempotency.domain.*;
import choreography.with.idempotency.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class StockDecreaseFailed extends AbstractEvent {

    private Long id;
    private String productName;
    private String productImage;
    private Integer stock;
    private String orderId;  
}


