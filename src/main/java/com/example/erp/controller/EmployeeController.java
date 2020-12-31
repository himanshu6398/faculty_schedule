package com.example.erp.controller;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Employee;
import com.example.erp.bean.TimeTable;
import com.example.erp.service.EmployeeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Path("faculty")
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * returns employee object
     */
    public Response loginEmployee(Employee employee) throws URISyntaxException {
        Employee result = employeeService.verifyEmail(employee);
        int id = result.getEmp_id();
        if(result == null){
            return Response.noContent().build();
        }
//        Employee res = employeeService.getEmployeeId(employee);
//        if(res == null) {
//        }
//        getEmpCourses(result.getEmp_id());

        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/getCourses/{id}/")

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response getEmpCourses(@PathParam("id") int id) {
        //System.out.println(id);
        try {
            List<Courses> courses = employeeService.getCourses(id);
            System.out.println(courses.size());
            for(Courses o : courses) {
                System.out.println(o.getCourse_code() + " :"+ o.getName()+" :"+o.getCredits());
            }

            return Response.ok().entity(courses).build();
        }catch(Exception ex) { ex.printStackTrace();}
        return null;
    }

    @GET
    @Path("/getTimeTable/{id}/")
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimeTable(@PathParam("id") int id) {
        //System.out.println(id);
        try {
            List<TimeTable> timeTables = employeeService.getCourseTimeTable(id);
            System.out.println(timeTables.size());
//            for(Courses o : courses) {
//                System.out.println(o.getCourse_code() + " :"+ o.getName()+" :"+o.getCredits());
//            }

            return Response.ok().entity(timeTables).build();
        }catch(Exception ex) { ex.printStackTrace();}
        return null;
    }
}
