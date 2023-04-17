/*
 * This file is generated by jOOQ.
 */
package io.skai.accounting.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrderStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long orderId;
    private String status;
    private LocalDateTime date;

    public OrderStatus() {}

    public OrderStatus(OrderStatus value) {
        this.id = value.id;
        this.orderId = value.orderId;
        this.status = value.status;
        this.date = value.date;
    }

    public OrderStatus(
        Long id,
        Long orderId,
        String status,
        LocalDateTime date
    ) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.date = date;
    }

    /**
     * Getter for <code>mobile_accounting.order_status.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>mobile_accounting.order_status.id</code>.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>mobile_accounting.order_status.order_id</code>.
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * Setter for <code>mobile_accounting.order_status.order_id</code>.
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * Getter for <code>mobile_accounting.order_status.status</code>.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>mobile_accounting.order_status.status</code>.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for <code>mobile_accounting.order_status.date</code>.
     */
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * Setter for <code>mobile_accounting.order_status.date</code>.
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final OrderStatus other = (OrderStatus) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.orderId == null) {
            if (other.orderId != null)
                return false;
        }
        else if (!this.orderId.equals(other.orderId))
            return false;
        if (this.status == null) {
            if (other.status != null)
                return false;
        }
        else if (!this.status.equals(other.status))
            return false;
        if (this.date == null) {
            if (other.date != null)
                return false;
        }
        else if (!this.date.equals(other.date))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.orderId == null) ? 0 : this.orderId.hashCode());
        result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
        result = prime * result + ((this.date == null) ? 0 : this.date.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("OrderStatus (");

        sb.append(id);
        sb.append(", ").append(orderId);
        sb.append(", ").append(status);
        sb.append(", ").append(date);

        sb.append(")");
        return sb.toString();
    }
}
