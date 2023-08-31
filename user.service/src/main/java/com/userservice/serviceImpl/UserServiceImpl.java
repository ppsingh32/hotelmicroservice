package com.userservice.serviceImpl;

import com.userservice.core.RatingService;
import com.userservice.dto.RatingResponseDto;
import com.userservice.dto.UserRequestDto;
import com.userservice.dto.UserResponseDto;
import com.userservice.exception.DataNotFoundException;
import com.userservice.mapper.RatingMapper;
import com.userservice.mapper.UserMapper;
import com.userservice.model.Rating;
import com.userservice.model.User;
import com.userservice.repository.UserRespository;
import com.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    RatingService ratingService;

    @Autowired
    RatingMapper ratingMapper;

    @Autowired
    private UserRespository userRespository;

    /**
     * @return
     */
    @Override
    public ResponseEntity<List<UserResponseDto>> fetchAllUser() {
        List<UserResponseDto> users = userRespository.findAll()
                .stream()
                .map(user -> userMapper.userToUserResponseDto(user))
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    /**
     * @param userRequestDto
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity<UserResponseDto> saveUser(UserRequestDto userRequestDto) {
        logger.info("user data----------------------------: {}", userRequestDto);
        User user = userMapper.userRequestDtoToUser(userRequestDto);
        logger.info("user data after mapper------------: {}", userRequestDto);

        User savedUser = userRespository.save(user);
        logger.info("savedUser------------: {}", savedUser);
        return ResponseEntity.ok(userMapper.userToUserResponseDto(savedUser));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<UserResponseDto> fetchUserById(Long id) {
        Optional<User> userDta = userRespository.findById(id);
        if(userDta.isPresent())
        {
            Long userId = userDta.get().getId();
            ResponseEntity<List<RatingResponseDto>> ratingByUserId = ratingService.getRatingByUserId(userId);
            List<RatingResponseDto> ratings = ratingByUserId.getBody();
            List<Rating> newRatings = ratings.stream().map(ratingResponseDto ->
            {

                Rating rating = ratingMapper.ratingResponseDtoToRating(ratingResponseDto);
                logger.info("rating:{}",rating);
                return rating;
            }).collect(Collectors.toList());
           if(!newRatings.isEmpty())
            userDta.get().setRatings(newRatings);
             logger.info("newRatings ********************* :{}", newRatings);
            return ResponseEntity.ok(userMapper.userToUserResponseDto(userDta.get()));
        }else {
            throw new DataNotFoundException("User Not Found!");
        }
    }

    /**
     * @param id
     * @param userRequestDto
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity<UserResponseDto> editUser(Long id, UserRequestDto userRequestDto) {
        Optional<User> userDta = userRespository.findById(id);
        if(userDta.isPresent())
        {
            User userData=new User();
            userData.setEmail(userRequestDto.getEmail());
            userData.setName(userRequestDto.getName());
            userData.setPhone(userRequestDto.getPhone());
            User saveUser = userRespository.save(userData);
            return ResponseEntity.ok(userMapper.userToUserResponseDto(saveUser));

        }else {
            throw new DataNotFoundException("User Not Found!");
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Boolean> deleteUser(Long id) {
        Optional<User> userDta = userRespository.findById(id);
        if(userDta.isPresent())
        {
             userRespository.deleteById(id);
             return ResponseEntity.ok(true);
        }else {
            throw new DataNotFoundException("User Not Found!");
        }
    }
}
