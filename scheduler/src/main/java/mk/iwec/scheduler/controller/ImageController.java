package mk.iwec.scheduler.controller;

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

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Image> findImageById(@PathVariable(value = "id") Integer id) {
        Image image = imageService.findById(id);
        HttpStatus status = image != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(image, status);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Integer uploadImage(@RequestParam("imgName") String imgName, @RequestParam("img") MultipartFile file) throws IOException {
        Image image = new Image();
        image.setImgName(imgName);
        image.setImg(file.getBytes());
        return imageService.save(image).getId();
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Integer updateImage(@RequestParam("id") Integer id, @RequestParam("imgName") String imgName, @RequestParam("img") MultipartFile file) throws IOException {
        Image image = new Image();
        image.setId(id);
        image.setImgName(imgName);
        image.setImg(file.getBytes());
        return imageService.update(image).getId();
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deleteImage(@PathVariable(value = "id") Integer id) {
        boolean isDeleted = imageService.delete(id);
        return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }
}
