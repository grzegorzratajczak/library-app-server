package pl.grzex.grzexlibraryserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReaderDto {

    private String nick;
    private String password;
    private Integer toPay;
    private Long readerId;

    public ReaderDto(String nick, String password, Integer toPay, Long readerId) {
        this.nick = nick;
        this.password = password;
        this.toPay = toPay;
        this.readerId = readerId;
    }
}
