package com.example.ecology2048;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    ImageView[][] grid;
    private int[][] intGrid;
    Map<Integer, Integer> map;
    int n=5;
    int max_tile =2;
    public void setGrid()
    {
        grid = new ImageView[n][n];
        grid[0][0] = (ImageView)findViewById(R.id.element1);
        grid[0][1] = (ImageView)findViewById(R.id.element2);
        grid[0][2] = (ImageView)findViewById(R.id.element3);
        grid[0][3] = (ImageView)findViewById(R.id.element4);
        grid[0][4] = (ImageView)findViewById(R.id.element5);
        grid[1][0] = (ImageView)findViewById(R.id.element6);
        grid[1][1] = (ImageView)findViewById(R.id.element7);
        grid[1][2] = (ImageView)findViewById(R.id.element8);
        grid[1][3] = (ImageView)findViewById(R.id.element9);
        grid[1][4] = (ImageView)findViewById(R.id.element10);
        grid[2][0] = (ImageView)findViewById(R.id.element11);
        grid[2][1] = (ImageView)findViewById(R.id.element12);
        grid[2][2] = (ImageView)findViewById(R.id.element13);
        grid[2][3] = (ImageView)findViewById(R.id.element14);
        grid[2][4] = (ImageView)findViewById(R.id.element15);
        grid[3][0] = (ImageView)findViewById(R.id.element16);
        grid[3][1] = (ImageView)findViewById(R.id.element17);
        grid[3][2] = (ImageView)findViewById(R.id.element18);
        grid[3][3] = (ImageView)findViewById(R.id.element19);
        grid[3][4] = (ImageView)findViewById(R.id.element20);
        grid[4][0] = (ImageView)findViewById(R.id.element21);
        grid[4][1] = (ImageView)findViewById(R.id.element22);
        grid[4][2] = (ImageView)findViewById(R.id.element23);
        grid[4][3] = (ImageView)findViewById(R.id.element24);
        grid[4][4] = (ImageView)findViewById(R.id.element25);
        map = new HashMap<>();
        map.put(2, R.drawable.i2_2);
        map.put(4, R.drawable.i2_4);
        map.put(8, R.drawable.i2_8);
        map.put(16, R.drawable.i2_16);
        map.put(32, R.drawable.i2_32);
        map.put(64, R.drawable.i2_64);
        map.put(128, R.drawable.recycle);


        intGrid=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                intGrid[i][j]=0;
            }
        }

    }
    private final int power=7;
    //
    private int score=0;
    int get_score()
    {
        return this.score;
    }
    //
    private boolean check_full()
    {
        boolean c = true;
        for(int i = 0 ; i < this.grid.length ; i++)
        {
            for(int j = 0 ; j < this.grid[i].length ; j++)
            {
                if (this.intGrid[i][j] == 0) {
                    c = false;
                    break;
                }
            }
        }
        return c;
    }
    void random_2()
    {
        if(!check_full())
        {
            int i,j;
            do
            {
                i = ((int)(Math.random()*1000))%this.intGrid.length;
                j = ((int)(Math.random()*1000))%this.intGrid[0].length;
            }
            while(this.intGrid[i][j] != 0);
            //
            this.intGrid[i][j] = 2;
            this.grid[i][j].setImageResource(map.get(2));
        }
    }
    public int max()
    {
        Log.d("Visiting max function", "Visited");
        int max = 0;
        //
        int i,j;
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(intGrid[i][j]>max)
                    max = intGrid[i][j];
            }
        }
        //
        max_tile=max;
        return max;
    }
    boolean check_end_w()
    {
        int maximum = max();
        return  128== maximum;
    }
    boolean can_up()
    {
        boolean c = false;
        //
        for(int i = 1 ; i < this.intGrid.length ; i++)
        {
            for(int j = 0 ; j < this.intGrid[i].length ; j++)
            {
                if((this.intGrid[i][j] != 0)&&((this.intGrid[i-1][j] == 0)||(this.intGrid[i-1][j] == this.intGrid[i][j])))
                {
                    c = true;
                    break;
                }
            }
        }
        //
        return c;
    }
    boolean can_down()
    {
        boolean c = false;
        //
        for(int i = 0 ; i < this.intGrid.length-1 ; i++)
        {
            for(int j = 0 ; j < this.intGrid[i].length ; j++)
            {
                if((this.intGrid[i][j] != 0)&&((this.intGrid[i+1][j] == 0)||(this.intGrid[i+1][j] == this.intGrid[i][j])))
                {
                    c = true;
                    break;
                }
            }
        }
        //
        return c;
    }
    boolean can_left()
    {
        boolean c = false;
        //
        for (int[] ints : this.intGrid) {
            for (int j = 1; j < ints.length; j++) {
                if ((ints[j] != 0) && ((ints[j - 1] == 0) || (ints[j - 1] == ints[j]))) {
                    c = true;
                    break;
                }
            }
        }
        //
        return c;
    }
    boolean can_right()
    {
        boolean c = false;
        //
        for (int[] ints : this.intGrid) {
            for (int j = 0; j < ints.length - 1; j++) {
                if ((ints[j] != 0) && ((ints[j + 1] == 0) || (ints[j + 1] == ints[j]))) {
                    c = true;
                    break;
                }
            }
        }
        //
        return c;
    }

    void up()
    {
        for(int j = 0 ; j < this.intGrid[0].length ; j++)
        {
            for(int i = 0 ; i < this.intGrid.length ; i++)
            {
                if(this.intGrid[i][j] != 0)
                {
                    for(int c = i ; c > 0 ; c--)
                    {
                        if(this.intGrid[c-1][j] == 0)
                        {
                            this.intGrid[c-1][j] = this.intGrid[c][j];
                            this.grid[c-1][j].setImageResource(map.get(this.intGrid[c-1][j]));
                            this.intGrid[c][j] = 0;
                            this.grid[c][j].setImageResource(R.drawable.background);
                        }
                        else if(this.intGrid[c-1][j] == this.intGrid[c][j])
                        {
                            this.intGrid[c-1][j] += this.intGrid[c][j];
                            this.grid[c-1][j].setImageResource(map.get(this.intGrid[c-1][j]));
                            this.intGrid[c][j] = 0;
                            this.grid[c][j].setImageResource(R.drawable.background);
                            this.score += this.intGrid[c-1][j];
                            break;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }
        }
    }
    void down()
    {
        for(int j = 0 ; j < this.intGrid[0].length ; j++)
        {
            for(int i = this.intGrid.length-1 ; i >= 0 ; i--)
            {
                if(this.intGrid[i][j] != 0)
                {
                    for(int c = i ; c < this.intGrid.length-1 ; c++)
                    {
                        if(this.intGrid[c+1][j] == 0)
                        {
                            this.intGrid[c+1][j] = this.intGrid[c][j];
                            this.grid[c+1][j].setImageResource(map.get(this.intGrid[c+1][j]));
                            this.intGrid[c][j] = 0;
                            this.grid[c][j].setImageResource(R.drawable.background);
                        }
                        else if(this.intGrid[c+1][j] == this.intGrid[c][j])
                        {
                            this.intGrid[c+1][j] += this.intGrid[c][j];
                            this.grid[c+1][j].setImageResource(map.get(this.intGrid[c+1][j]));
                            this.intGrid[c][j] = 0;
                            this.grid[c][j].setImageResource(R.drawable.background);
                            this.score += this.intGrid[c+1][j];
                            break;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }
        }
    }
    void left()
    {
        for(int i = 0 ; i < this.intGrid.length ; i++)
        {
            for(int j = 0 ; j < this.intGrid[i].length ; j++)
            {
                if(this.intGrid[i][j] != 0)
                {
                    for(int c = j ; c > 0 ; c--)
                    {
                        if(this.intGrid[i][c-1] == 0)
                        {
                            this.intGrid[i][c-1] = this.intGrid[i][c];
                            this.grid[i][c-1].setImageResource(map.get(this.intGrid[i][c-1]));
                            this.intGrid[i][c] = 0;
                            this.grid[i][c].setImageResource(R.drawable.background);
                        }
                        else if(this.intGrid[i][c-1] == this.intGrid[i][c])
                        {
                            this.intGrid[i][c-1] += this.intGrid[i][c];
                            this.grid[i][c-1].setImageResource(map.get(this.intGrid[i][c-1]));
                            this.intGrid[i][c] = 0;
                            this.grid[i][c].setImageResource(R.drawable.background);
                            this.score += this.intGrid[i][c-1];
                            break;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }
        }
    }
    void right()
    {
        for(int i = 0 ; i < this.intGrid.length ; i++)
        {
            for(int j = this.intGrid[i].length-1 ; j >= 0 ; j--)
            {
                if(this.intGrid[i][j] != 0)
                {
                    for(int c = j ; c < this.intGrid[i].length-1 ; c++)
                    {
                        if(this.intGrid[i][c+1] == 0)
                        {
                            this.intGrid[i][c+1] = this.intGrid[i][c];
                            this.grid[i][c+1].setImageResource(map.get(this.intGrid[i][c+1]));
                            this.intGrid[i][c] = 0;
                            this.grid[i][c].setImageResource(R.drawable.background);
                        }
                        else if(this.intGrid[i][c+1] == this.intGrid[i][c])
                        {
                            this.intGrid[i][c+1] += this.intGrid[i][c];
                            this.grid[i][c+1].setImageResource(map.get(this.intGrid[i][c+1]));
                            this.intGrid[i][c] = 0;
                            this.grid[i][c].setImageResource(R.drawable.background);
                            this.score += this.intGrid[i][c+1];
                            break;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }
        }
    }
    boolean check_end_l()
    {
        if(check_full())
        {
            return !(can_up()||can_down()||can_left()||can_right());
        }
        else
        {
            return false;
        }
    }
    void setLoseImage()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j].setImageResource(R.drawable.gameover);
                intGrid[i][j] = 0;
            }
        }
    }
    void setWinImage()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i%2==0)
                grid[i][j].setImageResource(R.drawable.win);
                else
                    grid[i][j].setImageResource(R.drawable.recycle);
                intGrid[i][j] = 0;
            }
        }
    }
    void resetGrid()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j].setImageResource(R.drawable.background);
                intGrid[i][j]=0;
            }
        }
        random_2();
        max_tile=2;
        score=0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setGrid();
//        grid[0][0].setImageResource(map.get(2));
//        grid[0][1].setImageResource(map.get(4));
//        grid[0][2].setImageResource(map.get(8));
//        grid[0][3].setImageResource(map.get(16));
//        grid[0][4].setImageResource(map.get(16));
        random_2();
        Button right = (Button)findViewById(R.id.right);
        Button left = (Button)findViewById(R.id.left);
        Button down = (Button)findViewById(R.id.down);
        Button upButton = (Button)findViewById(R.id.upbutton);
        Button refresh = (Button)findViewById(R.id.refresh);
        TextView text = (TextView)findViewById(R.id.textView);
        String toDisplay = "Score "+score;
        text.setText(toDisplay);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(can_right())
                {
                    right();
                    random_2();
                }
                max();
                String toDisplay ="Score "+score;
                text.setText(toDisplay);
                if(check_end_l())
                {
                    setLoseImage();
                }
                //
                if(check_end_w())
                {
//            print();
                    setWinImage();
//                    System.out.println("You WIN");

                }

            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(can_left())
                {
                    left();
                    random_2();
                }
                max();
                String toDisplay = "Score "+score;
                text.setText(toDisplay);
                if(check_end_l())
                {
                    setLoseImage();
                }
                //
                if(check_end_w())
                {
//            print();
                    setWinImage();
//                    System.out.println("You WIN");

                }
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(can_down())
                {
                    down();
                    random_2();
                }
                max();
                String toDisplay = "Score "+score;
                text.setText(toDisplay);
                if(check_end_l())
                {
                    setLoseImage();
                }
                //
                if(check_end_w())
                {
//            print();
                    setWinImage();
//                    System.out.println("You WIN");

                }
            }
        });
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(can_up())
                {
                    up();
                    random_2();
                }
                max();
                String toDisplay ="Score "+score;
                text.setText(toDisplay);
                if(check_end_l())
                {
                    setLoseImage();
                }
                //
                if(check_end_w())
                {
//            print();
                    setWinImage();
//                    System.out.println("You WIN");

                }
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGrid();
            }
        });




    }



}