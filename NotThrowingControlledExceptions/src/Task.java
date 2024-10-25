public interface Task
{
    void run() throws Exception;
        static <T extends Throwable> void throwAs(Exception t) throws T
    {
        throw (T) t;
    }

    static Runnable asRunnable(Task task)
    {
        return () ->
        {
            try
            {
                task.run();
            }
            catch(Exception e)
            {
                Task.<RuntimeException>throwAs(e);
            }
        };
    }
}