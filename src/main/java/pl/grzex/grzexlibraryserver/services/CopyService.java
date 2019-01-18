package pl.grzex.grzexlibraryserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzex.grzexlibraryserver.dao.CopyRepository;

@Service
public class CopyService {

    private CopyRepository copyRepository;

    @Autowired
    public CopyService(CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }


}
