package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // supports component scanning and translates JDBC exceptions
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;
    //instance of EntityManager, which is used to interact with the persistence context (the database).

    @Autowired
    // inject entity manager using controller injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional // updating the database
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findByID(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);

        // return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findbyLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastName=:theData", Student.class);

        // set query params
        theQuery.setParameter("theData", theLastName);
        //return query results
        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student
        Student myStudent = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(myStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
       int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
       return numRowsDeleted;
    }
}
