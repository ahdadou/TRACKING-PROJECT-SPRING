package com.gaming.worspace.services;

import com.gaming.worspace.dao.UserRepository;
import com.gaming.worspace.exceptions.BadRequestException;
import com.gaming.worspace.models.User;
import com.gaming.worspace.models.dto.request.UserRequestDTO;
import com.gaming.worspace.models.enumerated.Gender;
import com.gaming.worspace.services.mappers.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class UserServicesTest {


    @Mock
    private RoleService roleService;

    @Mock
    UserRepository userRepository;

    @Mock
    private ServiceTypeService serviceTypeService;

    @InjectMocks
    private UserServices underTest;

    @Spy
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new UserServices(userRepository,roleService, serviceTypeService, userMapper);
    }

    @Test
    void isShouldCreateUser() {
        //Given: User Instant
        UserRequestDTO userDTO = userRequestDTO();
        // When
        underTest.createUser(userDTO);
        // Then
        ArgumentCaptor<User> userArgumentCaptor =
                ArgumentCaptor.forClass(User.class);

        verify(userRepository).save(userArgumentCaptor.capture());
        User userArgumentCaptorValue = userArgumentCaptor.getValue();
        assertThat(userArgumentCaptorValue.getUsername()).isEqualTo(userDTO.getUsername());
    }

    @Test
    void shouldThrowWhenEmailTaken() {

//        Given
        UserRequestDTO userDTO = userRequestDTO();
        given(userRepository.existsByEmail(anyString()))
                .willReturn(true);

        // Then
        assertThatThrownBy(() -> underTest.createUser(userDTO))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining(String.format("Email [%s] is taken", userDTO.getEmail()));

        verify(userRepository,never()).save(any());

    }

    @Test
    void getAllUser() {
        //when
        underTest.getAllUser();

        //then
        verify(userRepository).findAll();
    }


    private UserRequestDTO userRequestDTO(){
        UserRequestDTO userDTO=new UserRequestDTO();
        userDTO.setUsername("IBRA.AHD");userDTO.setFirstname("IBRA.AHD");
        userDTO.setLastname("IBRA.AHD");userDTO.setEmail("IBRA@GMAIL.COM");
        userDTO.setGender(Gender.MALE.toString());
        userDTO.setIsDelivery(true);
        return userDTO;
    }



}