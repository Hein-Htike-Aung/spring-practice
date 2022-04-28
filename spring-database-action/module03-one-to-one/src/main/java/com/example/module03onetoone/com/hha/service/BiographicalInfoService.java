package com.example.module03onetoone.com.hha.service;

import com.example.module03onetoone.com.hha.dao.BiographicalInfoDao;
import com.example.module03onetoone.com.hha.dao.EmployeeDao;
import com.example.module03onetoone.com.hha.entity.BiographicalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BiographicalInfoService {

    @Autowired
    private BiographicalInfoDao biographicalInfoDao;

    public List<BiographicalInfo> findAllBioInfo() {
        return biographicalInfoDao.findAll();

    }

    public void deleteBiographicalInfoById(int id) {
        biographicalInfoDao.deleteById(id);
    }


}
