package com.garage.inventorystockmanagementservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.garage.inventorystockmanagementservice.dto.PartRequest;
import com.garage.inventorystockmanagementservice.dto.PartResponse;
import com.garage.inventorystockmanagementservice.dto.PartStockUpdateRequest;
import com.garage.inventorystockmanagementservice.dto.PartStockUpdateResponse;
import com.garage.inventorystockmanagementservice.entity.Part;
import com.garage.inventorystockmanagementservice.exception.MandatoryRequestFieldMissingException;
import com.garage.inventorystockmanagementservice.exception.PartFoundException;
import com.garage.inventorystockmanagementservice.exception.PartNotFoundException;
import com.garage.inventorystockmanagementservice.repository.PartRepository;
import com.garage.inventorystockmanagementservice.service.interfaces.PartStockManagementService;

@Service
public class PartStockManagementServiceImpl implements PartStockManagementService {

	@Autowired
	private PartRepository partRepository;

	/**
	 * Add new parts
	 */
	@Override
	public PartResponse addPart(PartRequest part) {
		// Check Part is present or not in the DB
		if (partRepository.findByPartName(part.getPartName()).isPresent()) {
			throw new PartFoundException(HttpStatus.BAD_REQUEST.value(), "PartFoundException",
					"Part is already available in the inventory");
		}

		if (part.getPartName() == null || part.getDescription() == null || part.getSupplierName() == null
				|| part.getCategoryType() == null || part.getThresholdLimit() == null)
			throw new MandatoryRequestFieldMissingException(HttpStatus.BAD_REQUEST.value(),
					"MandatoryRequestFieldMissingException", "Mandatory parts details are misssing in the request");
		
		Part partDetails = Part.builder()
							.partName(part.getPartName().toUpperCase())
							.description(part.getDescription())
							.supplierName(part.getSupplierName())
							.categoryType(part.getCategoryType())
							.thresholdLimit(part.getThresholdLimit())
							.availableQuantity(part.getAvailableQuantity())
							.minimumOrderQuantity(part.getMinimumOrderQuantity())
							.isInternationalSupplier(part.getIsInternationalSupplier())
							.isLocalSupplier(part.getIsLocalSupplier())
							.price(0.0).build();
		
		return new PartResponse(partRepository.save(partDetails));
	}

	/**
	 * update part
	 */
	@Override
	public PartRequest updatePartById(Long id, PartRequest partDetails) {

		if (partRepository.findById(id).isEmpty()) {
			throw new PartNotFoundException(HttpStatus.BAD_REQUEST.value(), "PartNotFoundException", "Part not found");
		}

		Optional<Part> partOptionalObj = partRepository.findById(id);
		if (partOptionalObj.isEmpty()) {
			throw new PartNotFoundException(HttpStatus.BAD_REQUEST.value(), "PartNotFoundException", "Part not found");
		}
		Part partObj = partOptionalObj.orElseThrow();
		if(partDetails.getPartName()!=null)
		partObj.setPartName(partDetails.getPartName());
		if(partDetails.getDescription()!=null)
		partObj.setDescription(partDetails.getDescription());
		if(partDetails.getSupplierName()!=null)
		partObj.setSupplierName(partDetails.getSupplierName());
		if(partDetails.getCategoryType()!=null)
		partObj.setCategoryType(partDetails.getCategoryType());
		if(partDetails.getAvailableQuantity()!=null)
		partObj.setAvailableQuantity(partDetails.getAvailableQuantity());
		if(partDetails.getThresholdLimit()!=null)
		partObj.setThresholdLimit(partDetails.getThresholdLimit());
		return new PartRequest(partRepository.save(partObj));
	}

	@Override
	public PartResponse getPartDetailsById(Long id) {
		if (partRepository.findById(id).isEmpty()) {
			throw new PartNotFoundException(HttpStatus.BAD_REQUEST.value(), "PartNotFoundException", "Part not found");
		}
		return new PartResponse(partRepository.findById(id).get());
	}

	@Override
	public void deletePartById(Long id) {
		if (partRepository.findById(id).isEmpty()) {
			throw new PartNotFoundException(HttpStatus.BAD_REQUEST.value(), "PartNotFoundException", "Part not found");
		}
		partRepository.deleteById(id);
	}

	@Override
	public List<PartResponse> getAllParts() {
		List<PartResponse> partResponse = new ArrayList<>();
		partRepository.findAll().forEach(partObj -> partResponse.add(new PartResponse(partObj)));
		return partResponse;
	}

	@Override
	public PartStockUpdateResponse updatePartStock(PartStockUpdateRequest stockUpdateRequest) {

		if (stockUpdateRequest.getPartId() == null || stockUpdateRequest.getQuantity() == null)
			throw new MandatoryRequestFieldMissingException(HttpStatus.BAD_REQUEST.value(),
					"MandatoryRequestFieldMissingException", "Mandatory parts details are misssing in the request");
		Optional<Part> partOptionalObj = partRepository.findById(stockUpdateRequest.getPartId());
		if (partOptionalObj.isEmpty()) {
			throw new PartNotFoundException(HttpStatus.BAD_REQUEST.value(), "PartNotFoundException", "Part not found");
		}
		Part partObj = partOptionalObj.orElseThrow();
		partObj.setAvailableQuantity(stockUpdateRequest.getQuantity());

		return new PartStockUpdateResponse(partRepository.save(partObj));
	}

}
