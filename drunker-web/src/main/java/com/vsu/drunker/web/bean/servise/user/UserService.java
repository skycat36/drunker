package com.vsu.drunker.web.bean.servise.user;

import com.vsu.drunker.db.model.repository.UserRepository;
import com.vsu.drunker.web.bean.converter.UserConverter;
import com.vsu.drunker.web.data.UserDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    @Transactional
    public UserDTO createUser(UserDTO userDTO){
        return userConverter.convert(userRepository.save(userConverter.convert(userDTO)));
    }

    @Transactional
    public UserDTO updateUser(Long userId, UserDTO userDTO){
        return userConverter.convert(userRepository.save(userConverter.convert(userId, userDTO)));
    }

    @Transactional
    public boolean deleteUser(Long userId){
        if (existByIdUserDTO(userId)){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public boolean existByIdUserDTO(Long id){
        return userRepository.existsById(id);
    }

    public List<UserDTO> getAllUserDTO(){
        return userRepository.findAll().stream().map(userConverter::convert).collect(Collectors.toList());
    }
}
