package com.BlogSphere.Spring_boot_project.dao;

import com.BlogSphere.Spring_boot_project.entity.Text;
import com.BlogSphere.Spring_boot_project.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TextDao {
    @Autowired
    TextRepository textRepository;
    public Text save(Text text){
        return textRepository.save(text);
    }
}
