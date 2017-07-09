package imageloader.imageloader.Controllers;


import imageloader.imageloader.Entities.Image;
import imageloader.imageloader.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class HomeController {

    private static final String BASE_PATH = "/images";
    private static final String FILENAME = "{filename:.+}";

    private final ImageService imageService;

    @Autowired
    public HomeController(final ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(value = "/")
    public String index(Model model, Pageable pageable) {
        final Page<Image> page = imageService.findPage(pageable);
        model.addAttribute("page", page);
//        if(page.hasPrevious())
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value = BASE_PATH)
    public String createFile(@RequestParam("file") MultipartFile file,
                                        RedirectAttributes redirectAttributes) {
        try {
            imageService.createImage(file);
            redirectAttributes.addFlashAttribute("flash.message", "Successfully uploaded " + file.getOriginalFilename());
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("flash.message", "Failed to upload " + file.getOriginalFilename());
        }

        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = BASE_PATH + "/" + FILENAME)
    public String deleteFile(@PathVariable String filename,
                                        RedirectAttributes redirectAttributes) {
        try {
            imageService.deleteImage(filename);
            redirectAttributes.addFlashAttribute("flash.message", "Successfully deleted " + filename);
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("flash.message", "Failed to delete "
                    + filename + " => " + e.getMessage());
        }
        return "redirect:/";
    }
}
