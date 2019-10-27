import com.sun.imageio.plugins.wbmp.WBMPImageReader;

import java.util.Scanner;

public class Play {
    int i=1;
    int times;
    private int yourCoins;//玩家硬币数
    private int hisCoins;//系统硬笔数
    private int x;
    private int y;//玩家和电脑的选择（0/1表示）
    private int result;
    private int choose1=(int)(Math.random()*8+1);
    private int choose2=(int)(Math.random()*8+1);

    public class Start{
        Players player0=new Players();
        Players player1=new Players();
        Players player2=new Players();
        int a=0;
        int b=0;
        private int setPlayer1(int m){
            switch (m){
                case 1:
                    a=1;
                break;
                case 2:
                    a=2;
                break;
                case 3:
                    a=3;
                break;
                case 4:
                    a=4;
                break;
                case 5:
                    a=5;
                break;
                case 6:
                    a=6;
                break;
                case 7:
                    a=7;
                break;
                case 8:
                    a=8;
                break;
            }
            return a;
        }
        private int setPlayer2(int m){
            switch (m){
                case 1:
                    b=1;
                    break;
                case 2:
                    b=2;
                    break;
                case 3:
                    b=3;
                    break;
                case 4:
                    b=4;
                    break;
                case 5:
                    b=5;
                    break;
                case 6:
                    b=6;
                    break;
                case 7:
                    b=7;
                    break;
                case 8:
                    b=8;
                    break;
            }
            return b;
        }

        public void chooseGame(){
            System.out.print("请选择参加（1）/观战（2）：");
            int l;
            Scanner n=new Scanner(System.in);
            l=n.nextInt();
            if(l==1){
                play();
            }if(l==2){
                watch();
            }else {
                System.out.println("找不到该模式，请重新开始。");
                chooseGame();
            }
        }

        private void play() {
            System.out.println("为你匹配到"+choose1+"号玩家。");
            setPlayer1(choose1);
            setTimes();
            yourCoins=times;
            hisCoins=times;//玩家初始硬币数为回合数（防止硬币出现负数）
            while (i<=times){
                player1.times=i;
                int b=times;
                System.out.println("times is "+b);
                System.out.println("choose is "+choose1);
                System.out.println("开始第"+i+"回合");
                switch (a){
                    case 1:
                        player1.player1();
                        break;
                    case 2:
                        player1.player2();
                        break;
                    case 3:
                        player1.player3();
                        break;
                    case 4:
                        player1.player4();
                        break;
                    case 5:
                        player1.player5();
                        break;
                    case 6:
                        player1.player6();
                        break;
                    case 7:
                        player1.player7();
                        break;
                    case 8:
                        player1.player8();
                        break;
                }
                player0.player0();
                x=player0.getPlayer0();
                y=player1.getPlayer1();
                showResultPlay();
                result=x+y;
                coins();
                System.out.println("第"+i+"回合结束，你的硬币数是："+yourCoins+"，对方的硬币数是："+hisCoins);
                i=i+1;
            }
            System.out.println("游戏结束。你的硬币数是："+yourCoins+"，对方的硬币数是："+hisCoins);
            if(yourCoins>hisCoins){
                System.out.println("你赢了！");
            }else if(yourCoins<hisCoins){
                System.out.println("你输了！");
            }else {
                System.out.println("平局！");
            }
            restart();
        }

        private void watch(){
            while(choose1==choose2){
                choose2=(int)(Math.random()*8+1);
            }//防止出现相同玩家
            setPlayer1(choose1);
            setPlayer2(choose2);
            System.out.println("匹配到"+choose1+"号和"+choose2+"号玩家。");
            setTimes();
            yourCoins=times;//把Player1当做玩家
            hisCoins=times;
            while (i<=times){
                player1.times=i;
                player2.times=i;
                int c=times;
                System.out.println("times is "+c);
                System.out.println("choose is "+choose1+"and"+choose2);
                System.out.println("开始第"+i+"回合");
                switch (a){
                    case 1:
                        player1.player1();
                        break;
                    case 2:
                        player1.player2();
                        break;
                    case 3:
                        player1.player3();
                        break;
                    case 4:
                        player1.player4();
                        break;
                    case 5:
                        player1.player5();
                        break;
                    case 6:
                        player1.player6();
                        break;
                    case 7:
                        player1.player7();
                        break;
                    case 8:
                        player1.player8();
                        break;
                }
                switch (b){
                    case 1:
                        player2.player1();
                        break;
                    case 2:
                        player2.player2();
                        break;
                    case 3:
                        player2.player3();
                        break;
                    case 4:
                        player2.player4();
                        break;
                    case 5:
                        player2.player5();
                        break;
                    case 6:
                        player2.player6();
                        break;
                    case 7:
                        player2.player7();
                        break;
                    case 8:
                        player2.player8();
                        break;
                }
                x=player1.getPlayer1();
                y=player2.getPlayer1();
                showResultWatch();
                result=x+y;
                coins();
                System.out.println("第"+i+"回合结束，玩家"+choose1+"的硬币数是："+yourCoins+"，玩家"+choose2+"的硬币数是："+hisCoins);
                i=i+1;
            }
            if(yourCoins>hisCoins){
                System.out.println("玩家"+choose1+"赢了！");
            }else if(yourCoins<hisCoins){
                System.out.println("玩家"+choose2+"赢了！");
            }else {
                System.out.println("平局！");
            }
            restart();
        }

        private void restart(){
            i=1;
            choose1=(int)(Math.random()*8+1);
            choose2=(int)(Math.random()*8+1);
            System.out.print("要继续吗？（Y/N）");
            Scanner a=new Scanner(System.in);
            String b=a.nextLine();
            int d;
            if(b.compareTo("Y")==0|b.compareTo("y")==0){
                System.out.print("请选择参加（1）/观战（2）：");
                Scanner c=new Scanner(System.in);
                d=c.nextInt();
                if(d==1){
                    play();
                }if(d==2){
                    watch();
                }else {
                    System.out.println("找不到该模式，请重新开始。");
                    chooseGame();
                }
            }else if(b.compareTo("N")==0|b.compareTo("n")==0){
                System.exit(0);
            }
        }
    }

    private void setTimes(){
        System.out.print("请输入规定回合数（1-10）：");
        Scanner a=new Scanner(System.in);
        times=a.nextInt();
    }

    //获取结果
    private String getResult(int a){
        String result;
        if(a==1){
            result="合作";
        }else {
            result="欺骗";
        }
        return result;
    }

    //展示结果
    private void showResultPlay(){
        System.out.println("你的选择是："+getResult(x));
        System.out.println("对方的选择是："+getResult(y));
    }
    private void showResultWatch(){
        System.out.println("玩家"+choose1+"的选择是："+getResult(x));
        System.out.println("玩家"+choose2+"的选择是："+getResult(y));
    }

    //计算硬币数
    private void coins(){
        if(result==2){//即两人都合作
            yourCoins=yourCoins+3;
            hisCoins=hisCoins+3;
        }else if(result==1){//即只有一人合作
            if(x==1){
                yourCoins=yourCoins-1;
                hisCoins=hisCoins+3;
            }else {
                yourCoins=yourCoins+3;
                hisCoins=hisCoins-1;
            }//剩下情况为两人都不合作，结果不变
        }
    }
}
