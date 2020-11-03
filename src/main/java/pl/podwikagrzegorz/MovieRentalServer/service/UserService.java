package pl.podwikagrzegorz.MovieRentalServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.podwikagrzegorz.MovieRentalServer.dao.UserRepository;
import pl.podwikagrzegorz.MovieRentalServer.model.User;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int addUser(User user) {
        boolean alreadyExistUser =  searchIfUserAlreadyExist(user);

        if (alreadyExistUser) {
            return ServerResponse.ALREADY_EXIST.getCode();
        } else {
            try {
                userRepository.save(user);
                return ServerResponse.OK.getCode();
            } catch (Exception e) {
                return ServerResponse.ERROR.getCode();
            }

        }
    }

    private boolean searchIfUserAlreadyExist(User user) {
        var name = user.getUsername();
        var exist = userRepository.existsByUsername(user.getUsername());
        System.out.println("name = " + name + " exist = " + exist);
        return userRepository.existsByUsername(user.getUsername());
    }

    public String loginUser(User user) {
        var searchUser = userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        //System.out.println(user + searchUser.toString());
        return searchUser.map(userFound -> userFound.getUserId().toString()).orElse("ERROR");
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
