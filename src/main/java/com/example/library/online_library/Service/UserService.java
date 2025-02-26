package com.example.library.online_library.Service;

import com.example.library.online_library.Model.User;
import com.example.library.online_library.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //сохранение
    public User save(User user){
        return userRepository.save(user);
    }

    //удаление
    public void delete(Long id){
        this.userRepository.deleteById(id);
    }

    //ищем по Ид
    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }

    //получаем полный список юзеров
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

}
