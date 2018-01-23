package com.tps.device_management.services.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.tps.device_management.entities.EquipmentInfo;
import com.tps.device_management.repositories.EquipmentInfoRepository;
import com.tps.device_management.services.EquipmentInfoService;

/**
 * The Class EquipmentInfoServiceImpl.
 */
@Service
public class EquipmentInfoServiceImpl implements EquipmentInfoService {

  /** The EquipmentInfoServiceImpl logger. */
  private static final Logger logger = LoggerFactory.getLogger(EquipmentInfoServiceImpl.class);

  @Autowired
  private EquipmentInfoRepository equipmentInfoRepository;

  @Override
  public ResponseEntity<?> getAllEquipmentInfo(HttpServletRequest req) {
    logger.info("IN - getAllEquipmentInfo()");
    List<EquipmentInfo> equipmentInfoList =
        (List<EquipmentInfo>) this.equipmentInfoRepository.findAll();
    try {
      if (equipmentInfoList.size() > 0) {
        logger.info("OUT - getAllEquipmentInfo()");
        return new ResponseEntity<>(equipmentInfoList, HttpStatus.OK);
      }
      logger.info("OUT - getAllEquipmentInfo()");
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      logger.error("Exception: {}", e.getMessage());
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
