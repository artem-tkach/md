/*
 * This file is generated by jOOQ.
 */
package io.skai.accounting.jooq.tables;


import io.skai.accounting.jooq.Keys;
import io.skai.accounting.jooq.MobileAccounting;
import io.skai.accounting.jooq.tables.records.OrderStatusRecord;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrderStatus extends TableImpl<OrderStatusRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>mobile_accounting.order_status</code>
     */
    public static final OrderStatus ORDER_STATUS = new OrderStatus();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrderStatusRecord> getRecordType() {
        return OrderStatusRecord.class;
    }

    /**
     * The column <code>mobile_accounting.order_status.id</code>.
     */
    public final TableField<OrderStatusRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>mobile_accounting.order_status.order_id</code>.
     */
    public final TableField<OrderStatusRecord, Long> ORDER_ID = createField(DSL.name("order_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>mobile_accounting.order_status.status</code>.
     */
    public final TableField<OrderStatusRecord, String> STATUS = createField(DSL.name("status"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>mobile_accounting.order_status.date</code>.
     */
    public final TableField<OrderStatusRecord, LocalDateTime> DATE = createField(DSL.name("date"), SQLDataType.LOCALDATETIME(0), this, "");

    private OrderStatus(Name alias, Table<OrderStatusRecord> aliased) {
        this(alias, aliased, null);
    }

    private OrderStatus(Name alias, Table<OrderStatusRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>mobile_accounting.order_status</code> table
     * reference
     */
    public OrderStatus(String alias) {
        this(DSL.name(alias), ORDER_STATUS);
    }

    /**
     * Create an aliased <code>mobile_accounting.order_status</code> table
     * reference
     */
    public OrderStatus(Name alias) {
        this(alias, ORDER_STATUS);
    }

    /**
     * Create a <code>mobile_accounting.order_status</code> table reference
     */
    public OrderStatus() {
        this(DSL.name("order_status"), null);
    }

    public <O extends Record> OrderStatus(Table<O> child, ForeignKey<O, OrderStatusRecord> key) {
        super(child, key, ORDER_STATUS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : MobileAccounting.MOBILE_ACCOUNTING;
    }

    @Override
    public Identity<OrderStatusRecord, Long> getIdentity() {
        return (Identity<OrderStatusRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<OrderStatusRecord> getPrimaryKey() {
        return Keys.KEY_ORDER_STATUS_PRIMARY;
    }

    @Override
    public OrderStatus as(String alias) {
        return new OrderStatus(DSL.name(alias), this);
    }

    @Override
    public OrderStatus as(Name alias) {
        return new OrderStatus(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderStatus rename(String name) {
        return new OrderStatus(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderStatus rename(Name name) {
        return new OrderStatus(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, String, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
