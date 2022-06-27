package com.testAPI.resource;

import com.testAPI.domain.EquipmentPositionHistory;
import com.testAPI.dto.EquipmentPositionHistoryDTO;
import com.testAPI.repository.EquipmentPositionHistoryRepository;
import com.testAPI.service.EquipmentPositionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipmentpositionhistorys")
public class EquipmentPositionHistoryResource {

    @Autowired
    private EquipmentPositionHistoryService equipmentPositionHistoryService;
    @Autowired
    private EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<EquipmentPositionHistoryDTO>> findAlls() {
        List<EquipmentPositionHistory> equipmentPositionHistoryList = equipmentPositionHistoryService.findAllEquipmentPositionHistorys();
        List<EquipmentPositionHistoryDTO> equipmentPositionHistoryDTOList = equipmentPositionHistoryList.stream().map(EquipmentPositionHistoryDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(equipmentPositionHistoryDTOList);
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipmentPositionHistoryDTO> findByID(@PathVariable Long id) {
        EquipmentPositionHistory equipmentPositionHistory = equipmentPositionHistoryService.findEquipmentPositionHistoryByID(id);
        return ResponseEntity.ok().body(new EquipmentPositionHistoryDTO(equipmentPositionHistory));
    }

    //POST
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EquipmentPositionHistoryDTO equipmentPositionHistoryDTO) {
        EquipmentPositionHistory equipmentPositionHistory = equipmentPositionHistoryService.fromDTO(equipmentPositionHistoryDTO);
        equipmentPositionHistory = equipmentPositionHistoryService.createEquipmentPositionHistory(equipmentPositionHistory);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equipmentPositionHistory.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //PUT
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody EquipmentPositionHistoryDTO equipmentPositionHistoryDTO, @PathVariable Long id){
        EquipmentPositionHistory equipmentPositionHistory = equipmentPositionHistoryService.fromDTO(equipmentPositionHistoryDTO);
        equipmentPositionHistory.setId(id);
        equipmentPositionHistory = equipmentPositionHistoryService.updateEquipmentPositionHistory(equipmentPositionHistory);
        return ResponseEntity.noContent().build();
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        equipmentPositionHistoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
