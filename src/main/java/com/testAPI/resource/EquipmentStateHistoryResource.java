package com.testAPI.resource;

import com.testAPI.domain.EquipmentStateHistory;
import com.testAPI.dto.EquipmentStateHistoryDTO;
import com.testAPI.repository.EquipmentStateHistoryRepository;
import com.testAPI.service.EquipmentStateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipmentstatehistorys")
public class EquipmentStateHistoryResource {

    @Autowired
    private EquipmentStateHistoryService equipmentStateHistoryService;
    @Autowired
    private EquipmentStateHistoryRepository equipmentStateHistoryRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<EquipmentStateHistoryDTO>> findAlls() {
        List<EquipmentStateHistory> equipmentStateHistoryList = equipmentStateHistoryService.findAllEquipmentStateHistory();
        List<EquipmentStateHistoryDTO> equipmentStateHistoryDTOList = equipmentStateHistoryList.stream().map(x -> new EquipmentStateHistoryDTO()).collect(Collectors.toList());
        return ResponseEntity.ok().body(equipmentStateHistoryDTOList);
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipmentStateHistoryDTO> findByID(@PathVariable Long id) {
        EquipmentStateHistory equipmentStateHistory = equipmentStateHistoryService.findEquipmentStateHistoryByID(id);
        return ResponseEntity.ok().body(new EquipmentStateHistoryDTO(equipmentStateHistory));
    }

    //POST
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EquipmentStateHistoryDTO equipmentStateHistoryDTO) {
        EquipmentStateHistory equipmentStateHistory = equipmentStateHistoryService.fromDTO(equipmentStateHistoryDTO);
        equipmentStateHistory = equipmentStateHistoryService.createEquipmentStateHistory(equipmentStateHistory);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equipmentStateHistory.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //PUT
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody EquipmentStateHistoryDTO equipmentStateHistoryDTO, @PathVariable Long id){
        EquipmentStateHistory equipmentStateHistory = equipmentStateHistoryService.fromDTO(equipmentStateHistoryDTO);
        equipmentStateHistory.setId(id);
        equipmentStateHistory = equipmentStateHistoryService.updateEquipmentStateHistory(equipmentStateHistory);
        return ResponseEntity.noContent().build();
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        equipmentStateHistoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
