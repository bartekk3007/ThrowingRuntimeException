public class Main
{
    public static void main(String[] args)
    {
        var thread = new Thread(Task.asRunnable(() ->
            {
                Thread.sleep(1000);
                System.out.println("Working");
                throw new Exception("Normal exception");
            }
        ));
        thread.start();
        throw new RuntimeException();
    }
}