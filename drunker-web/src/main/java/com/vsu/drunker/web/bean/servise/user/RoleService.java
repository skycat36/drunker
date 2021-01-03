package com.vsu.drunker.web.bean.servise.user;


import com.vsu.drunker.db.model.repository.RoleRepository;
import com.vsu.drunker.web.bean.converter.RoleConverter;
import com.vsu.drunker.web.data.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class RoleService {

    private final RoleRepository roleRepository;

    private final RoleConverter roleConverter;

    @Transactional
    public RoleDTO createRole(RoleDTO roleDTO){
        return roleConverter.convert(roleRepository.save(roleConverter.convert(roleDTO)));
    }

    @Transactional
    public RoleDTO updateRole(Long roleId, RoleDTO roleDTO){
        return roleConverter.convert(roleRepository.save(roleConverter.convert(roleId, roleDTO)));
    }

    @Transactional
    public boolean deleteRole(Long roleId){
        if (existByIdRoleDTO(roleId)){
            roleRepository.deleteById(roleId);
            return true;
        }
        return false;
    }

    public boolean existByIdRoleDTO(Long id){
        return roleRepository.existsById(id);
    }

    public List<RoleDTO> getAllRoleDTO(){
        return roleRepository.findAll().stream().map(roleConverter::convert).collect(Collectors.toList());
    }

}
