package Words;

public class CodeRunner implements Runnable 
{	
	String path;
	
	public CodeRunner(String wordPath) 
	{
		path=wordPath;		
	}
	
	public CodeRunner() {}
		
	@Override
    public void run() 
    {   		    	
		long end = System.currentTimeMillis();
		StartWordCount.countAndPrintLineWord(path);
		long begin = System.currentTimeMillis();
		System.out.println(end - begin);
		
    }
}
