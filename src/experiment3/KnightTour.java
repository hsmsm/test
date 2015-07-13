package experiment3;

public class KnightTour{                                  
    private int[][] chessboard;                            //二维数组表示棋盘并保存问题的一个解
    private boolean show;                                  //是否显示中间结果

    //构造方法，x、y指定起始位置，show指定是否显示中间结果
    public KnightTour(int x, int y, boolean show){
        this.chessboard = new int[8][8];                       
        this.show = show;
        this.start(x, y);
    }
    
    public KnightTour(int x, int y){
        this(x, y, false);
    }
    
    public KnightTour(){
        this(0, 0, false);
    }

    private class Position{                                 //棋盘一格坐标，内部类
        int x,y;                                            //行、列坐标
        //内部类的构造方法
        Position(int x, int y){                                    
            if (x>=0 && x<8 && y>=0 && y<8){
                this.x=x;
                this.y=y;
            }
            else                                             //若(x,y)超出棋盘，则抛出序号越界异常
                throw new IndexOutOfBoundsException("x=" + x + "，y=" + y);
        }
        
        Position(){
            this(0, 0);
        }
        
        //拷贝构造方法
        Position(Position p){                               
            this(p.x, p.y);
        }
        
        public String toString(){
            return "(" + this.x + "," + this.y + ")";
        }        
    }

    private void start(int x, int y){                       //从(x,y)格开始游历
        Position p = new Position(x, y);                   //当前位置
        int count = 1, direction = 1;                      //count记录步数，diretion表示8个方向
        while (count <= 64 && direction != 0){
        	this.chessboard[p.x][p.y] = count;             //设置p格的值为count
            if (this.show) 
                System.out.print("第" + count +"步  ");
            direction = this.select(p);                    //预见，选择一个方向
            if (direction == 0 && count < 64)
                System.out.println("第" + count + "步无路可通!");
            else{
                count++;                                    //步数加1
                p = this.goaStep(p, direction);             //前进一步 
            }
        }
        if (!this.show)
            this.print();
    }

    //预见，为p位置选择下一步前进的方向，试探next1的8个方向位置next2的可通路数road，road的最小值为minroad
    private int select(Position p){
        if (this.show){
            System.out.println("当前位置: " + p.toString());
            this.print();                                       //输出棋盘所有元素
            System.out.println("方向   下一位置   可通方向     可通路数");
        }
        int direction = 0, minroad = 8;
        for (int i = 1; i <= 8; i++){                           //试探位置p(x,y)的8个方向的位置next1
            int road = 0;
            Position next1 = goaStep(p,i);                      //next1是p按i方向的下一位置
            if (next1 != null){                                 //next1在棋盘内且未被访问过
                 if (this.show)
                     System.out.print("  " + i + "\t" + next1.toString() + "\t");
                 for (int j = 1; j <= 8; j++){                  //统计next1(x,y)的可通路数road
                     Position next2 = goaStep(next1,j);         //next2是next1按j方向的下一位置
                     if (next2 != null){                        //next2在棋盘内且未被访问过
                         road++;   
                         if (this.show)
                             System.out.print(j + ",");
                     }
                 }    
                 if (road < minroad){
                     minroad = road;                            //minroad记载road的最小值
                     direction = i;                             //direction记载road最小值的方向
                 }
                 if (this.show)
                     System.out.println("\t" + road);
             }
        }
        if (this.show)
            System.out.println("选定下一步方向 direction=" + direction + "\r\n");
        return direction;
    }

    //返回p位置按direction方向前进的下一位置，不改变p位置
    private Position goaStep(final Position p, int direction){
        int x = p.x, y = p.y;
        switch (direction){
            case 1: x-=2;  y++;  break; 
            case 2: x--;   y+=2; break; 
            case 3: x++;   y+=2; break; 
            case 4: x+=2;  y++;  break; 
            case 5: x+=2;  y--;  break; 
            case 6: x++;   y-=2; break; 
            case 7: x--;   y-=2; break; 
            case 8: x-=2;  y--;  break; 
        }
        int n = this.chessboard.length;
        if (x >= 0 && x < n && y >= 0 && y < n && this.chessboard[x][y] == 0)  
            return new Position(x, y);           //若(x,y)在棋盘内且未被访问过，则返回
        else return null; 
    } 

    private void print(){                                   //输出棋盘所有元素
        for (int i = 0; i < this.chessboard.length; i++){
            for (int j = 0; j < this.chessboard.length; j++){
                if (this.chessboard[i][j] >= 0 && this.chessboard[i][j] < 10)
                    System.out.print(" ");
                System.out.print("  " + this.chessboard[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    } 
}