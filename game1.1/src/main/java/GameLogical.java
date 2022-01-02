import java.util.*;

/**
 * @version: V1.0
 * @author: FarSight
 * @className: GameLogical
 * @packageName: PACKAGE_NAME
 * @description: 游戏中逻辑判断
 * @data: 2021-12-31 14:16
 **/


public class GameLogical {

    static {
        DealCards.getCards();
    }

    static HashMap<Integer,LinkedList<Integer>> playerIndex=new HashMap<>();
    static HashMap<String,String> cardsToSize =new HashMap<>();
    static HashMap<String,Integer> cardsToIndex =new HashMap<>();
    static HashMap<Integer,String> indexToCards = DealCards.poker;



    //初始化三个手牌以及底牌
    static {
        LinkedList<Integer> player1Index= DealCards.player1Index;
        LinkedList<Integer> player2Index= DealCards.player2Index;
        LinkedList<Integer> player3Index= DealCards.player3Index;

        //玩家对应的出牌顺序
        playerIndex.put(1,player1Index);
        playerIndex.put(2,player2Index);
        playerIndex.put(3,player3Index);
    }



    //创建一个牌面对应大小的map
    static {
        DealCards.getCards();
        List<String> pokerIndex= new ArrayList<String>(Arrays.asList("a","b","c","d","e","f","g","h","i"
                ,"j","k","l","m","n","o"));
        //nums是牌面的数值
        ArrayList<String> allCards= DealCards.nums;

        for (int i =0 ; i <= 12; i++) {
            cardsToSize.put(allCards.get(i),pokerIndex.get(i));
        }
        cardsToSize.put("小王","n");
        cardsToSize.put("大王","o");
    }

    //创建一个牌对应索引的map
    static {
        DealCards.getCards();
        ArrayList<String> allCards = DealCards.allCards;
        for (int i = 0; i < 54; i++) {
            cardsToIndex.put(allCards.get(i),i);
        }

    }

    /**
    * @param cards:
    * @return: java.lang.String
    * @author: FarSight
    * @date: 2021/12/31 19:43
    * @description: 将用户的牌抽象为一组数字，以方便判断牌的类型
    */
    public String classifyCards(String cards){
        String cardOnlyNum="";
        if (cards.equals("小王大王")){
            return "no";
        }
        if (cards.equals("小王")){
            return "n";
        }
        if (cards.equals("大王")){
            return "o";
        }
        //将牌对应的数字取出来
        for (int i = 0; i < cards.length()-1; i=i+2) {
            String card=cards.substring(i+1,i+2);
            cardOnlyNum=cardOnlyNum+card;
        }
        return cardOnlyNum;

    }

    /**
    * @param cardOnlyNum:
    * @return: java.lang.String
    * @author: FarSight
    * @date: 2021/12/31 14:19
    * @description: 判断出的牌是哪种类型
    */
    public String classify(String cardOnlyNum){
        if (cardOnlyNum.equals("no")){
            return "王炸";
        }return "";
    }

    /**

    * @return: boolean
    * @author: FarSight
    * @date: 2021/12/31 14:22
    * @description: 判断是否压牌成功
    */
    public boolean ruff(){
        return true;
    }



    /**
    * @param index:
    * @return: java.util.LinkedList<java.lang.Integer>
    * @author: FarSight
    * @date: 2021/12/31 19:11
    * @description: 根据索引值判断谁出牌
    */
    public LinkedList<Integer> whoCard(int index){
        LinkedList<Integer> poker =playerIndex.get(index);
        return poker;
    }

    /**
    * @param index1:
    * @return: void
    * @author: FarSight
    * @date: 2021/12/31 19:10
    * @description: 将最后一次出牌的用户的索引值赋给该函数，该函数将自动重新分配出牌顺序
    */
    public void setIndex(int index1){
        LinkedList<Integer> player1=playerIndex.get(index1);
        int index2;
        int index3;
        if(index1+1>3){
            index2 = index1+1-3;
        }else {
            index2 = index1+1;
        }
        if(index1+2>3){
            index3  = index1+2-3;
        }else {
            index3= index1+2;
        }
        LinkedList<Integer> player2=playerIndex.get(index2);
        LinkedList<Integer> player3=playerIndex.get(index3);
        playerIndex.replace(1,player1);
        playerIndex.replace(2,player2);
        playerIndex.replace(3,player3);

    }

    /**
    * @param poker:
    * @return: void
    * @author: FarSight
    * @date: 2021/12/31 19:10
    * @description: 将底牌发给地主
    */
    public static void addAce(LinkedList<Integer> poker){
        for(Integer index : DealCards.aceIndex){
            poker.add(index);
        }
        Collections.sort(poker);

    }


    /**
    * @param list:
    * @return: java.util.LinkedList<java.lang.String>
    * @author: FarSight
    * @date: 2021/12/31 19:09
    * @description: 讲索引转化为牌呈现给用户
    */
    public LinkedList<String> toCards(LinkedList<Integer> list) {
        LinkedList<String> cards=new LinkedList<>();
        for (Integer index : list) {
            String card = DealCards.poker.get(index);
            cards.add(card);
        }
        return cards;
    }

    /**
    * @param cards:
    * @return: java.util.ArrayList<java.lang.Integer>
    * @author: FarSight
    * @date: 2022/1/2 14:42
    * @description: 将玩家输入的牌面转化为索引集
    */
    public ArrayList<Integer> cardsToIndex(String cards){
        ArrayList<Integer> indexList=new ArrayList<>();
        for (int i = 0; i <= cards.length()-2; i=i+2) {
            String card=cards.substring(i,i+2);
            int index=cardsToIndex.get(card);
            indexList.add(index);
        }
        return indexList;
    }


    /**
    * @param playerIndex:
     * @param list:
    * @return: java.util.LinkedList<java.lang.Integer>
    * @author: FarSight
    * @date: 2022/1/2 14:43
    * @description: 将玩家出的牌从手牌索引中删除
    */
    public LinkedList<Integer> deleteCards(int playerIndex,ArrayList<Integer> list){
        LinkedList<Integer> poker =whoCard(playerIndex);
        for(Object index:list){
            poker.remove(index);
        }
        return poker;
    }

}
