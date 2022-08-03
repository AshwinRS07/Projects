import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
class SeatOccupancy
{
	String name="",no="";
	int status=0;
	public void FreeSeat()
	{
		name="";
		no="";
		status=0;
	}
	public void SeatHolderInfo(String name,String no)
	{
		System.out.println("Seat Holder Name:"+name+"\nMobile Number:"+no+"\n");
	}
}
public class MovieReservation extends Frame
{
	
	static SeatOccupancy Seats[][]=new SeatOccupancy[10][10];		
	public MovieReservation()
	{
		int i,j,x=300,y=200;
		String rowsample="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		TextField seats[][] = new TextField[10][10];
		Label L[] = new Label[10];
		Label C[] = new Label[10];
		Label Title,Screen;
		Button EXIT;
		Title = new Label("Welcome to AP SHAH Multiplex");
		Screen = new Label("SCREEN THIS WAY");
		Screen.setBounds(500,700,500,100);
		Title.setBounds(450,50,500,100);
		add(Title);	
		add(Screen);
		for(i=0;i<10;i++)
		{
			for(j=0;j<10;j++)
			{
				seats[i][j] = new TextField();
				seats[i][j].setEditable(false);
				add(seats[i][j]);
			}
		}
		EXIT = new Button("CLOSE");
		setLayout(null);
		EXIT.setBounds(100,100,50,50);
		add(EXIT);
		
		for(i=0;i<10;i++,y+=50)
		{
			L[i] = new Label(""+rowsample.charAt(i));
			L[i].setBounds(x-30,y+5,10,10);
			add(L[i]);

			C[i] = new Label(""+(i+1));
			if(i>4)
			{
				C[i].setBounds(y+150,180,20,10);
				add(C[i]);
				
			}
			else
			{
				C[i].setBounds(y+105,180,20,10);
				add(C[i]);			
			}			



			for(j=0;j<10;j++,x+=50)
			{
				if(j==5)
				{
					x+=50;
				}	
				seats[i][j].setBounds(x,y,20,20);
			}
			x=300;
		}
		for(i=0;i<10;i++)
		{
			for(j=0;j<10;j++)
			{
				if(Seats[i][j].status==0)
				{
					seats[i][j].setBackground(Color.GREEN);
				}
				else
				{
					seats[i][j].setBackground(Color.RED);
				}
			}
		}
		BtnListener listener = new BtnListener();
		EXIT.addActionListener(listener);
		setTitle("SEATS");
		setSize(1000,1000);
		setVisible(true);
	}
	private class BtnListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			String btnLabel = evt.getActionCommand();
			if(btnLabel.equals("CLOSE"))
			{
				dispose();
			}
		}
	}
	
	public static void main(String args[])
	{
		//SeatOccupancy Seats[][]=new SeatOccupancy[10][10];
		int n,i,j,r,c,choice,delflag=0;
		String name,no;
		char chr,chc;
		Scanner sc=new Scanner(System.in);
		//MovieReservation obj=new MovieReservation();
		for(i=0;i<10;i++)
		{
			for(j=0;j<10;j++)
			{
				Seats[i][j]=new SeatOccupancy();
			}
		}
		do
		{
		System.out.println("1.Book Tickets \n2.Show Seats \n3.Free a seat \n4.Show Seat Holder's Information \n5.Exit");
		choice=sc.nextInt();
		switch(choice)
		{
			case 1:
				System.out.println("How many seats do you want to book?");
				n=sc.nextInt();
				for(i=0;i<n;i++)
				{	

					System.out.println("Enter your seat : ");
					chr=sc.next().charAt(0);
					r=(int)(chr-65);
					c=sc.nextInt();
					c--;
					if(Seats[r][c].status==1)
						System.out.println("This seat is already booked.");
					else	
					{
						Seats[r][c].status=1;
						System.out.println("Enter your name: ");
						Seats[r][c].name=sc.next();
						System.out.println("Enter your contact number : ");
						Seats[r][c].no=sc.next();
						System.out.println("Your seat has been booked.");
					}
				}	
				break;
			case 2:
				/*System.out.println("\t\t\t1:Seat is booked.\n\t\t\t0:Seat is available\n\n\n\t\t\t\t\tScreen This Way!");
				System.out.print("Price\t");
				for(i=0;i<10;i++)
				{
					System.out.print("\t"+(i+1));
				}
				System.out.println();
				for(i=0;i<10;i++)
				{
					System.out.print(obj.TicketPrice(i)+"$\t"+(char)(i+65)+"|\t");
					for(j=0;j<10;j++)
					{
						System.out.print(Seats[i][j].status+"\t");
					}
					System.out.println();
				}*/
				MovieReservation ABCD = new MovieReservation();
				break;
			case 3:
				System.out.println("Enter name of seatholder : ");
				name=sc.next();
				for(i=0;i<10;i++)
				{
					for(j=0;j<10;j++)
					{
						if((Seats[i][j].name.trim()).equals(name))
						{
							Seats[i][j].FreeSeat();
							delflag=1;
						}	
					}
				}
				if(delflag==1)
				{
					System.out.println("The seat has been freed.");
					delflag=0;
				}
				else
					System.out.println("Seat is not reserved");
				break;
			case 4:
				System.out.println("Enter seat number : ");
				chr=sc.next().charAt(0);
				r=(int)(chr-65);
				c=sc.nextInt();
				c--;
				Seats[r][c].SeatHolderInfo(Seats[r][c].name,Seats[r][c].no);
				break;
			case 5:
				System.out.println("Thank You.");
				break;
			default:
				System.out.println("Invalid Input.Try Again.");
		}
		}while(choice!=5);
	}
	//SeatOccupancy Seats[][]=new SeatOccupancy[10][10];
	public int TicketPrice(int i)
	{
		if(i<3)
			return 100;
		else if(i<8)
			return 200;
		else
			return 300;
	}
}
