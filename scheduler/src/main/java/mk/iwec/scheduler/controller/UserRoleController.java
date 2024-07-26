package mk.iwec.scheduler.controller;

import mk.iwec.scheduler.model.Training;
import mk.iwec.scheduler.model.User;
import mk.iwec.scheduler.model.UserRole;
import mk.iwec.scheduler.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user_roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<UserRole> findAllUserRoles() {
        return userRoleService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserRole> findUserRoleById(@PathVariable(value = "id") Integer id) {
        UserRole userRole = userRoleService.findById(id);
        HttpStatus status = userRole != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(userRole, status);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody UserRole userRole) {
        return userRoleService.save(userRole).getId();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Integer update(@RequestBody UserRole userRole) {
        return userRoleService.update(userRole).getId();
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus delete(@PathVariable(value = "id") Integer id) {
        boolean isDeleted = userRoleService.delete(id);
        return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }
}
