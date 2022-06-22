package com.testAPI.exception.resource;

import com.testAPI.domain.EquipmentState;
import com.testAPI.dto.EquipmentStateDTO;
import com.testAPI.repository.EquipmentStateRepository;
import com.testAPI.service.EquipmentStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipmentstates")
public class EquipmentStateResource {

    @Autowired
    private EquipmentStateService equipmentStateService;
    @Autowired
    private EquipmentStateRepository equipmentStateRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<EquipmentStateDTO>> findAlls() {
        List<EquipmentState> equipmentStateList = equipmentStateService.findAllEquipmentStates();
        List<EquipmentStateDTO> equipmentStateDTOList = equipmentStateList.stream().map(EquipmentStateDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(equipmentStateDTOList);
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipmentStateDTO> findByID(@PathVariable Long id) {
        EquipmentState equipmentState = equipmentStateService.findEquipmentStateByID(id);
        return ResponseEntity.ok().body(new EquipmentStateDTO(equipmentState));
    }

    //POST
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EquipmentStateDTO equipmentStateDTO) {
        EquipmentState equipmentState = equipmentStateService.fromDTO(equipmentStateDTO);
        equipmentState = equipmentStateService.createEquipmentState(equipmentState);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equipmentState.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //PUT
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody EquipmentStateDTO equipmentStateDTO, @PathVariable Long id){
        EquipmentState equipmentState = equipmentStateService.fromDTO(equipmentStateDTO);
        equipmentState.setId(id);
        equipmentState = equipmentStateService.updateEquipmentState(equipmentState);
        return ResponseEntity.noContent().build();
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        equipmentStateRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
