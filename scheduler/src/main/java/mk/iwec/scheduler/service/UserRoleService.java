package mk.iwec.scheduler.service;

import mk.iwec.scheduler.model.User;
import mk.iwec.scheduler.model.UserRole;
import mk.iwec.scheduler.repository.UserRepository;
import mk.iwec.scheduler.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    public UserRole findById(Integer id) {
        return userRoleRepository.findById(id).orElse(null);
    }

    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public UserRole update(UserRole userRole) {
        if (userRoleRepository.existsById(userRole.getId())) {
            return userRoleRepository.save(userRole);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (userRoleRepository.existsById(id)) {
            userRoleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
