package dw.com.companyapp.dto;


import dw.com.companyapp.model.OrderDetail;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderRequestDTO {
    private String orderId;
    private String customerId;
    private String employeeId;
    private LocalDate requestDate;
    private LocalDate orderDate;
    private LocalDate shippingDate;
    private Long productId;
    private List<OrderDetail> orderDetails;


}