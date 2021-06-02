package com.codegym.casestudy.controller;

import com.codegym.casestudy.models.employee.Division;
import com.codegym.casestudy.models.employee.Education;
import com.codegym.casestudy.models.employee.Employee;
import com.codegym.casestudy.models.employee.Position;
import com.codegym.casestudy.models.user_role.Roles;
import com.codegym.casestudy.models.user_role.UserRole;
import com.codegym.casestudy.models.user_role.UserRoleKey;
import com.codegym.casestudy.models.user_role.dto.UserDto;
import com.codegym.casestudy.sevices.employee.DivisionService;
import com.codegym.casestudy.sevices.employee.EducationService;
import com.codegym.casestudy.sevices.employee.EmployeeService;
import com.codegym.casestudy.sevices.employee.PositionService;
import com.codegym.casestudy.sevices.user_role.RolesService;
import com.codegym.casestudy.sevices.user_role.UserRoleService;
import com.codegym.casestudy.sevices.user_role.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private RolesService rolesService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @ModelAttribute("roles")
    public List<Roles> getAppRoles() {
        return rolesService.findAll();
    }

    @ModelAttribute("divisions")
    public List<Division> getDepartments(){
        return divisionService.findAll();
    }

    @ModelAttribute("positions")
    public List<Position> getPositions(){
        return positionService.findAll();
    }

    @ModelAttribute("education")
    public List<Education> getEducationDegrees(){
        return educationService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, @RequestParam String confirmPassword, Model model, RedirectAttributes attributes) {
        if (usersService.existById(employee.getUsers().getUsername())) {
            bindingResult.addError(new FieldError("employee", "users.username", "Tên đăng nhập đã tồn tại"));
        }
        if (!employee.getUsers().getPassword().equals(confirmPassword)) {
            bindingResult.addError(new FieldError("employee", "users.password", "Xác nhận mật khẩu không chính xác"));
        }
        if (bindingResult.hasFieldErrors()) {
            return "employee/create";
        }
        employee.getUsers().setPassword(bCryptPasswordEncoder.encode(employee.getUsers().getPassword()));
        employeeService.save(employee);
////        set user role default is ROLE_NHANVIEN
//        UserRole userRole = new UserRole();
//        userRole.setId(new UserRoleKey(employee.getUsers().getUsername(), 3));
//        userRole.setUsers(employee.getUsers());
//        userRole.setRoles(rolesService.findById(3));
//        userRoleService.save(userRole);
//
////        convert from UserRole to AppRole and add to appUserDto
//        Set<Roles> currentRoles = new HashSet<>();
//        currentRoles.add(rolesService.findById(3));
//
////        Send user info to setRole page
//        UserDto userDto = new UserDto();
//        userDto.setUsers(employee.getUsers());
//        userDto.setRoles(currentRoles);
//        model.addAttribute("userDto", userDto);
        return "/employee/setRole";
    }

//    @PostMapping("/setRole")
//    @Transactional
//    public String setRole(@ModelAttribute UserDto userDto) {
//        userRoleService.deleteAllByUsername(userDto.getUsers().getUsername());
//        for (Roles role : userDto.getRoles()) {
//            UserRole userRole = new UserRole();
//            userRole.setUsers(userDto.getUsers());
//            userRole.setRoles(role);
//            userRole.setId(new UserRoleKey(userDto.getUsers().getUsername(), role.getId()));
//            userRoleService.save(userRole);
//        }
//        return "redirect:/employee/view/" + userDto.getUsers().getEmployee().getId();
//    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
//        try {
//            employeeService.delete(id);
//        } catch (SQLIntegrityConstraintViolationException e){
//            return "redirect:/employee/delete-error";
//        }

        return "redirect:/employee/";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "employee/edit";
        }
        employeeService.save(employee);
        Set<Roles> currentRoles = new HashSet<>();
        if (employee.getUsers().getUserRoles() != null){
            for(UserRole userRole : employee.getUsers().getUserRoles()){
                currentRoles.add(userRole.getRoles());
            }
        }
        UserDto appUserDto = new UserDto();
        appUserDto.setUsers(employee.getUsers());
        appUserDto.setRoles(currentRoles);
        model.addAttribute("userDto", appUserDto);
        return "/employee/setRole";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return "redirect:/employee/";
        } else {
            model.addAttribute("employee", employee);
            return "employee/view";
        }
    }

    @GetMapping(value = {"", "/"})
    public ModelAndView search(@RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "0") int page) {
        search = search.trim();
        ModelAndView modelAndView = new ModelAndView("employee/list");
        Pageable pageable = PageRequest.of(page, 5);
        if (search.equals("")) {
            modelAndView.addObject("employees", employeeService.findAll(pageable));
            return modelAndView;
        } else {
            modelAndView.addObject("search", search);
            modelAndView.addObject("employees", employeeService.findByName(search, pageable));
            return modelAndView;
        }
    }

//    @GetMapping("/delete-error")
//    public String sqlDeleteHandler(){
//        return "sql-error-page";
//    }

//    @ExceptionHandler(Exception.class)
//    public String viewErrorPage(HttpServletRequest request, Exception exception) {
//        return "error-page";
//    }



}
