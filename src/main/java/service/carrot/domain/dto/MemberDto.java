package service.carrot.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Data
public class MemberDto {

    private Long id;
    private String pw;
    private String email;

}
