package com.testAPI.resource;

import com.testAPI.domain.EquipmentModelStateHourlyEarnings;
import com.testAPI.dto.EquipmentModelStateHourlyEarningsDTO;
import com.testAPI.repository.EquipmentModelStateHourlyEarningsRepository;
import com.testAPI.service.EquipmentModelStateHourlyEarningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipmentmodelstatehourlyearning")
public class EquipmentModelStateHourlyEarningsResource {

    @Autowired
    private EquipmentModelStateHourlyEarningsService equipmentModelStateHourlyEarningsService;
    @Autowired
    private EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<EquipmentModelStateHourlyEarningsDTO>> findAlls() {
        List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarningsList = equipmentModelStateHourlyEarningsService.findAllEquipmentModelStateHourlyEarnings();
        List<EquipmentModelStateHourlyEarningsDTO> equipmentModelStateHourlyEarningsDTOList = equipmentModelStateHourlyEarningsList.stream().map(EquipmentModelStateHourlyEarningsDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(equipmentModelStateHourlyEarningsDTOList);
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipmentModelStateHourlyEarningsDTO> findByID(@PathVariable Long id) {
        EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsService.findEquipmentModelStateHourlyEarningsByID(id);
        return ResponseEntity.ok().body(new EquipmentModelStateHourlyEarningsDTO(equipmentModelStateHourlyEarnings));
    }

    //POST
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EquipmentModelStateHourlyEarningsDTO equipmentModelStateHourlyEarningsDTO) {
        EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsService.fromDTO(equipmentModelStateHourlyEarningsDTO);
        equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsService.createEquipmentModelStateHourlyEarnings(equipmentModelStateHourlyEarnings);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equipmentModelStateHourlyEarnings.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //PUT
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody EquipmentModelStateHourlyEarningsDTO equipmentModelStateHourlyEarningsDTO, @PathVariable Long id){
        EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsService.fromDTO(equipmentModelStateHourlyEarningsDTO);
        equipmentModelStateHourlyEarnings.setId(id);
        equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarningsService.updateEquipmentModelStateHourlyEarnings(equipmentModelStateHourlyEarnings);
        return ResponseEntity.noContent().build();
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        equipmentModelStateHourlyEarningsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
