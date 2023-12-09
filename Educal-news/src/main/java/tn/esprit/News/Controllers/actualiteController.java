package tn.esprit.News.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.News.Entities.Actualite;
import tn.esprit.News.Services.IActualiteService;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class actualiteController {
    IActualiteService actualiteService;

    @PostMapping("/dashboard/actualites/addActualite")
    Actualite addActualite(@RequestBody Actualite actualite){
        return actualiteService.addActualite(actualite);
    }

    @GetMapping("/dashboard/actualites/getOneActualite/{id}")
    Actualite getActualite(@PathVariable Long id){
        return actualiteService.getActualite(id);
    }

    @GetMapping("/dashboard/actualites")
    List<Actualite> getAllActualites(){
        return actualiteService.getAllActualites();
    }

    @DeleteMapping("/dashboard/actualites/deleteActualite/{id}")
    void deleteClubById(@PathVariable Long id){
        this.actualiteService.deleteActualiteById(id);
    }

    @PutMapping("/dashboard/actualites/updateActualite")
    Actualite updateActualite(@RequestBody Actualite actualite){
        return  this.actualiteService.updateActualite(actualite);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
    @PostMapping("/dashboard/actualites/uploadImage/{id}")
    public Actualite handleImageFileUpload(@RequestParam("fileImage") MultipartFile fileImage, @PathVariable long id) {
        return actualiteService.handleImageFileUpload(fileImage,id);
    }


    /*****************************************/

    @PostMapping("/news/shareFb/{id}")
    public String shareFb(@PathVariable Long id){
        return actualiteService.shareFb(id);
    }

}
