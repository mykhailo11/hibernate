package com.aimprosoft.departments.dao.impl;

import com.aimprosoft.departments.dao.Dao;
import com.aimprosoft.departments.dao.utils.HibernateUtil;
import com.aimprosoft.departments.entities.impl.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

public class DepartmentsDao implements Dao<Department> {
    @Override
    public Collection<Department> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
            Root<Department> departmentRoot = criteriaQuery.from(Department.class);
            criteriaQuery.select(departmentRoot);
            Query query = session.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Department getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
            Root<Department> departmentRoot = criteriaQuery.from(Department.class);
            criteriaQuery.select(departmentRoot).where(criteriaBuilder.equal(departmentRoot.get("departmentId"), id));
            Query query = session.createQuery(criteriaQuery);
            return (Department) query.getResultList().stream().findFirst().orElse(null);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public int edit(Department entity) {
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
    public int editAll(Department... entities) {
        int updated = 0;
        for (Department entity : entities) {
            updated += edit(entity);
        }
        return updated;
    }

    @Override
    public int remove(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Department department = getById(id);
            session.delete(department);
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
