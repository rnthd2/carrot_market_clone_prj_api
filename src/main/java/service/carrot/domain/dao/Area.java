package service.carrot.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import service.carrot.domain.BaseEnumCode;

@AllArgsConstructor
@Getter
public enum Area implements BaseEnumCode<String> {
    SEOUL("서울","02"),
    BUSAN("부산","051"),
    DAEGU("대구","053"),
    INCHEON("인천","032"),
    GWANGJU("광주","062"),
    DAEJEON("대전","042"),
    ULSAN("울산","052"),
    SEJONG("세종","044"),
    GYEONGGI("경기","031"),
    GANGWON("강원","033"),
    CHUNGBUK("충북","043"),
    CHUNGNAM("충남","041"),
    JEONBUK("전북","063"),
    JEONNAM("전남","061"),
    GYEONGBUK("경북","054"),
    GYEONGNAM("경남","055"),
    JEJU("제주","064");

    private final String name;
    private final String code;

    @Override
    public String getValue() {
        return this.code;
    }
}
