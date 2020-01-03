import java.util.*

class sudoku {

    int row_num;
    int col_num;
    int grid[][] = new int[100][100];
    int i_pos;
    int j_pos;
    boolean result;

    sudoku()
    {

       row_num = 4;
       col_num = 4;
       i_pos = 0;
       j_pos = 0;
       result=false;

        

    }

boolean sudoku_solve()
{

          int temp_i_pos=0;
          int temp_j_pos=0;

          if(unassigned_cell_finder())
          {
              System.out.print("Sudoku is Solved...");
              return true;
          }

          else
          {
              for(int num=0;num<4;num+=1)
 
              {
                     if(is_safe(num,i_pos,j_pos))
                     {

                             grid[i_pos][j_pos]=num;

                             temp_i_pos = i_pos;
                             temp_j_pos = j_pos;

                             result = sudoku_solve();
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

            return false;
        }

}


boolean unassigned_cell_finder()
{


           for(int i=0;i<row_num;i+=1)
           {
              for(int j=0;j<col_num;j+=1)

              {

                   if(grid[i][j]==-1)
 
                   {
                         i_pos = i;
                         j_pos = j; 
                         return(true);
                   }
              }
           }

           return(false);
}

boolean is_safe(int num, int i_pos, int j_pos)
{

      int row = i_pos;
      int column = j_pos;

      for(int i=0;i<4;i+=1)
 
      {
       
             if(grid[i_pos][i]==num)

             {

                   return false;

             }

      }

      for(int i=0;i<4;i+=1)

      {

              if(grid[i][j_pos]==num)

              {

                   return false;

              }

      }

     return true;

}
      
  
public static void main(String args[])

{

     sudoku s = new sudoku();

     System.out.println("Please enter a 4*4 sudoku array: Please enter \"-1\" for blank cells and the number strictly must be 0<num<5");

     Scanner sc = new Scanner(System.in);

     for(int i=0;i<4;i+=1)

     {

         for(int j=0;j<4;j+=1)

         {

               s.grid[i][j] = sc.nextInt();

         }

    }

    result = s.sudoku_solve();
    if(result == false)

    {

          System.out.println("The given Sudoku Cannot be solved");
          
  
    }
    else

    {
    

             System.out.println("The Sudoku is solved !!");

             for(int i=0;i<4;i+=1)

             {

                  for(int j=0;j<4;j+=1)

                  {

                      System.out.print(s.grid[i][j]);

                      System.out.print(" ");

                  }

                  System.out.print("\n");
             }
     }
}

}
