package swiss.pfadi.pfindusbackend.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import swiss.pfadi.pfindusbackend.model.Camp
import swiss.pfadi.pfindusbackend.service.CampService

@Controller
@CrossOrigin(origins = ["*"])
class CampController(val campService: CampService) {

    @GetMapping("/camp")
    fun getAllCamps(): ResponseEntity<List<Camp>> {
        val result = campService.getAllCamps();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/camp/{id}")
    fun getCamp(@PathVariable id: Long): ResponseEntity<Camp> {
        val result = campService.getCamp(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/camp")
    fun postCamp(@RequestBody camp: Camp): ResponseEntity<Camp> {
        val result = campService.save(camp);
        return ResponseEntity(camp, HttpStatus.CREATED);
    }

    @PutMapping("/camp/{id}")
    fun putCamp(@PathVariable id: Long, @RequestBody camp: Camp): ResponseEntity<Camp> {
        val result = campService.update(id, camp);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/camp/{id}")
    fun deleteCamp(@PathVariable id: Long): ResponseEntity<Void> {
        campService.delete(id);
        return ResponseEntity.ok().build();
    }

}
