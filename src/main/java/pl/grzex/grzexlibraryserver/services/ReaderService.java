package pl.grzex.grzexlibraryserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import pl.grzex.grzexlibraryserver.dao.ReaderRepository;
import pl.grzex.grzexlibraryserver.dto.ReaderDto;
import pl.grzex.grzexlibraryserver.models.Reader;

public class ReaderService {

    private ReaderRepository readerRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public Reader findReaderById(Long readerId) {
        return readerRepository.findOne(readerId);
    }

    public Reader saveReader(ReaderDto readerDto) {
        Reader reader = new Reader();
        reader.setNick(readerDto.getNick());
        reader.setPassword(readerDto.getPassword());
        reader.setToPay(0);
        return readerRepository.save(reader);
    }

    public void deleteById(Long readerId) {
        readerRepository.delete(readerId);
    }
}
