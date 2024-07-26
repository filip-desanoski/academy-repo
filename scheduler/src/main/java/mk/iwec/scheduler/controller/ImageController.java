package mk.iwec.scheduler.controller;

import mk.iwec.scheduler.model.Enrollment;
import mk.iwec.scheduler.model.Image;
import mk.iwec.scheduler.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<Image> findAllImages() {
        return imageService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Image> findEnrollmentById(@PathVariable (value = "id") Integer id) {
        Image image = imageService.findById(id);
        HttpStatus status = image != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(image, status);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody Image image) {
        return imageService.save(image).getId();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Integer update(@RequestBody Image image) {
        return imageService.update(image).getId();
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus delete(@PathVariable(value = "id") Integer id) {
        boolean isDeleted = imageService.delete(id);
        return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }
}
