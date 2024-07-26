package mk.iwec.scheduler.service;

import mk.iwec.scheduler.model.Image;
import mk.iwec.scheduler.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    public Image findById(Integer id) {
        return imageRepository.findById(id).orElse(null);
    }

    public Image save(Image image) {
        return imageRepository.save(image);
    }

    public Image update(Image image) {
        if (imageRepository.existsById(image.getId())) {
            return imageRepository.save(image);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (imageRepository.existsById(id)) {
            imageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
