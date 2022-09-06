package org.example;

public interface ICRUD {
    public Object add(); //데이타 추가할 때 사용
    public int update(Object obj); //수정
    public int delete(Object obj); //삭제
    public void selectOne(int id); //데이타 한 개 조회할 때 사용 (해당하는 id에 대해서 출력할 수 잇도록)
}
