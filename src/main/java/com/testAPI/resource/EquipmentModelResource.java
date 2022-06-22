package com.testAPI.resource;

import com.testAPI.domain.EquipmentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/equipmentmodels")
public class EquipmentModelResource {

    @GetMapping
    public List<EquipmentModel> findAllModels(){
        EquipmentModel equipmentModel01 = new EquipmentModel("1", "modelo01");
        EquipmentModel equipmentModel02 = new EquipmentModel("1", "modelo02");
        List<EquipmentModel> equipmentModelList = new ArrayList<>();
        equipmentModelList.addAll(Arrays.asList(equipmentModel01, equipmentModel02));
        return equipmentModelList;
    }
}
