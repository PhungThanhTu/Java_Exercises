package models;

import java.sql.Connection;
import java.util.ArrayList;


public interface DAO<T> {
    /**
     * Get all data from a database
     * @return An array list contains all object form database
     */
    ArrayList<T> getAll();

    /**
     * Establish SQL connection using variable in variable file
     * @return the connection
     */
    Connection getConnection();

    /**
     * get object form database using db
     * @param id id to query to the database
     * @return result from the database converted to T
     */
    T get(String id);

    /**
     * Add new row to database using object
     * @param t object to add to the database
     */
    void add(T t);

    /**
     * Update object to database using its information
     * @param t object to update
     */
    void update(T t);

    /**
     * delete object using id
     * @param id the id of the object to delete
     */
    void delete(String id);
}
