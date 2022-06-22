package com.testAPI.exception.resource;

import com.testAPI.domain.EquipmentModel;
import com.testAPI.dto.EquipmentModelDTO;
import com.testAPI.repository.EquipmentModelRepository;
import com.testAPI.service.EquipmentModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipmentmodels")
public class EquipmentModelResource {

    @Autowired
    private EquipmentModelService equipmentModelService;
    @Autowired
    private EquipmentModelRepository equipmentModelRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<EquipmentModelDTO>> findAllModels() {
        List<EquipmentModel> equipmentModelList = equipmentModelService.findAllModels();
        List<EquipmentModelDTO> equipmentModelDTOList = equipmentModelList.stream().map(EquipmentModelDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(equipmentModelDTOList);
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipmentModelDTO> findModelByID(@PathVariable Long id) {
        EquipmentModel equipmentModel = equipmentModelService.findModelByID(id);
        return ResponseEntity.ok().body(new EquipmentModelDTO(equipmentModel));
    }

    //POST
    @PostMapping
    public ResponseEntity<Void> createModel(@RequestBody EquipmentModelDTO equipmentModelDTO) {
        EquipmentModel equipmentModel = equipmentModelService.fromDTO(equipmentModelDTO);
        equipmentModel = equipmentModelService.createEquipmentModel(equipmentModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equipmentModel.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //PUT
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateModel(@RequestBody EquipmentModelDTO equipmentModelDTO, @PathVariable Long id) {
        EquipmentModel equipmentModel = equipmentModelService.fromDTO(equipmentModelDTO);
        equipmentModel.setId(id);
        equipmentModel = equipmentModelService.updateModel(equipmentModel);
        return ResponseEntity.noContent().build();
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable Long id) {
        equipmentModelRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
