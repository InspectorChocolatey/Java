/*
Topic: Difference Between User Threads Vs Daemon Threads In Java
Url:   http://javaconceptoftheday.com/difference-between-used-threads-vs-daemon-threads-in-java/


References:

  http://tutorials.jenkov.com/java-concurrency/creating-and-starting-threads.html


*/

=======================================================================
The two thread types in Java are <User-Threads> & <Daemon-Threads> 



    User Threads                Daemon Threads
====================        ======================
High priority & always      Low priority & always 
run in the foreground.      run in the background.

*specific tasks*            *supporting tasks*




 Commonly used Constructors of Thread class:

  Thread()
  Thread(String name)
  Thread(Runnable r)
  Thread(Runnable r,String name)


 Commonly used methods of Thread class:

  public void run(): is used to perform action for a thread.
  public void start(): starts the execution of the thread.JVM calls the run() method on the thread.
  public void sleep(long miliseconds): Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds.
  public void join(): waits for a thread to die.
  public void join(long miliseconds): waits for a thread to die for the specified miliseconds.
  public int getPriority(): returns the priority of the thread.
  public int setPriority(int priority): changes the priority of the thread.
  public String getName(): returns the name of the thread.
  public void setName(String name): changes the name of the thread.
  public Thread currentThread(): returns the reference of currently executing thread.
  public int getId(): returns the id of the thread.
  public Thread.State getState(): returns the state of the thread.
  public boolean isAlive(): tests if the thread is alive.
  public void yield(): causes the currently executing thread object to temporarily pause and allow other threads to execute.
  public void suspend(): is used to suspend the thread(depricated).
  public void resume(): is used to resume the suspended thread(depricated).
  public void stop(): is used to stop the thread(depricated).
  public boolean isDaemon(): tests if the thread is a daemon thread.
  public void setDaemon(boolean b): marks the thread as daemon or user thread.
  public void interrupt(): interrupts the thread.
  public boolean isInterrupted(): tests if the thread has been interrupted.
  public static boolean interrupted(): tests if the current thread has been interrupted.




//=============================================================//

/*
    Extending the Java Thread class. (Example A)
*/

public class CreateStartingThreads
{
  public static class MyThread extends Thread
  {
    @Override
    public void run()
    {
      System.out.println("Thread is running");
    }
  }  

  public static void main(String args[])
  {  
    Thread myThread = new Thread();

    myThread.start();  
  }  
}  

//=============================================================//

/*
    Java Threading via a runnable interface. (Example B)
*/

public class CreateStartingThreads
{  
  public static class MyRunable impliments Runnable
  {
    @Override
    public void run()
    {  
      System.out.println("thread is running...");  
    }  
  }

  public static void main(String args[])
  {  
    Thread myThread = new Thread(new MyRunnable());
    myThread.start(); 
  }  
}  

//=============================================================//

/*
    Extending the Java Thread class. (Example C)
*/

class Multi extends Thread
{  
  public void run()
  {  
    System.out.println("thread is running...");  
  }  

  public static void main(String args[])
  {  
    Multi t1=new Multi();  
    t1.start();  
  }  
}  

//=============================================================//

/*
    Java Threading via a runnable interface. (Example D)
*/

class Multi implements Runnable
{  
  public void run()
  {  

    System.out.println("thread is running...");  
  }  
  
  public static void main(String args[])
  {  
    Multi3 m1=new Multi3();  
    Thread t1 =new Thread(m1);  
    t1.start();  
  }  
}  

//=============================================================//