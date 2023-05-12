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
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long          id;
    private LocalDateTime date;
    private Long          orderId;
    private Long          masterId;
    private String        result;
    private Double        sum;
    private String        comment;
    private String        guid;

    public Repair() {}

    public Repair(Repair value) {
        this.id = value.id;
        this.date = value.date;
        this.orderId = value.orderId;
        this.masterId = value.masterId;
        this.result = value.result;
        this.sum = value.sum;
        this.comment = value.comment;
        this.guid = value.guid;
    }

    public Repair(
        Long          id,
        LocalDateTime date,
        Long          orderId,
        Long          masterId,
        String        result,
        Double        sum,
        String        comment,
        String        guid
    ) {
        this.id = id;
        this.date = date;
        this.orderId = orderId;
        this.masterId = masterId;
        this.result = result;
        this.sum = sum;
        this.comment = comment;
        this.guid = guid;
    }

    /**
     * Getter for <code>mobile_accounting.repair.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>mobile_accounting.repair.id</code>.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>mobile_accounting.repair.date</code>.
     */
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * Setter for <code>mobile_accounting.repair.date</code>.
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Getter for <code>mobile_accounting.repair.order_id</code>.
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * Setter for <code>mobile_accounting.repair.order_id</code>.
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * Getter for <code>mobile_accounting.repair.master_id</code>.
     */
    public Long getMasterId() {
        return this.masterId;
    }

    /**
     * Setter for <code>mobile_accounting.repair.master_id</code>.
     */
    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    /**
     * Getter for <code>mobile_accounting.repair.result</code>.
     */
    public String getResult() {
        return this.result;
    }

    /**
     * Setter for <code>mobile_accounting.repair.result</code>.
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Getter for <code>mobile_accounting.repair.sum</code>.
     */
    public Double getSum() {
        return this.sum;
    }

    /**
     * Setter for <code>mobile_accounting.repair.sum</code>.
     */
    public void setSum(Double sum) {
        this.sum = sum;
    }

    /**
     * Getter for <code>mobile_accounting.repair.comment</code>.
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * Setter for <code>mobile_accounting.repair.comment</code>.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Getter for <code>mobile_accounting.repair.guid</code>.
     */
    public String getGuid() {
        return this.guid;
    }

    /**
     * Setter for <code>mobile_accounting.repair.guid</code>.
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Repair (");

        sb.append(id);
        sb.append(", ").append(date);
        sb.append(", ").append(orderId);
        sb.append(", ").append(masterId);
        sb.append(", ").append(result);
        sb.append(", ").append(sum);
        sb.append(", ").append(comment);
        sb.append(", ").append(guid);

        sb.append(")");
        return sb.toString();
    }
}
