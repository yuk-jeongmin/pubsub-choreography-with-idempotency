package choreography.with.idempotency.domain;

import choreography.with.idempotency.domain.OrderCreated;
import choreography.with.idempotency.domain.OrderApproved;
import choreography.with.idempotency.domain.OrderRejected;
import choreography.with.idempotency.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String customerName;
    
    
    
    
    
    private String productId;
    
    
    
    
    
    private String productName;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String address;

    @PostPersist
    public void onPostPersist(){


        OrderCreated orderCreated = new OrderCreated(this);
        orderCreated.publishAfterCommit();



        OrderApproved orderApproved = new OrderApproved(this);
        orderApproved.publishAfterCommit();

    }
    @PostRemove
    public void onPostRemove(){


        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void approve(StockDecreased stockDecreased){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderApproved orderApproved = new OrderApproved(order);
        orderApproved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(stockDecreased.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderApproved orderApproved = new OrderApproved(order);
            orderApproved.publishAfterCommit();

         });
        */

        
    }
    public static void reject(DeliveryFailed deliveryFailed){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderRejected orderRejected = new OrderRejected(order);
        orderRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryFailed.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderRejected orderRejected = new OrderRejected(order);
            orderRejected.publishAfterCommit();

         });
        */

        
    }
    public static void reject(StockDecreaseFailed stockDecreaseFailed){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderRejected orderRejected = new OrderRejected(order);
        orderRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(stockDecreaseFailed.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderRejected orderRejected = new OrderRejected(order);
            orderRejected.publishAfterCommit();

         });
        */

        
    }


}
