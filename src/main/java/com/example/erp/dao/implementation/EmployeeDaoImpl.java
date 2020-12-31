package com.example.erp.dao.implementation;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Employee;
import com.example.erp.bean.Students;
import com.example.erp.bean.TimeTable;
import com.example.erp.dao.EmployeeDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Employee emailVerify(Employee employee) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Employee where email=:email and password=:password"); //:email is placeholder
            query.setParameter("email", employee.getEmail());
            query.setParameter("password",employee.getPassword());
//            Employee emp = (Employee) query.uniqueResult();
//            System.out.println(emp.getEmp_id());
            for (final Object fetch : query.list()) {
                return (Employee) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }
//    @Override
//    public Employee getEmpId(Employee employee) {
//        try (Session session = SessionUtil.getSession()) {
//            Query query = session.createQuery("from Courses where Courses.emp_id in (select Employee.emp_id from Employee where Employee.email=:email)");
//            query.setParameter("email", employee.getEmp_id());
////            for (final Object fetch : query.list()) {
////                return (Employee) fetch;
////            }
//            Employee emp = (Employee) query.list();
//            emp.getEmp_id();
//        } catch (HibernateException exception) {
//            System.out.print(exception.getLocalizedMessage());
//            return null;
//        }
//        return null;
//    }

    @Override
    public List<Courses> getCourses(Integer id) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Courses where emp_id.emp_id=:id");
            query.setParameter("id", id);
            List<Courses> courses = query.list();
            return courses;
        }catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        catch(Exception ex) {ex.printStackTrace();}
        return null;
    }

    @Override
    public List<TimeTable> getTimeTable(int id) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from TimeTable where emp_id.emp_id=:id");
            query.setParameter("id", id);
            List<TimeTable> timeTable = query.list();

//            //int id1 = 1;
//            Query q = session.createQuery("SELECT p FROM Students p JOIN p.courses c WHERE c.course_id = :id1");
//            q.setParameter("id1", 1);
//            List<Students> st = q.list();


            return timeTable;
        }catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        catch(Exception ex) {ex.printStackTrace();}
        return null;
    }


}
