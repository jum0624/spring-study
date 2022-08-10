package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)  // All이기 때문에 생성할 때 모두 생성, DELETE시에도 모두 지워줌
    private List<OrderItem> orderItems = new ArrayList<>();

//    persist(orderItemA)
//    persist(orderItemB)
//    persist(orderItemC)
//    cascade 적용 후
//    persist(order)만 해도 모두 불러올 수 있음. 즉, 위에 과정이 필요 없음.

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)  // 기존에 각자 persist 될 것들을 다 같이 persist 해줌
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;  // 주문상태(order, cancel)

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
//    public static void main(String[] args) {
//        Member member = new Member();
//        Order order = new Order();
//
//        member.getOrders().add(order);
//        order.setMember(member);
//    }
}
