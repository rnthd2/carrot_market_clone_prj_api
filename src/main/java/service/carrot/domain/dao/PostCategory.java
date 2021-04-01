package service.carrot.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import service.carrot.domain.BaseEnumCode;

@AllArgsConstructor
@Getter
public enum PostCategory implements BaseEnumCode<Integer> {
    ALL("전체",0),
    DIGITAL_AND_HOME_APPLIANCE("디지털/가전",1),
    FURNITURE_AND_INTERIOR("가구/인테리어",2),
    CHILDRENS_AND_CHILDRENS_BOOKS("유아동/유아도서",3),
    LIVING_AND_PROCESSED_FOOD("생활/가공식품",4),
    SPORTS_AND_LEISURE("스포츠/레저",5),
    WOMENS_GOODS("여성잡화",6),
    WOMES_CLOTHING("여성의류",7),
    MENS_FASHION_AND_GOODS("남성패션/잡화",8),
    GAME_AND_HOBBIES("게임/취미",9),
    BEAUTY("뷰티/미용",10),
    PET_SUPPLIES("반려동물용품",11),
    BOOK_AND_TICKET_AND_REOCORD("도서/티켓/음반",12),
    PLANT("식물",13),
    OTHER_GOODS("기타 중고물품",14),
    BUY("삽니다",15);

    private final String name;
    private final int id;

    @Override
    public Integer getValue() {
        return this.id;
    }
}
