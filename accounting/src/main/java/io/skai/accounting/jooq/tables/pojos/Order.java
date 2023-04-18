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
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long clientId;
    private Long modelId;
    private String serialNumber;
    private String defect;
    private Long managerId;
    private LocalDateTime date;
    private String guid;

    public Order() {}

    public Order(Order value) {
        this.id = value.id;
        this.clientId = value.clientId;
        this.modelId = value.modelId;
        this.serialNumber = value.serialNumber;
        this.defect = value.defect;
        this.managerId = value.managerId;
        this.date = value.date;
        this.guid = value.guid;
    }

    public Order(
        Long id,
        Long clientId,
        Long modelId,
        String serialNumber,
        String defect,
        Long managerId,
        LocalDateTime date,
        String guid
    ) {
        this.id = id;
        this.clientId = clientId;
        this.modelId = modelId;
        this.serialNumber = serialNumber;
        this.defect = defect;
        this.managerId = managerId;
        this.date = date;
        this.guid = guid;
    }

    /**
     * Getter for <code>mobile_accounting.order.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>mobile_accounting.order.id</code>.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>mobile_accounting.order.client_id</code>.
     */
    public Long getClientId() {
        return this.clientId;
    }

    /**
     * Setter for <code>mobile_accounting.order.client_id</code>.
     */
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    /**
     * Getter for <code>mobile_accounting.order.model_id</code>.
     */
    public Long getModelId() {
        return this.modelId;
    }

    /**
     * Setter for <code>mobile_accounting.order.model_id</code>.
     */
    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    /**
     * Getter for <code>mobile_accounting.order.serial_number</code>.
     */
    public String getSerialNumber() {
        return this.serialNumber;
    }

    /**
     * Setter for <code>mobile_accounting.order.serial_number</code>.
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Getter for <code>mobile_accounting.order.defect</code>.
     */
    public String getDefect() {
        return this.defect;
    }

    /**
     * Setter for <code>mobile_accounting.order.defect</code>.
     */
    public void setDefect(String defect) {
        this.defect = defect;
    }

    /**
     * Getter for <code>mobile_accounting.order.manager_id</code>.
     */
    public Long getManagerId() {
        return this.managerId;
    }

    /**
     * Setter for <code>mobile_accounting.order.manager_id</code>.
     */
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    /**
     * Getter for <code>mobile_accounting.order.date</code>.
     */
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * Setter for <code>mobile_accounting.order.date</code>.
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Getter for <code>mobile_accounting.order.guid</code>.
     */
    public String getGuid() {
        return this.guid;
    }

    /**
     * Setter for <code>mobile_accounting.order.guid</code>.
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Order other = (Order) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.clientId == null) {
            if (other.clientId != null)
                return false;
        }
        else if (!this.clientId.equals(other.clientId))
            return false;
        if (this.modelId == null) {
            if (other.modelId != null)
                return false;
        }
        else if (!this.modelId.equals(other.modelId))
            return false;
        if (this.serialNumber == null) {
            if (other.serialNumber != null)
                return false;
        }
        else if (!this.serialNumber.equals(other.serialNumber))
            return false;
        if (this.defect == null) {
            if (other.defect != null)
                return false;
        }
        else if (!this.defect.equals(other.defect))
            return false;
        if (this.managerId == null) {
            if (other.managerId != null)
                return false;
        }
        else if (!this.managerId.equals(other.managerId))
            return false;
        if (this.date == null) {
            if (other.date != null)
                return false;
        }
        else if (!this.date.equals(other.date))
            return false;
        if (this.guid == null) {
            if (other.guid != null)
                return false;
        }
        else if (!this.guid.equals(other.guid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.clientId == null) ? 0 : this.clientId.hashCode());
        result = prime * result + ((this.modelId == null) ? 0 : this.modelId.hashCode());
        result = prime * result + ((this.serialNumber == null) ? 0 : this.serialNumber.hashCode());
        result = prime * result + ((this.defect == null) ? 0 : this.defect.hashCode());
        result = prime * result + ((this.managerId == null) ? 0 : this.managerId.hashCode());
        result = prime * result + ((this.date == null) ? 0 : this.date.hashCode());
        result = prime * result + ((this.guid == null) ? 0 : this.guid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order (");

        sb.append(id);
        sb.append(", ").append(clientId);
        sb.append(", ").append(modelId);
        sb.append(", ").append(serialNumber);
        sb.append(", ").append(defect);
        sb.append(", ").append(managerId);
        sb.append(", ").append(date);
        sb.append(", ").append(guid);

        sb.append(")");
        return sb.toString();
    }
}
