package com.epam.eshop.api.controller;

import com.epam.eshop.api.controller.constant.RestParameters;
import com.epam.eshop.domain.UserEntity;
import com.epam.eshop.domain.UserRole;
import com.epam.eshop.dto.ApiResponseDataDto;
import com.epam.eshop.dto.CreateUserDto;
import com.epam.eshop.dto.UserDto;
import com.epam.eshop.dto.validation.ErrorMassage;
import com.epam.eshop.dto.validation.RegexConstants;
import com.epam.eshop.dto.validation.annotation.EnumValidator;
import com.epam.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class UserRest {

    private UserService <UserEntity, String> userService;

    @Autowired
    public UserRest(UserService <UserEntity, String> userService){
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ApiResponseDataDto create(@RequestBody @Valid CreateUserDto createUserDto) {
        UserEntity convertUser = new UserEntity(createUserDto, UserEntity.class);
        return new ApiResponseDataDto<>(userService
                .save(convertUser)
                .getId());
    }

    @GetMapping(value = "/users")
    public ApiResponseDataDto<Page<UserDto>> findUsers(@RequestParam(value = RestParameters.FULL_NAME_OR_EMAIL, required = false)
                                                       @Pattern(regexp = RegexConstants.SEARCH_QUERY_FOR_USERS_MAX_35_OR_EMPTY, message = ErrorMassage.USER_NAME) String fullNameOrEmail,
                                                       @RequestParam(value = RestParameters.USER_ROLE, required = false) @EnumValidator(enumClazz = UserRole.class) String role,
                                                       @SortDefault(sort = "fullName", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<UserEntity> userEntityPage = userService.findUsers(fullNameOrEmail, role, pageable);
        Page<UserDto> userDtoList = userEntityPage.map(userEntity -> new UserDto(userEntity, UserDto.class));
        return new ApiResponseDataDto<>(userDtoList);
    }
}
