

import java.util.*;


public class DealCards {
    //牌和牌的索引
    static HashMap<Integer, String> poker= new HashMap<>();
    //为了判断牌的大小，创建一个索引值
    static int index=0;
    //在显示给用户之前，所有牌都应该是索引值
    static ArrayList<Integer> pokerIndex = new ArrayList<>();


    //全部的牌
    static ArrayList<String> allCards = new ArrayList<>();
    //三个玩家的手牌索引值
    static LinkedList<Integer> player1Index =new LinkedList<>();
    static LinkedList<Integer> player2Index =new LinkedList<>();
    static LinkedList<Integer> player3Index =new LinkedList<>();
    //三个玩家的手牌
    static LinkedList<String> player1Card=new LinkedList<>();
    static LinkedList<String> player2Card=new LinkedList<>();
    static LinkedList<String> player3Card=new LinkedList<>();
    //三只底牌索引值
    static ArrayList<Integer> aceIndex = new ArrayList<>();
    //三只底牌
    static LinkedList<String> aceCard=new LinkedList<>();

    //花色
    static ArrayList<String> colors = new ArrayList<>();
    //数值
    static ArrayList<String> nums = new ArrayList<>();

    /**

    * @return: java.util.ArrayList<java.lang.Integer>
    * @author: FarSight
    * @date: 2021/12/31 15:32
    * @description: 将牌组创建，牌与索引值一一对应，讲所有牌的索引值创建
    */
    public static ArrayList<Integer> getCards()  {



        colors.add("♦");
        colors.add("♥");
        colors.add("♣");
        colors.add("♠");

        for (int i = 3; i <=9 ; i++) {
            nums.add(String.valueOf(i));
        }
        nums.add("T");
        nums.add("J");
        nums.add("Q");
        nums.add("K");
        nums.add("A");
        nums.add("2");

        //组合成一套52只牌的牌组
        for (String num:nums){
            for (String color : colors){
                allCards.add(color+num);
                poker.put(index,color+num);
                index++;
            }
        }

        //添加双王
        allCards.add("小王");
        poker.put(index,"小王");
        index++;
        allCards.add("大王");
        poker.put(index,"大王");
        index++;

        for (int i = 0; i < 54; i++) {
            pokerIndex.add(i);
        }
        return pokerIndex;
    }


    /**

    * @return: java.util.ArrayList<java.lang.Integer>
    * @author: FarSight
    * @date: 2021/12/31 15:14
    * @description: 获得已经被打乱的牌的索引
    */
    public static ArrayList<Integer> shuffle(){
        Random random = new Random();
        ArrayList<Integer> allCards = getCards();
        for (int i = 0; i < allCards.size(); i++) {
            Collections.swap(allCards,i,random.nextInt(53));
        }
        return allCards;
    }

    /**

    * @return: void
    * @author: FarSight
    * @date: 2021/12/31 14:13
    * @description: 发牌
    */
    public static void giveCards(){
        //获得一副打乱的牌
        ArrayList<Integer> allCards = shuffle();
        /*
        发三个玩家基础手牌
        轮流发，每次发一张
         */
        for (int i = 0; i < 51; i++) {
            Integer card =allCards.get(i);
            if(i%3==0){
                player1Index.add(card);
            }
            if(i%3==1){
                player2Index.add(card);
            }
            if(i%3==2){
                player3Index.add(card);
            }
        }
        //发底牌
        for (int i = 51; i < 54; i++) {
            aceIndex.add(getCards().get(i));
        }


        Collections.sort(player1Index);
        Collections.sort(player2Index);
        Collections.sort(player3Index);
        Collections.sort(aceIndex);

        //讲索引值转化为牌
        for(Integer index: player1Index){
            String card=poker.get(index);
            player1Card.add(card);
        }
        for(Integer index: player2Index){
            String card=poker.get(index);
            player2Card.add(card);
        }
        for(Integer index: player3Index){
            String card=poker.get(index);
            player3Card.add(card);
        }
        for(Integer index: aceIndex){
            String card=poker.get(index);
            aceCard.add(card);
        }
    }

}