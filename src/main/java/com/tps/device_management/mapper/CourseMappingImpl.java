package com.tps.device_management.mapper;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.tps.device_management.dto.CourseDTO;
import com.tps.device_management.entities.Course;
import com.tps.device_management.entities.Student;

@Generated(

		value = "org.mapstruct.ap.MappingProcessor",

		date = "2018-01-09T00:40:47+0700",

		comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_91 (Oracle Corporation)"

		)
@Component
public class CourseMappingImpl implements CourseMapping {

	@Override

	public Course CoursDTOToEntity(CourseDTO courseDTO) {

		if ( courseDTO == null ) {

			return null;
		}

		Course course = new Course();

		course.setId( courseDTO.getId() );

		course.setName( courseDTO.getName() );

		Set<Student> set = courseDTO.getStudents();

		if ( set != null ) {

			course.setStudents(       new HashSet<>( set )

					);
		}

		return course;
	}
}

