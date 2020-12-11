package com.vsu.drunker.service.user;

import com.vsu.drunker.model.repository.UserRepository;
import com.vsu.drunker.converter.UserConverter;
import com.vsu.drunker.data.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    public UserService(UserConverter userConverter, UserRepository userRepository) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

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
