package com.ll.exam.response;

public class ResponseModify extends Response{
    int id=-1;

    public ResponseModify(boolean isSuc,int id) {
        this.isSuccess = isSuc;
        this.id = id;
    }

    @Override
    public void message() {
        if(!isSuccess){
            if(id==0){
                System.out.println("번호를 입력해주세요.");
            }
            else{
                System.out.println(id+"번 명언은 존재하지 않습니다.");
            }
        }
        else{
            System.out.println(id+"번 명언이 수정되었습니다.\n");
        }
    }
}
