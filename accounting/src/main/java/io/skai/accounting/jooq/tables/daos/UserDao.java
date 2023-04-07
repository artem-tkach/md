/*
 * This file is generated by jOOQ.
 */
package io.skai.accounting.jooq.tables.daos;


import io.skai.accounting.jooq.tables.User;
import io.skai.accounting.jooq.tables.records.UserRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import java.util.List;
import java.util.Optional;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserDao extends DAOImpl<UserRecord, io.skai.accounting.jooq.tables.pojos.User, Long> {

    /**
     * Create a new UserDao without any configuration
     */
    public UserDao() {
        super(User.USER, io.skai.accounting.jooq.tables.pojos.User.class);
    }

    /**
     * Create a new UserDao with an attached configuration
     */
    public UserDao(Configuration configuration) {
        super(User.USER, io.skai.accounting.jooq.tables.pojos.User.class, configuration);
    }

    @Override
    public Long getId(io.skai.accounting.jooq.tables.pojos.User object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.skai.accounting.jooq.tables.pojos.User> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(User.USER.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<io.skai.accounting.jooq.tables.pojos.User> fetchById(Long... values) {
        return fetch(User.USER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public io.skai.accounting.jooq.tables.pojos.User fetchOneById(Long value) {
        return fetchOne(User.USER.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<io.skai.accounting.jooq.tables.pojos.User> fetchOptionalById(Long value) {
        return fetchOptional(User.USER.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.skai.accounting.jooq.tables.pojos.User> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<io.skai.accounting.jooq.tables.pojos.User> fetchByName(String... values) {
        return fetch(User.USER.NAME, values);
    }

    /**
     * Fetch records that have <code>email BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.skai.accounting.jooq.tables.pojos.User> fetchRangeOfEmail(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.EMAIL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>email IN (values)</code>
     */
    public List<io.skai.accounting.jooq.tables.pojos.User> fetchByEmail(String... values) {
        return fetch(User.USER.EMAIL, values);
    }

    /**
     * Fetch a unique record that has <code>email = value</code>
     */
    public io.skai.accounting.jooq.tables.pojos.User fetchOneByEmail(String value) {
        return fetchOne(User.USER.EMAIL, value);
    }

    /**
     * Fetch a unique record that has <code>email = value</code>
     */
    public Optional<io.skai.accounting.jooq.tables.pojos.User> fetchOptionalByEmail(String value) {
        return fetchOptional(User.USER.EMAIL, value);
    }

    /**
     * Fetch records that have <code>phone BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.skai.accounting.jooq.tables.pojos.User> fetchRangeOfPhone(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.PHONE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>phone IN (values)</code>
     */
    public List<io.skai.accounting.jooq.tables.pojos.User> fetchByPhone(String... values) {
        return fetch(User.USER.PHONE, values);
    }

    /**
     * Fetch records that have <code>password BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.skai.accounting.jooq.tables.pojos.User> fetchRangeOfPassword(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.PASSWORD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<io.skai.accounting.jooq.tables.pojos.User> fetchByPassword(String... values) {
        return fetch(User.USER.PASSWORD, values);
    }
}
