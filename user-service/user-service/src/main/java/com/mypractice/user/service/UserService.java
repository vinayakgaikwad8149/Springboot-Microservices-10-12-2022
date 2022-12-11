package com.mypractice.user.service;

import com.mypractice.user.entity.User;
import com.mypractice.user.repository.UserRepository;
import com.mypractice.user.valueObject.Department;
import com.mypractice.user.valueObject.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside the save user of user-service");
        return userRepository.save(user);

    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("inside the getUserWithDepartment of user-service");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        System.out.println(department.getDepartmentName());
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}

