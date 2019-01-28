package pl.grzex.grzexlibraryserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CopyDto {

    private Long copyId;
    private String bookName;
    private boolean isExist;
    private boolean isLoan;

    public CopyDto(Long copyId, String bookName, boolean isExist, boolean isLoan) {
        this.copyId = copyId;
        this.bookName = bookName;
        this.isExist = isExist;
        this.isLoan = isLoan;
    }
}
