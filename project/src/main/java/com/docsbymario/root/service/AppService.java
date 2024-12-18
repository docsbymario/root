package com.docsbymario.root.service;

import com.docsbymario.root.entity.App;
import com.docsbymario.root.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    @Autowired
    private AppRepository appRepository;

    public List<App> findAll() {
        return appRepository.findAll();
    }
}
