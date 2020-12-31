package com.example.erp.dao.implementation;

import com.example.erp.bean.Students;
import com.example.erp.dao.StudentDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Students> getStudents(int id) {
        try (Session session = SessionUtil.getSession()) {
            Query q = session.createQuery("SELECT s FROM Students s JOIN s.courses c WHERE c.course_id = :id");
            q.setParameter("id", id);
            List<Students> students = q.list();

            return students;
        }catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        catch(Exception ex) {ex.printStackTrace();}
        return null;
    }
}
