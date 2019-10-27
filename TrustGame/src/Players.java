import java.util.Scanner;

public class Players {
    int player0;
    int player1;
    int deceive;//欺骗数
    int times;//回合数

    //一号玩家：全部相信
    public void player1(){
        player1=1;
    }
    //二号玩家：全部欺骗
    public void player2(){
        player1=0;
    }
    //三号玩家：相信-欺骗-相信交替
    public void player3(){
        if(times%2==1){
            player1=1;
        }else {
            player1=0;
        }
    }
    //四号玩家：欺骗-相信-欺骗交替
    public void player4(){
        if(times%2==0){
            player1=1;
        }else {
            player1=0;
        }
    }
    //五号玩家：随机
    public void player5(){
        player1=(int)(Math.random()*2);
    }
    //六号玩家：第一次相信，之后重复玩家前一次的选择
    public void player6(){
        if(times==1){
            player1=1;
        }else {                                    //这里就要求电脑必须比玩家先做出选择
            player1=player0;
        }
    }
    //七号玩家：第一次相信，若出现欺骗则之后全为欺骗
    public void player7(){
        if(player0==0){
            deceive=1;
        }
        if(times==1){
            player1=1;
        }
        if(deceive==1){
            player1=0;
        }else {
            player1=1;
        }
    }
    //八号玩家：第一次相信，若两次欺骗则全为欺骗
    public void player8(){
        if(player0==0){
            deceive=deceive+1;
        }
        if(times==1){
            player1=1;
        }
        if(deceive>=2){
            player1=0;
        }else {
            player1=1;
        }
    }

    //玩家
    public void player0() {
        System.out.print("请选择合作（1）/欺骗（0）：");
        Scanner a = new Scanner(System.in);
        player0 = a.nextInt();
    }

    public int getPlayer0(){
        return player0;
    }
    public int getPlayer1(){
        return player1;
    }

}
