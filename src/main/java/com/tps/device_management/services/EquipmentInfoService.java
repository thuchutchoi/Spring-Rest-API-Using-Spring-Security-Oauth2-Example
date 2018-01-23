package com.tps.device_management.services;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
public interface EquipmentInfoService {

	/**
     * Get user all equipment info
     *
     * @param req HttpServletRequest
     * @return the response entity <br>
     *         200: OK.<br>
     *         400: Bad Request.<br>
     *         404: Not found.<br>
     */
	public ResponseEntity<?> getAllEquipmentInfo(HttpServletRequest req);
}
