import java.io.InputStream;
import java.util.*;

/**
 * @version: V1.0
 * @author: FarSight
 * @className: GameControl
 * @packageName: PACKAGE_NAME
 * @description: 游戏流程控制
 * @data: 2021-12-31 13:47
 **/

public class GameControl {

    Scanner scanner =new Scanner(System.in);
    Random random =new Random();

    GameLogical gameLogical = new GameLogical();

    boolean boutGoOn=true;
    boolean GameGoOn=true;

    /**

    * @return: void
    * @author: FarSight
    * @date: 2021/12/31 18:57
    * @description: 第一回合，玩家叫地主，发底牌给地主
    */
    public void firstBout(){
        //随机抽一名玩家开始第一回合
        int index=(random.nextInt(3))+1;
        gameLogical.setIndex(index);
        boolean firstBoutGoOn=true;
        while (firstBoutGoOn){
            //当前显示的牌组
            LinkedList<Integer> poker = new LinkedList<>();
            //要显示谁的牌组
            poker=gameLogical.whoCard(index);

            System.out.println();
            //用户看到的牌
            LinkedList<String> pokerUser= gameLogical.toCards(poker);
            System.out.println(pokerUser);
            System.out.println("是否叫地主");
            String yesOrNo=scanner.nextLine();
            boolean banker= banker(yesOrNo);
            if (banker){
                gameLogical.setIndex(index);
                gameLogical.addAce(poker);
                firstBoutGoOn=false;
                break;
            }
            index++;
            //保证一直在1，2，3之间循环
            if (index==4){
                index=1;
            }
        }
    }



//    /**
//
//    * @return: void
//    * @author: FarSight
//    * @date: 2021/12/31 17:12
//    * @description: 游戏回合，一旦有人要不起，退出此次循环，记录下当前玩家的索引
//    */
//    public void gameBout(){
//        int index=1;
//        while (boutGoOn){
//            //当前显示的牌组
//            LinkedList<Integer> poker =gameLogical.whoCard(index);
//
//            System.out.println(gameLogical.toCards(poker));
//            System.out.println("请出牌");
//            String cards=scanner.nextLine();
//            ArrayList<Integer> indexList= gameLogical.cardsToIndex(cards);
//            gameLogical.deleteCards(index,indexList);
//
//            //该玩家不出牌
//            if (cards=="N"){
//                boutGoOn=false;
//                break;
//            }
//
//            index++;
//            //保证一直在1，2，3之间循环
//            if (index==4){
//                index=1;
//            }
//        }
//    }


    //不考虑出牌合法性时的测试
    public void gameBout(){
        int index=1;
        while (boutGoOn){
            //当前显示的牌组
            LinkedList<Integer> poker =gameLogical.whoCard(index);

            System.out.println(gameLogical.toCards(poker));
            System.out.println("请出牌");
            String cards=scanner.nextLine();
            ArrayList<Integer> indexList= gameLogical.cardsToIndex(cards);
            poker=gameLogical.deleteCards(index,indexList);
            int cardsNum=poker.size();

            //该玩家出完了所有牌
            if (cardsNum==0){
                boutGoOn=false;
                break;
            }

            index++;
            //保证一直在1，2，3之间循环
            if (index==4){
                index=1;
            }
        }
    }


    /**

    * @return: boolean
    * @author: FarSight
    * @date: 2021/12/31 15:46
    * @description: 判断叫地主
    */
    public boolean banker(String yesOrNo){
        if(yesOrNo.equals("Y")){
            return true;
        }
        if (yesOrNo.equals("N")){
        }
        return false;
    }




}
