package com.aimprosoft.departments.dao.impl;

import com.aimprosoft.departments.dao.Dao;
import com.aimprosoft.departments.dao.utils.HibernateUtil;
import com.aimprosoft.departments.entities.impl.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

public class EmployeesDao implements Dao<Employee> {

    @Override
    public Collection<Employee> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
            criteriaQuery.select(employeeRoot);
            Query query = session.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
            criteriaQuery.select(employeeRoot).where(criteriaBuilder.equal(employeeRoot.get("id"), id));
            Query query = session.createQuery(criteriaQuery);
            return (Employee) query.getResultList().stream().findFirst().orElse(null);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public int edit(Employee entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            if (entity.getId() == null){
                Integer id = (Integer) session.save(entity);
                entity.setId(id);
            }else{
                session.update(entity);
            }
            transaction.commit();
            return 1;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    @Override
    public int editAll(Employee... entities) {
        int updated = 0;
        for (Employee entity : entities) {
            updated += edit(entity);
        }
        return updated;
    }

    @Override
    public int remove(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = getById(id);
            session.delete(employee);
            transaction.commit();
            return 1;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    @Override
    public int removeAll(int... ids) {
        int removed = 0;
        for (int id : ids) {
            removed += remove(id);
        }
        return removed;
    }
}
