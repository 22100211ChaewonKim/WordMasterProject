package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    ArrayList<Word> list;
    Scanner s;

    WordCRUD (Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }

    @Override
    public Object add() {
        //사용자에게 입력받는
        System.out.print("=> 난이도 (1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt(); //난이도 입력받기
        String word = s.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();


        return new Word(0, level, word, meaning);
    }

    public void addItem() {
        //데이타를 리스트에 추가하는 부분
        // wordmanager에서 호출할 함수
        Word one = (Word)add();
        list.add(one);
        System.out.println("♥︎ 알림 ♥︎: 새 단어가 단어장에 추가되었습니다. \n");
    }

    @Override
    public int update(Object obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Object obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void selectOne(int id) {
        // TODO Auto-generated method stub

    }

    public void listAll() {
        System.out.println("\n♡--- 채원이의 작고 소중한 단어장 ---♡");
        System.out.println("------------------------------");
        for(int i = 0; i < list.size(); i++) {
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("------------------------------\n\n");
    }

    //데이타 수정
    public ArrayList<Integer> listAll(String keyword) {
        ArrayList<Integer> idlist = new ArrayList<>();
        int j = 0;

        System.out.println("\n♡--- 채원이의 작고 소중한 단어장 ---♡");
        System.out.println("------------------------------");
        for(int i = 0; i < list.size(); i++) {
            String word = list.get(i).getWord();
            if (!word.contains(keyword)) continue;
            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("------------------------------\n\n");

        return idlist;
    }

    public void updateItem(){
        System.out.print("=> 수정할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);

        System.out.print("=> 수정할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1)); //왜 +1아니고 -1이지?
        word.setMeaning(meaning);
        System.out.println("♥︎ 알림 ♥︎: 단어가 수정 되었습니다.");
    }

    //데이타 삭제

    public void deleteItem() {
        System.out.print("=> 삭제할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);

        System.out.print("=> 삭제할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("=> 정말로 삭제하시겠습니까?(Y/N) : ");
        String ans = s.next();
        if (ans.equalsIgnoreCase("y")) {
            list.remove((int)idlist.get(id - 1));
            System.out.println("♥︎ 알림 ♥︎: 단어가 삭제 되었습니다.");
        } else
            System.out.println("취소 되었습니다.");
    }


}
