package patterns.decorator;


import java.io.*;
import java.util.Date;

public class LoggerExample {
    public static void main(String[] args) {
        ILogger logger=new Logger();
        logger.write("log message");
        ILogger logger1= new DateLogger(new Logger());
        logger1.write("log message 2");
        ILogger logger2= new AuthorLogger(new DateLogger( new Logger()));
        logger1.write("log message 3");
    }
}

interface ILogger{
    public void write(String message);


}
class Logger implements ILogger{

    @Override
    public void write(String message) {
        System.out.println("Console: " + message);
    }
}

class LoggerDecorator implements ILogger{
    ILogger iLogger;

    public LoggerDecorator(ILogger iLogger) {
        this.iLogger = iLogger;
    }

    @Override
    public void write(String message) {
        iLogger.write(message);

    }
}
class DateLogger extends LoggerDecorator{

    public DateLogger(ILogger iLogger) {
        super(iLogger);
    }

    @Override
    public void write(String message) {
        //делаем с текстом что нужно
        String newMessage=message+",date: "+ new Date();
        super.write(message);
    }
}

class AuthorLogger extends LoggerDecorator{

    public AuthorLogger(ILogger iLogger) {
        super(iLogger);
    }

    @Override
    public void write(String message) {
        String newMessage = message+ ",author: " + System.getProperty("user.name");
        super.write(message);
    }
}

class MyStream extends FilterInputStream{ //шифрующие потоки

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected MyStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        return super.read();
    }
}
class  MyOutputStream extends FilterOutputStream{

    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field <tt>this.out</tt> for later use, or
     *            <code>null</code> if this instance is to be
     *            created without an underlying stream.
     */
    public MyOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException { //шифруем входящие данные
        super.write(b);
    }
}