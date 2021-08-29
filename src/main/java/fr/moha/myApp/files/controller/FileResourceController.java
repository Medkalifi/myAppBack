package fr.moha.myApp.files.controller;

import static java.nio.file.Files.copy;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.Paths.get;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/file")
public class FileResourceController {

	// define a location
    public static final String DIRECTORY = System.getProperty("user.home") + "/fichiers/";

    // Define a method to upload files
    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files")List<MultipartFile> multipartFiles) throws IOException {
        List<String> filenames = new ArrayList<>();
        for(MultipartFile file : multipartFiles) {
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            Path fileStorage = get(DIRECTORY+"uploads", filename).toAbsolutePath().normalize();
            System.out.println("le nom du fichier est "+ filename);
            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
            
            System.out.println("le path du fichier est "+ fileStorage);
            filenames.add(filename);
        }
        return ResponseEntity.ok().body(filenames);
    }
    
    // Define a method to download files
    @GetMapping("download/{filename}")
public ResponseEntity<Resource> downloadFiles(@PathVariable("filename")String filename) throws Exception{
	Path filePath = get(DIRECTORY+"uploads").toAbsolutePath().normalize().resolve(filename);
	System.out.println("le path est "+filePath);
	
	 filename = filePath.getFileName().toString();
	 System.out.println("le nom du fichier est "+filename);
	if(!Files.exists(filePath)) {
        throw new FileNotFoundException(filename + " n'a pas été trouvé dans le serveur ...");
	}
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", filePath.getFileName().toString());
       
       
        
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename().toString());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders).body(resource);
        
    }
}
	
	

