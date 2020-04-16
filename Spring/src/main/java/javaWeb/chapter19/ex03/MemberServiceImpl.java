package javaWeb.chapter19.ex03;

import lombok.Data;

public @Data class MemberServiceImpl implements MemberService{

    MemberDAO memberDAO;
    String age;

    @Override
    public void listMembers () {
        memberDAO.listMembers();
    }
}

