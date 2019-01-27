package pl.grzex.grzexlibraryserver.dto;

import lombok.Getter;
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

}
