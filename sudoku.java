import java.util.Scanner;

class sudoku {

    int row_num;
    int col_num;
    int grid[][] = new int[100][100];
    int i_pos;
    int j_pos;

    sudoku()
    {

       row_num = 9;
       col_num = 9;
       i_pos = 0;
       j_pos = 0;
    
       
    }
int is_valid()

{

     int val=0;

     for(int i=0;i<this.row_num;i+=1)

     {

          for(int j=0;j<this.col_num;j+=1)

          {
               val = this.grid[i][j];
               if(val==-1)
               {
                   continue;
               }
              
               for(int k=0;k<this.col_num;k+=1)

               {

                   if(val == this.grid[i][k] && j!=k)

                   {

                         return 0;

                   }

              }

              for(int k=0;k<this.row_num;k+=1)

              {

                   if(val == this.grid[k][j] && k!=i)

                   {

                           return 0;

                   }

             }

         }
 
     }

    return 1;

}            
boolean sudoku_solve()
{

          int temp_i_pos=0;
          int temp_j_pos=0;
          boolean result = false;

          if(this.unassigned_cell_finder()==0)
          {
              System.out.print("Sudoku is Solved...");
              return true;
          }

          else
          {
              temp_i_pos = this.i_pos;
              temp_j_pos = this.j_pos;
              for(int num=1;num<10;num+=1)
 
              {

                     if(this.is_safe(num,temp_i_pos,temp_j_pos))
                     {

                             this.grid[temp_i_pos][temp_j_pos]=num;
                             result = this.sudoku_solve();
                             if(result==true)
                             {
                                     break;
                             }
                     }

                     if(result==false)
                     {
                       
                            continue;
                     }

              }

             if(result==true)
            {
                  
                     return true;
            }

            else
            {

                  this.grid[temp_i_pos][temp_j_pos] = -1;
                  return false;
            }
        }

}


int unassigned_cell_finder()
{


           for(int i=0;i<this.row_num;i+=1)
           {
              for(int j=0;j<this.col_num;j+=1)

              {

                   if(this.grid[i][j]==-1)
 
                   {
                         this.i_pos = i;
                         this.j_pos = j; 
                         return(1);
                   }
              }
           }

           return(0);
}

boolean is_safe(int num, int i_pos1, int j_pos1)
{

      int row = i_pos1;
      int column = j_pos1;
      int start_row = 0;
      int start_column = 0;

      for(int i=0;i<9;i+=1)
 
      {
       
             if(this.grid[row][i]==num && i!=column)

             {

                   return false;

             }
             

      }

      for(int i=0;i<9;i+=1)

      {

              if(this.grid[i][column]==num && i!=row)

              {

                   return false;

              }

      }
     
     if(i_pos1 == 0 || i_pos1 == 3 || i_pos1 == 6)

     {

          start_row = i_pos1;
     }

     else if((i_pos1+1)%3==0)

     {

           start_row = i_pos1-2;
     
     }

     else

     {

          start_row = i_pos1-1;

     }

  
     if(j_pos1==0 || j_pos1 == 3 || j_pos1 == 6)

     {

         start_column = j_pos1;

     }

     else if((j_pos1+1)%3==0)
 
     {

          start_column = j_pos1-2;

     }

     else

     {

          start_column = j_pos1-1;

     }
          


     for(int i=start_row;i<start_row+3;i+=1)

     {

             for(int j=start_column;j<start_column+3;j+=1)
  
          {
                                                                                                                                                                                              

               

                if(this.grid[i][j] == num)

                  {

                          if(i==i_pos1 && j == j_pos1)

                          {
                                 continue;

                          }

                         else

                          {

                                return false;

                          }
                  }
             
           }

    }

     return true;

}
      
  
public static void main(String args[])

{
     boolean result;
     
     int res;
    
     sudoku s = new sudoku();

     System.out.println("Please enter a 9*9 sudoku array: Please enter \"-1\" for blank cells and the number strictly must be 0<num<10");

     Scanner sc = new Scanner(System.in);

     for(int i=0;i<9;i+=1)

     {

         for(int j=0;j<9;j+=1)

         {

               s.grid[i][j] = sc.nextInt();

         }

    }

    res = s.is_valid();


    if(res==1)
    {

         result = s.sudoku_solve();

         if(result==false)

         {

            System.out.println("Sudoku cannot be solved");

         }

         else
         {
            System.out.println("The Sudoku is solved !!");

            for(int i=0;i<9;i+=1)

            {

                for(int j=0;j<9;j+=1)

                {

                   System.out.print(s.grid[i][j]);

                   System.out.print(" ");

                }

                System.out.print("\n");
            }

         }
    }

   else

   {

        System.out.print("The given sudoku is wrong !");
        System.out.print("\n");
   }

}
}
