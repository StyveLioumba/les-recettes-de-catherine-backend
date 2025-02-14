package com.bdx.anais.ApplicationRecetteCuisine.web.rest;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Step;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.StepRecordDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.StepUpdateDTO;
import com.bdx.anais.ApplicationRecetteCuisine.service.StepService;
import com.bdx.anais.ApplicationRecetteCuisine.shared.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StepController {

    @Autowired
    private StepService stepService;

    @PostMapping("/api/step/create")
    public ResponseEntity<Step> recordStep(@RequestBody StepRecordDTO stepRecordDTO) {
        return stepService.recordStep(stepRecordDTO);
    }

    @GetMapping("api/step/all")
    public ResponseEntity<ApiResponse<List<Step>>> findAllStep(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        ApiResponse<List<Step>> steps = stepService.findAllStep(page, size);
        return new ResponseEntity<>(steps, HttpStatus.OK);
    }

    @DeleteMapping("api/step/delete/{id}")
    public void deletStep(@PathVariable String id) {
        stepService.deleteStep(id);
    }

    @GetMapping("api/step/{id}")
    public ResponseEntity<Step> findStep(@PathVariable String id) {
        return stepService.findStep(id);
    }

    @PutMapping("api/step/update/{id}")
    public ResponseEntity<Step> updateStep(@PathVariable String id, @RequestBody StepUpdateDTO stepUpdateDTO) {
        return stepService.updateStep(id , stepUpdateDTO);
    }
}
