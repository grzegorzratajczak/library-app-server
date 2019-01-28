package pl.grzex.grzexlibraryserver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LoanDto {

    private Long loanId;
    private Long copyId;
    private Long readerId;
    private String bookName;
    private String fromDate;
    private String toDate;

    public LoanDto(Long loanId, Long copyId, Long readerId, String bookName, String fromDate, String toDate) {
        this.loanId = loanId;
        this.copyId = copyId;
        this.readerId = readerId;
        this.bookName = bookName;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
