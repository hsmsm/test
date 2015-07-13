package experiment3;

public class KnightTour{                                  
    private int[][] chessboard;                            //��ά�����ʾ���̲����������һ����
    private boolean show;                                  //�Ƿ���ʾ�м���

    //���췽����x��yָ����ʼλ�ã�showָ���Ƿ���ʾ�м���
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

    private class Position{                                 //����һ�����꣬�ڲ���
        int x,y;                                            //�С�������
        //�ڲ���Ĺ��췽��
        Position(int x, int y){                                    
            if (x>=0 && x<8 && y>=0 && y<8){
                this.x=x;
                this.y=y;
            }
            else                                             //��(x,y)�������̣����׳����Խ���쳣
                throw new IndexOutOfBoundsException("x=" + x + "��y=" + y);
        }
        
        Position(){
            this(0, 0);
        }
        
        //�������췽��
        Position(Position p){                               
            this(p.x, p.y);
        }
        
        public String toString(){
            return "(" + this.x + "," + this.y + ")";
        }        
    }

    private void start(int x, int y){                       //��(x,y)��ʼ����
        Position p = new Position(x, y);                   //��ǰλ��
        int count = 1, direction = 1;                      //count��¼������diretion��ʾ8������
        while (count <= 64 && direction != 0){
        	this.chessboard[p.x][p.y] = count;             //����p���ֵΪcount
            if (this.show) 
                System.out.print("��" + count +"��  ");
            direction = this.select(p);                    //Ԥ����ѡ��һ������
            if (direction == 0 && count < 64)
                System.out.println("��" + count + "����·��ͨ!");
            else{
                count++;                                    //������1
                p = this.goaStep(p, direction);             //ǰ��һ�� 
            }
        }
        if (!this.show)
            this.print();
    }

    //Ԥ����Ϊpλ��ѡ����һ��ǰ���ķ�����̽next1��8������λ��next2�Ŀ�ͨ·��road��road����СֵΪminroad
    private int select(Position p){
        if (this.show){
            System.out.println("��ǰλ��: " + p.toString());
            this.print();                                       //�����������Ԫ��
            System.out.println("����   ��һλ��   ��ͨ����     ��ͨ·��");
        }
        int direction = 0, minroad = 8;
        for (int i = 1; i <= 8; i++){                           //��̽λ��p(x,y)��8�������λ��next1
            int road = 0;
            Position next1 = goaStep(p,i);                      //next1��p��i�������һλ��
            if (next1 != null){                                 //next1����������δ�����ʹ�
                 if (this.show)
                     System.out.print("  " + i + "\t" + next1.toString() + "\t");
                 for (int j = 1; j <= 8; j++){                  //ͳ��next1(x,y)�Ŀ�ͨ·��road
                     Position next2 = goaStep(next1,j);         //next2��next1��j�������һλ��
                     if (next2 != null){                        //next2����������δ�����ʹ�
                         road++;   
                         if (this.show)
                             System.out.print(j + ",");
                     }
                 }    
                 if (road < minroad){
                     minroad = road;                            //minroad����road����Сֵ
                     direction = i;                             //direction����road��Сֵ�ķ���
                 }
                 if (this.show)
                     System.out.println("\t" + road);
             }
        }
        if (this.show)
            System.out.println("ѡ����һ������ direction=" + direction + "\r\n");
        return direction;
    }

    //����pλ�ð�direction����ǰ������һλ�ã����ı�pλ��
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
            return new Position(x, y);           //��(x,y)����������δ�����ʹ����򷵻�
        else return null; 
    } 

    private void print(){                                   //�����������Ԫ��
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