package com.tps.device_management.controllers;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tps.device_management.services.EquipmentInfoService;

/**
 * Handles requests for equipment info.
 */
@RestController
public class EquipmentInfoController {
  final Logger logger = LoggerFactory.getLogger(EquipmentInfoController.class);

  @Autowired
  private EquipmentInfoService equipmentInfoService;

  @RequestMapping(value = "equipment", method = RequestMethod.GET)
  public ResponseEntity<?> getAllEquipmentInfo(HttpServletRequest req) {
      logger.info("IN - getAllEquipmentInfo()");

      logger.info("OUT - getAllEquipmentInfo()");
      return equipmentInfoService.getAllEquipmentInfo(req);
  }
}
