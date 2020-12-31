package com.example.erp.controller;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Students;
import com.example.erp.service.StudentService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("student")
public class StudentsController {
    StudentService studentService = new StudentService();

    @GET
    @Path("/getStudents/{id}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents(@PathParam("id") int id) {
        System.out.println(id);
        try {
            List<Students> students = studentService.getStudents(id);
            System.out.println(students.size());
            for (Students o : students) {
                System.out.println(o.getRollno() + " :" + o.getFirst_name() + " :" + o.getEmail());
            }

            return Response.ok().entity(students).build();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}


