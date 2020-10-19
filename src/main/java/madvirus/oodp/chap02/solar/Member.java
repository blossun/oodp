package madvirus.oodp.chap02.solar;

import java.util.Date;

public class Member {
    private Date expiryDate;
    private boolean male;

    public boolean isExpired() { // 만료 여부 확인 구현을 캡슐화
        return expiryDate != null
                && expiryDate.getDate() < System.currentTimeMillis();
    }
}

