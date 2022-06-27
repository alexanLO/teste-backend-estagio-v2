package com.testAPI.resource;

import com.testAPI.domain.Equipment;
import com.testAPI.dto.EquipmentDTO;
import com.testAPI.repository.EquipmentRepository;
import com.testAPI.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipments")
public class EquipmentResource {

    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private EquipmentRepository equipmentRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<EquipmentDTO>> findAlls() {
        List<Equipment> equipmentList = equipmentService.findAllEquipments();
        List<EquipmentDTO> equipmentDTOList = equipmentList.stream().map(EquipmentDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(equipmentDTOList);
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipmentDTO> findByID(@PathVariable Long id) {
        Equipment equipment = equipmentService.findEquipmentByID(id);
        return ResponseEntity.ok().body(new EquipmentDTO(equipment));
    }

    //POST
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EquipmentDTO equipmentDTO) {
        Equipment equipment = equipmentService.fromDTO(equipmentDTO);
        equipment = equipmentService.createEquipment(equipment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equipment.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //PUT
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody EquipmentDTO equipmentDTO, @PathVariable Long id){
        Equipment equipment = equipmentService.fromDTO(equipmentDTO);
        equipment.setId(id);
        equipment = equipmentService.updateEquipment(equipment);
        return ResponseEntity.noContent().build();
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        equipmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
