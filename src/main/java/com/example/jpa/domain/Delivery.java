package com.example.jpa.domain;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;
    @OneToOne(mappedBy = "delivery")
    private Order order;
    @Embedded
    private Address address;

    /**
     * String 과 Ordinal 의 차이
     * Defualt = Ordinal 이것은 숫자로 들어감
     * (중간에 어떤 상태가 추가 될 시 오류가 날 가능성 높음)
     */
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //READY, COMPLETE
}
