package childrencare.app.service;


import childrencare.app.model.UserModel;
import childrencare.app.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    @Autowired
    private LoginRepository loginRepository;

    public UserModel checkUserExist(String username, String email, String password) {
        return loginRepository.checkUserExist(username, email, password);
    }
    public UserModel save(UserModel entity) {
        return loginRepository.save(entity);
    }

    public UserModel getInfo(String username) {
        return loginRepository.getInfo(username);
    }


    @Modifying
    public void changePass(String pass, String username) {
        loginRepository.changePass(pass, username);
    }
}
