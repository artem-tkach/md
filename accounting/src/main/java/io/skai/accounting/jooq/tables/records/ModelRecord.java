/*
 * This file is generated by jOOQ.
 */
package io.skai.accounting.jooq.tables.records;


import io.skai.accounting.jooq.tables.Model;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ModelRecord extends UpdatableRecordImpl<ModelRecord> implements Record3<Long, Long, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>mobile_accounting.model.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>mobile_accounting.model.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>mobile_accounting.model.brand_id</code>.
     */
    public void setBrandId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>mobile_accounting.model.brand_id</code>.
     */
    public Long getBrandId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>mobile_accounting.model.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>mobile_accounting.model.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Model.MODEL.ID;
    }

    @Override
    public Field<Long> field2() {
        return Model.MODEL.BRAND_ID;
    }

    @Override
    public Field<String> field3() {
        return Model.MODEL.NAME;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getBrandId();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getBrandId();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public ModelRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ModelRecord value2(Long value) {
        setBrandId(value);
        return this;
    }

    @Override
    public ModelRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public ModelRecord values(Long value1, Long value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ModelRecord
     */
    public ModelRecord() {
        super(Model.MODEL);
    }

    /**
     * Create a detached, initialised ModelRecord
     */
    public ModelRecord(Long id, Long brandId, String name) {
        super(Model.MODEL);

        setId(id);
        setBrandId(brandId);
        setName(name);
    }

    /**
     * Create a detached, initialised ModelRecord
     */
    public ModelRecord(io.skai.accounting.jooq.tables.pojos.Model value) {
        super(Model.MODEL);

        if (value != null) {
            setId(value.getId());
            setBrandId(value.getBrandId());
            setName(value.getName());
        }
    }
}
