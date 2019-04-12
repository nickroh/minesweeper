package mine;

import java.util.Scanner;

public class MineSweeper {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		char mine[][]=new char[105][105];
		char map[][]=new char[105][105];
		while(true)
		{
			System.out.println("게임을 시작하시겠습니까?(Y/N)");
			String start=new String();
			start=scanner.nextLine();
			if(start.equals("N"))
			{
				System.out.println("Are you sure to quit? quit->1 stay->2");
				int start2;
				start2=scanner.nextInt();
				if(start2==1)
				{
					System.out.println("f*** you");
					break;
				}
				else
				{
					System.out.println("yeah!!");
				}
			}
			int n;
			System.out.println("지뢰의 개수는?");
			n=scanner.nextInt();

			renew(map,mine);
			make_mine(mine,n);
			show(map);
			boolean over=true;
			while(true)
			{
				System.out.println("좌표를 입력하세요");
				int x,y;
				x=scanner.nextInt();
				y=scanner.nextInt();
				int check;
				check=checker(x,y,mine);
				if(check==100)
				{
					map[x][y]='▣';
					over=false;
					break;
				}
				else
				{
					char cc=(char)(check+'0');
					map[x][y]=cc;
				}
				clearscreen();
				show(map);
			}
			if(over==false)
			{
				
				clearscreen();
				System.out.println("GameOver");
				showend(mine);
			}
			else
			{
				System.out.println("GameClear");
			}
			
		}
	}
	public static void clearscreen()
	{
		for (int i = 0; i < 80; i++)
		      System.out.println("");
	}
	public static void renew(char map[][],char mine[][])
	{
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				map[i][j]='■';
			}
		}
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				mine[i][j]='▥';
			}
		}
	}
	public static void showend(char mine[][])
	{
		for(int i=1;i<11;i++)
		{
			for(int j=1;j<11;j++)
			{
				System.out.printf("%c ",mine[j][i]);
			}
			System.out.println();
		}
	}
	public static void make_mine(char mine[][],int n)
	{
		for(int i=0;i<n;i++)
		{
			int x,y;
			x=(int)(Math.random()*10.0+1);
			y=(int)(Math.random()*10.0+1);
			int flag=1;
			flag=check(x,y,mine);
			if(flag==1) mine[y][x]='▣';
			else 
			{
				i--;
			}
		}
	}
	public static int check(int x, int y, char mine[][])
	{
		int flag;
		if(mine[y][x]=='▣')
		{
			flag=0;
		}
		else
		{
			flag=1;
		}		
		return flag;	
	}
	public static void show(char map[][])
	{
		for(int i=1;i<11;i++)
		{
			for(int j=1;j<11;j++)
			{
				System.out.printf("%c ",map[j][i]);
			}
			System.out.println();
		}
	}
	public static int checker(int a, int b,char mine[][])
	{
		if(mine[a][b]=='▣')
		{
			return 100;
		}
		else
		{
			int cnt=0;
			if(mine[a+1][b]=='▣')
			{
				cnt++;
			}
			if(mine[a+1][b+1]=='▣')
			{
				cnt++;
			}
			if(mine[a+1][b-1]=='▣')
			{
				cnt++;	
			}
			if(mine[a][b+1]=='▣')
			{
				cnt++;
			}
			if(mine[a][b-1]=='▣')
			{
				cnt++;
			}
			if(mine[a-1][b]=='▣')
			{
				cnt++;
			}
			if(mine[a-1][b+1]=='▣')
			{
				cnt++;
			}
			if(mine[a-1][b-1]=='▣')
			{
				cnt++;
			}
			return cnt;	
		}
		
	}

}

