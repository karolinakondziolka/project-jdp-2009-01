package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ORDER_ID")
    private Long orderId;

    @JoinColumn(name = "USER_ASSIGNEDTO_ORDER")
    @ManyToOne
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ORDER_PRODUCT",
            joinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}

    )
    private List<Product> products;

    public Order(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }
}
