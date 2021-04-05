package service.carrot.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.core.io.Resource;
import service.carrot.service.PostPhotoService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin //CORS(Cross Origin Resource Sharing) : 다른 Origin의 데이터를 사용한다면 CORS 표준을 지켜 다른 도메인을 허용하도록 할 수 있게 한다
@RestController
@RequiredArgsConstructor
public class PostPhotsController {
    private final PostPhotoService postPhotoService;

    /**
     * 파일 업로드
     * @param file
     * @return
     */
    @PostMapping("/upload/postPhotos")
    public FileUploadResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = postPhotoService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/postPhotos/")
                .path(fileName)
                .toUriString();

        postPhotoService.save(fileName, fileDownloadUri, file.getContentType(), file.getSize());

        return new FileUploadResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    /**
     * 멀티 파일 업로드
     * @param files
     * @return
     */
    @PostMapping("/upload/multiple/postPhotos")
    public List<FileUploadResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    /**
     * 파일 다운로드
     *
     * @param fileName
     * @param request
     * @return
     */
    @GetMapping("/download/postPhotos/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        // Load file as Resource
        Resource resource = postPhotoService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
//            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @Data
    class FileUploadResponse{
        private String name;
        private String uri;
        private String contentType;
        private long size;

        public FileUploadResponse(String name, String uri, String contentType, long size) {
            this.name = name;
            this.uri = uri;
            this.contentType = contentType;
            this.size = size;
        }
    }

}
