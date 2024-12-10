package com.folder.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.folder.app.dao.UserDao;
import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

    private ResultDTO rDto;

    @Autowired
    UserDao uDao;

    public ResultDTO findAll() {
        rDto = new ResultDTO();
        List<UserDTO> resultList = uDao.findAll();
        if (resultList != null) {
            rDto.setState(true);
            rDto.setResult(resultList);
        } else {
            rDto.setState(false);
        }
        return rDto;
    }

    public ResultDTO findById(int no) {
        rDto = new ResultDTO();
        UserDTO result = uDao.findById(no);
        if (result != null) {
            rDto.setState(true);
            rDto.setResult(result);
        } else {
            rDto.setState(false);
        }
        return rDto;
    }

    public ResultDTO editByID(UserDTO uDto) {
        rDto = new ResultDTO();
        int state = uDao.editById(uDto);
        if (state == 1) {
            rDto.setState(true);
            rDto.setMessage("사용자 수정이 [성공] 하였습니다.");
        } else {
            rDto.setState(false);
            rDto.setMessage("사용자 수정이 [실패] 하였습니다.");
        }
        return rDto;
    }

    public ResultDTO delete(int no) {
        rDto = new ResultDTO();
        int state = uDao.delete(no);
        if (state == 1) {
            rDto.setState(true);
            rDto.setMessage("사용자 삭제가 [성공] 하였습니다.");
        } else {
            rDto.setState(false);
            rDto.setMessage("사용자 삭제가 [실패] 하였습니다.");
        }
        return rDto;
    }

    public ResultDTO save(UserDTO uDto) {
        rDto = new ResultDTO();
        int result = uDao.save(uDto);
        if (result > 0) {
            UserDTO userDTO = uDao.findById(uDto.getNo());
            rDto.setResult(userDTO);
            rDto.setState(true);
            rDto.setMessage("사용자 생성이 [성공] 하였습니다.");
        } else {
            rDto.setState(false);
            rDto.setMessage("사용자 생성이 [실패] 하였습니다.");
        }
        System.out.println("rDto의 값");
        System.out.println(rDto);
        return rDto;
    }
}
