package pl.grzex.grzexlibraryserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CopyDto {

    private String bookName;
    private Long copyId;
    private boolean isExist;
    private boolean isLoan;

}
