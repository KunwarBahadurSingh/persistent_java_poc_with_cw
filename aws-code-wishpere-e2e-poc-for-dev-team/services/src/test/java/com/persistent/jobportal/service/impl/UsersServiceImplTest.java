package com.persistent.jobportal.service.impl;

import com.persistent.jobportal.entity.Users;
import com.persistent.jobportal.repository.IUsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
@ExtendWith(MockitoExtension.class)
class UsersServiceImplTest {

    //unit test for verify user method
    @InjectMocks
    private UsersServiceImpl usersServiceImpl;

    @Mock
    IUsersRepository iUserInfoRepository;


    @Test
    void verifyUser_success() throws Exception {


    }

    @Test
    void verifyUser() {
        Users mockUser = new Users();
        mockUser.setEmail("xyz@gmail.com");
        mockUser.setPassword("123");

        //iUserInfoRepository  = Mockito.mock(UsersServiceImpl.class);

        // given - precondition or setup
        given(iUserInfoRepository.findByEmailAndPassword(
                mockUser.getEmail(), mockUser.getPassword())).willReturn(mockUser);

        Users realUser = usersServiceImpl.verifyUser("xyz@gmail.com", "123");

        assertThat(realUser).isNotNull();
        assertThat(mockUser.getEmail()).isEqualTo(realUser.getEmail());
        assertThat(mockUser.getPassword()).isEqualTo(realUser.getPassword());
    }


    @Test
    void registerUser() {
        Users mockUser = new Users();
        mockUser.setUserId(1);
        mockUser.setUserName("XXX");
        mockUser.setQualification("MCA");
        mockUser.setEmail("xyz@gmail.com");
        mockUser.setPassword("123");


        // given - precondition or setup
        given(iUserInfoRepository.save(mockUser)).willReturn(mockUser);

        Users realUser = usersServiceImpl.registerUser(mockUser);

        assertThat(realUser).isNotNull();
        //assertTrue(mockUser.equals(realUser));
    }

    @Test
    void getAllUsers() {
        Users mockUser1 = new Users();
        mockUser1.setUserId(1);
        mockUser1.setUserName("XXX");
        mockUser1.setQualification("MCA");
        mockUser1.setEmail("xyz@gmail.com");
        mockUser1.setPassword("123");

        Users mockUser2 = new Users();
        mockUser2.setUserId(1);
        mockUser2.setUserName("XXX");
        mockUser2.setQualification("MCA");
        mockUser2.setEmail("xyz@gmail.com");
        mockUser2.setPassword("123");

        List<Users> usersList = List.of(mockUser1, mockUser2);
        // given - precondition or setup
        given(iUserInfoRepository.findAll()).willReturn(usersList);

        List<Users> realUsersList = usersServiceImpl.getAllUsers();

        assertThat(realUsersList).isNotNull();
        assertThat(usersList.size()).isEqualTo(realUsersList.size());
    }
}