package com.team03.Ohfifthlane_back.dto;

import com.team03.Ohfifthlane_back.vo.AccountVO;
import com.team03.Ohfifthlane_back.vo.UserVO;

public class RegisterDTO {

	private AccountVO account;
    private UserVO user;

    // 기본 생성자
    public RegisterDTO() {
    	
    }

    // Getter와 Setter
    public AccountVO getAccount() {
        return account;
    }

    public void setAccount(AccountVO account) {
        this.account = account;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }
}

