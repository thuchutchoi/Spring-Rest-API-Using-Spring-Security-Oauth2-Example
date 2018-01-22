/**
 * File Name  : CourseDTO.java
 * Package    : com.tps.device_management.dto
 * Author     : nghiant
 * Created    : Jan 8, 2018

 * This source code is part of the  device-management, and is copyrighted by TPS.
 * All rights reserved.  No part of this work may be reproduced, stored in a retrieval system,
 * adopted or transmitted in any form or by any means,electronic, mechanical, photographic,
 * graphic, optic recording or otherwise,translated in any language or computer language,
 * without the prior written permission of TPS

Copyright © 2018 by TPS
 */
package com.tps.device_management.dto;

import java.util.Set;

import com.tps.device_management.entities.Student;

/**
 * @author nghiant
 * This class using for ...
 */
public class CourseDTO {
	private int id;
	private String name;
	private Set<Student> students;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
