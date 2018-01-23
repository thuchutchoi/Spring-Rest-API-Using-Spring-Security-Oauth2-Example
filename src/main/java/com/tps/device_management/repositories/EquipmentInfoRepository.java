package com.tps.device_management.repositories;

import org.springframework.data.repository.CrudRepository;
import com.tps.device_management.entities.EquipmentInfo;

public interface EquipmentInfoRepository extends CrudRepository<EquipmentInfo, Integer> {
}
