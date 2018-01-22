/**
 * File Name  : CourseMapping.java
 * Package    : com.tps.device_management.mapper
 * Author     : nghiant
 * Created    : Jan 8, 2018

 * This source code is part of the  device-management, and is copyrighted by TPS.
 * All rights reserved.  No part of this work may be reproduced, stored in a retrieval system,
 * adopted or transmitted in any form or by any means,electronic, mechanical, photographic,
 * graphic, optic recording or otherwise,translated in any language or computer language,
 * without the prior written permission of TPS

Copyright © 2018 by TPS
 */
package com.tps.device_management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tps.device_management.dto.CourseDTO;
import com.tps.device_management.entities.Course;

/**
 * @author nghiant
 * This class using for ...
 */
@Mapper
public interface CourseMapping {
	public static CourseMapping INSTANCE = Mappers.getMapper(CourseMapping.class);

	public abstract Course CoursDTOToEntity (CourseDTO courseDTO);
}
