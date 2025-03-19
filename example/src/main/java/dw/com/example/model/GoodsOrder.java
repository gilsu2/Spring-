package dw.com.example.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="굿즈_주문")
public class GoodsOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="quantity")
    private int quantity;

    @Column(name="order_date")
    private String orderDate;

    @ManyToOne
    @JoinColumn(name = "user_name")
    private User user;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;
}