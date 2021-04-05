package service.carrot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import service.carrot.FileUploadProperties;
import service.carrot.domain.dao.Post;
import service.carrot.domain.dao.PostPhotos;
import service.carrot.exceptions.FileDownloadException;
import service.carrot.exceptions.FileUploadException;
import service.carrot.repository.PostPhotosRepository;
import service.carrot.repository.PostRepository;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PostPhotoService {

    @Autowired
    private PostPhotosRepository postPhotosRepository;

    @Autowired
    private PostRepository postRepository;

    private final Path fileLocation;

    /**
     * 파일 업로드 디렉토리 생성
     *
     * @param prop
     */
    @Autowired
    public PostPhotoService(FileUploadProperties prop) {
        this.fileLocation = Paths.get(prop.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileLocation);
        }catch(Exception e) {
            throw new FileUploadException("파일을 업로드할 디렉토리를 생성하지 못했습니다.", e);
        }
    }

    /**
     * 파일 저장
     * 동일한 파일이 존재하는 경우 덮어쓴다.
     *
     * @param file
     * @return
     */
    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // 파일명에 부적합 문자가 있는지 확인한다.
            if(fileName.contains(".."))
                throw new FileUploadException("파일명에 부적합 문자가 포함되어 있습니다. " + fileName);

            Path targetLocation = this.fileLocation.resolve(fileName);

            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        }catch(Exception e) {
            throw new FileUploadException("["+fileName+"] 파일 업로드에 실패하였습니다. 다시 시도하십시오.",e);
        }
    }

    /**
     * 파일 DB 저장
     *
     * todo try catch
     * @param fileName
     * @param fileDownloadUri
     * @param contentType
     * @param size
     * @return
     */
    public PostPhotos save(String fileName, String fileDownloadUri, String contentType, long size) {
        Post post = postRepository.findById(1).get();
        PostPhotos postPhotos = PostPhotos.createPostPhotos(post, fileName, fileDownloadUri,contentType, size);
        return postPhotosRepository.save(postPhotos);
    }

    /**
     * 파일 다운로드
     *
     * @param fileName
     * @return
     */
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if(resource.exists()) {
                return resource;
            }else {
                throw new FileDownloadException(fileName + " 파일을 찾을 수 없습니다.");
            }
        }catch(MalformedURLException e) {
            throw new FileDownloadException(fileName + " 파일을 찾을 수 없습니다.", e);
        }
    }
}
