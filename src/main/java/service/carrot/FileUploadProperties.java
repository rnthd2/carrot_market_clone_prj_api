package service.carrot;
 
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="file")// application.properties 에 선언한 file 필드에 접근한다는 말이다.
public class FileUploadProperties {
    private String uploadDir;//필드명은 camel case 로 연결되기때문에 이름을 작성할때 주의하자.
    //upload-dir 의 값에 자동으로 설정값이 연결된다.
 
    public String getUploadDir() {
        return uploadDir;
    }
 
    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
