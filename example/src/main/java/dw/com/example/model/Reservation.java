package dw.com.example.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="예약")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="reservation_date")
    private String reservationDate;

    @Column(name="visit_date")
    private String visitDate;

    @ManyToOne
    @JoinColumn(name = "user_name")
    private User user;

    @ManyToOne
    @JoinColumn(name = "exhibition_id")
    private Exhibition exhibition;
}